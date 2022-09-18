package com.example.test.pojo;


import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;
import com.example.Commen.Constant.Constant;

import javax.validation.constraints.*;
import java.io.Serializable;

@Component
public class Role implements Serializable {
    static  transient String serialVersionUID  = Constant.serialVersionUID ;

    @NotBlank(message = "用户账号不能为空")
    private String roleName;
    @Size(message = "长度最小为6位", min = 6)
    private String role_Pwd;
    @Range(min = 0, max = 2, message = "性别只能为，0：未知，1：男，2：女 ")
    private String roleSex;
    /*
     * 权限： 2：管理员  1.员工 0,无权限
     */
    @NotNull(message = "权限不能为空")
    @Range(min = 0,max = 2)
    private String roleAuth;

    @NotEmpty(message = "手机号不可为空")
    private String rolePhone;
    /**
     * 身份证
     */
    private String roleCard;

    private String roleId;
    /**
     * 岗位名称
     */

    private String roleJob;

    /**
     * 上级领导
     */
    private String roleLeader;
    private String roleEmail;

    public static String getSerialVersionUID() {
        return serialVersionUID;
    }

    public Role(String roleName, String role_Pwd, String roleSex, String roleAuth, String rolePhone, String roleCard, String  roleId, String roleJob, String roleLeader, String roleEmail) {
        this.roleName = roleName;
        this.role_Pwd = role_Pwd;
        this.roleSex = roleSex;
        this.roleAuth = roleAuth;
        this.rolePhone = rolePhone;
        this.roleCard = roleCard;
        this.roleId = roleId;
        this.roleJob = roleJob;
        this.roleLeader = roleLeader;
        this.roleEmail = roleEmail;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                ", role_Pwd='" + role_Pwd + '\'' +
                ", roleSex='" + roleSex + '\'' +
                ", roleAuth='" + roleAuth + '\'' +
                ", rolePhone='" + rolePhone + '\'' +
                ", roleCard='" + roleCard + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleJob='" + roleJob + '\'' +
                ", roleLeader='" + roleLeader + '\'' +
                ", roleEmail='" + roleEmail + '\'' +
                '}';
    }

    public String getRoleLeader() {
        return roleLeader;
    }

    public String getRoleEmail() {
        return roleEmail;
    }

    public void setRoleEmail(String roleEmail) {
        this.roleEmail = roleEmail;
    }

    public void setRoleLeader(String roleLeader) {
        this.roleLeader = roleLeader;
    }

    public static void setSerialVersionUID(String serialVersionUID) {
        Role.serialVersionUID = serialVersionUID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRole_Pwd() {
        return role_Pwd;
    }

    public void setRole_Pwd(String role_Pwd) {
        this.role_Pwd = role_Pwd;
    }

    public String getRoleSex() {
        return roleSex;
    }

    public void setRoleSex(String roleSex) {
        this.roleSex = roleSex;
    }

    public String getRoleAuth() {
        return roleAuth;
    }

    public void setRoleAuth(String roleAuth) {
        this.roleAuth = roleAuth;
    }

    public String getRolePhone() {
        return rolePhone;
    }

    public void setRolePhone(String rolePhone) {
        this.rolePhone = rolePhone;
    }

    public String getRoleCard() {
        return roleCard;
    }

    public void setRoleCard(String roleCard) {
        this.roleCard = roleCard;
    }

    public String getRoleId() {
        return String.valueOf(roleId);
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleJob() {
        return roleJob;
    }

    public void setRoleJob(String roleJob) {
        this.roleJob = roleJob;
    }

    public Role() {
    }
}
