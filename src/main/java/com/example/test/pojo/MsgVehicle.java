package com.example.test.pojo;

import com.example.Commen.Constant.Constant;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class MsgVehicle implements Serializable {
    static  transient String serialVersionUID  = Constant.serialVersionUID ;

    //@NotEmpty(message = "手机号不可为空")
    private String rolePhone;
    //@Size(message = "长度最小为6位", min = 6)
    private String role_Pwd;
    private String role_name;
    private String Msg;
    private String Fail;
    private int Data;
    private int Code;
    private String Succ;

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public String getRole_name() {
        return role_name;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "MsgVehicle{" +
                "rolePhone='" + rolePhone + '\'' +
                ", role_Pwd='" + role_Pwd + '\'' +
                ", role_name='" + role_name + '\'' +
                ", Msg='" + Msg + '\'' +
                ", Fail='" + Fail + '\'' +
                ", Data=" + Data +
                ", Code=" + Code +
                ", Succ='" + Succ + '\'' +
                '}';
    }

    public String getSucc() {
        return Succ;
    }

    public void setSucc(String succ) {
        Succ = succ;
    }

    public static String getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(String serialVersionUID) {
        MsgVehicle.serialVersionUID = serialVersionUID;
    }

    public String getRolePhone() {
        return rolePhone == null? "":rolePhone;
    }

    public void setRolePhone(String rolePhone) {
        this.rolePhone = rolePhone;
    }

    public String getRole_Pwd() {
        return role_Pwd;
    }

    public void setRole_Pwd(String role_Pwd) {
        this.role_Pwd = role_Pwd;
    }

    public String getMsg() {
        return Msg == null?"":Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getFail() {
        return Fail;
    }

    public void setFail(String fail) {
        Fail = fail;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }
}
