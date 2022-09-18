package com.example.Commen.Util;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class MachineIp {

    private static volatile String ipAddr;

    /**
     * 获取主机ip
     * @return
     */
    public static String getHostIp() {

        String sIP = "";
        InetAddress ip = null;
        try {
            boolean bFindIP = false;
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                if (bFindIP){
                    break;
                }

                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    ip = ips.nextElement();
                    if (!ip.isLoopbackAddress()
                            && ip.getHostAddress().matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
                        bFindIP = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != ip){
            sIP = ip.getHostAddress();
        }
        return sIP;
    }

    public static String getIp() throws Exception {
        if (null != ipAddr) {
            return ipAddr;
        } else {
            Enumeration netInterfaces;
            try {
                netInterfaces = NetworkInterface.getNetworkInterfaces();
            } catch (SocketException var6) {
                throw new Exception(var6);
            }

            String localIpAddress = null;

            while(netInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface)netInterfaces.nextElement();
                Enumeration ipAddresses = netInterface.getInetAddresses();

                while(ipAddresses.hasMoreElements()) {
                    InetAddress ipAddress = (InetAddress)ipAddresses.nextElement();
                    if (isPublicIpAddress(ipAddress)) {
                        String publicIpAddress = ipAddress.getHostAddress();
                        ipAddr = publicIpAddress;
                        return publicIpAddress;
                    }

                    if (isLocalIpAddress(ipAddress)) {
                        localIpAddress = ipAddress.getHostAddress();
                    }
                }
            }

            ipAddr = localIpAddress;
            return localIpAddress;
        }
    }

    private static boolean isPublicIpAddress(InetAddress ipAddress) {
        return !ipAddress.isSiteLocalAddress() && !ipAddress.isLoopbackAddress() && !isV6IpAddress(ipAddress);
    }

    private static boolean isLocalIpAddress(InetAddress ipAddress) {
        return ipAddress.isSiteLocalAddress() && !ipAddress.isLoopbackAddress() && !isV6IpAddress(ipAddress);
    }

    private static boolean isV6IpAddress(InetAddress ipAddress) {
        return ipAddress.getHostAddress().contains(":");
    }

    public static String getHostName() throws Exception {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException var1) {
            throw new Exception(var1);
        }
    }


    /**
     * 请求的ip
     */
    public static String getIpAddr (HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 处理多IP的情况（只取第一个IP）
        if (ip != null && ip.contains(",")) {
            String[] ipArray = ip.split(",");
            ip = ipArray[0];
        }
        return ip;
    }
}

