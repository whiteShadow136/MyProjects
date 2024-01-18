package org.example.enums;

/**
 * @Description:org.example.enums
 * @Date:2023/12/13
 * @Author:谢锦创
 */
public enum Result {
    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    ERROR("0002", "异常");

    private String code;
    private String msg;

    Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
