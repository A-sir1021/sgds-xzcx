package com.example.Commen.MsgUtil;

public class CodeMsg {
    private final String code;
    private final String msg;
    private CodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CodeMsg fillArgs(Object... args) {//带自定义格式化参数的错误信息
        String code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code,message);
    }

    /**
     * 通用异常
     */
    public static CodeMsg SUCCESS = new CodeMsg("0", "SUCESS");
    public static CodeMsg SEND_SUNCC = new CodeMsg("0", "邮件发送成功，请查看");
    public static CodeMsg DEFULT = new CodeMsg("0", "false");
    public static CodeMsg SEND_FAIL = new CodeMsg("0", "邮件发送失败，请联系管理员");

    public static CodeMsg SERVER_ERROR = new CodeMsg("500100", "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg("500101", "参数校验异常:%s");
    /**
     * 登录模块5002XX
     */
    public static final CodeMsg MOBILE_EMPTY = new CodeMsg("500211", "手机号/密码错误");
    public static final CodeMsg MOBILE_ERROR = new CodeMsg("500211", "手机号格式错误");
    public static final CodeMsg EMAIL_ERROR = new CodeMsg("500211", "邮箱格式错误");
    public static final CodeMsg EMAIL_FAIL = new CodeMsg("500200", "邮箱发送失败");
    public static final CodeMsg USER_ERROR = new CodeMsg("500211", "用户验证失败");
    public static final CodeMsg SALA_ERROR = new CodeMsg("500211", "未查询到薪资信息");

    public static final CodeMsg USER_NOT_EXITS = new CodeMsg("500211", "用户不存在");
    public static final CodeMsg PASSWORD_ERROR = new CodeMsg("500211", "密码错误");
    public static final CodeMsg AUTH_NONE = new CodeMsg("500403", "无权访问");
    public static final CodeMsg LOGIN_Fail = new CodeMsg("fail", "登录失败");
    public static final CodeMsg AUTH_Fail = new CodeMsg("fail", "权限认证失败/会话过期，请重新登录");

    public static final CodeMsg LOGIN_TYPE = new CodeMsg("type", "请求方式不正确，请重新登录");
}
