package com.example.test.pojo;


import lombok.Data;
import org.springframework.stereotype.Component;
import com.example.Commen.Constant.Constant;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Component
public class Cleck implements Serializable {
     static  transient String serialVersionUID  = Constant.serialVersionUID ;

     @NotEmpty
     private String cleakName;

     @Size(min=6,message = "密码长度不小于6位")
     private String cleak_Pwd;

     private String cleakSex;
     /*
      * 权限： 1：管理员  2.员工
      */
     private String cleakAuth;

     private String cleakPhone;
     /**
      * 身份证
      */
     private String cleakCard;

     private String cleakId;
     /**
      * 岗位名称
      */

     private String cleakJob;

     /**
      * 上级领导
      */
     private String cleakLeader;
     private String roleEmail;

     public static String getSerialVersionUID() {
          return serialVersionUID;
     }

     @Override
     public String toString() {
          return "Cleck{" +
                  "cleakName='" + cleakName + '\'' +
                  ", cleak_Pwd='" + cleak_Pwd + '\'' +
                  ", cleakSex='" + cleakSex + '\'' +
                  ", cleakAuth='" + cleakAuth + '\'' +
                  ", cleakPhone='" + cleakPhone + '\'' +
                  ", cleakCard='" + cleakCard + '\'' +
                  ", cleakId='" + cleakId + '\'' +
                  ", cleakJob='" + cleakJob + '\'' +
                  ", cleakLeader='" + cleakLeader + '\'' +
                  ", roleEmail='" + roleEmail + '\'' +
                  '}';
     }
     public Cleck(String cleakName, String cleak_Pwd, String cleakSex, String cleakAuth, String cleakPhone, String cleakCard, String cleakId, String cleakJob, String cleakLeader, String roleEmail) {
          this.cleakName = cleakName;
          this.cleak_Pwd = cleak_Pwd;
          this.cleakSex = cleakSex;
          this.cleakAuth = cleakAuth;
          this.cleakPhone = cleakPhone;
          this.cleakCard = cleakCard;
          this.cleakId = cleakId;
          this.cleakJob = cleakJob;
          this.cleakLeader = cleakLeader;
          this.roleEmail = roleEmail;
     }

     public Cleck() {
     }

     public static void setSerialVersionUID(String serialVersionUID) {
          Cleck.serialVersionUID = serialVersionUID;
     }

     public String getCleakName() {
          return cleakName;
     }

     public void setCleakName(String cleakName) {
          this.cleakName = cleakName;
     }

     public String getCleak_Pwd() {
          return cleak_Pwd;
     }

     public void setCleak_Pwd(String cleak_Pwd) {
          this.cleak_Pwd = cleak_Pwd;
     }

     public String getCleakSex() {
          return cleakSex;
     }

     public void setCleakSex(String cleakSex) {
          this.cleakSex = cleakSex;
     }

     public String getCleakAuth() {
          return cleakAuth;
     }

     public void setCleakAuth(String cleakAuth) {
          this.cleakAuth = cleakAuth;
     }

     public String getCleakPhone() {
          return cleakPhone;
     }

     public void setCleakPhone(String cleakPhone) {
          this.cleakPhone = cleakPhone;
     }

     public String getCleakCard() {
          return cleakCard;
     }

     public void setCleakCard(String cleakCard) {
          this.cleakCard = cleakCard;
     }

     public String getCleakId() {
          return cleakId;
     }

     public void setCleakId(String cleakId) {
          this.cleakId = cleakId;
     }

     public String getCleakJob() {
          return cleakJob;
     }

     public void setCleakJob(String cleakJob) {
          this.cleakJob = cleakJob;
     }

     public String getCleakLeader() {
          return cleakLeader;
     }

     public void setCleakLeader(String cleakLeader) {
          this.cleakLeader = cleakLeader;
     }

     public String getRoleEmail() {
          return roleEmail;
     }

     public void setRoleEmail(String roleEmail) {
          this.roleEmail = roleEmail;
     }
}
