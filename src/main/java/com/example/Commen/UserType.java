package com.example.Commen;

/**
 * @author: xieyong
 * @date: 2019/4/23 15:12
 * @Description:
 */
enum UserType {
    ADMIN("1", "管理员"),
    TEACHER("2", "员工");


    private final String code;

    private final String desc;

    UserType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UserType getEventByCode(String code) {
        UserType[] values = UserType.values();
        for (UserType type : values) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
