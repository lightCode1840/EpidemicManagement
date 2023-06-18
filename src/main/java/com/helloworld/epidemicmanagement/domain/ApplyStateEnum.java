package com.helloworld.epidemicmanagement.domain;

/**
 * @author fsyj
 */
public enum ApplyStateEnum {
    /**
     * 成功
     */
    SUCCESS("0"),
    /**
     * 失败
     */
    FAILED("1"),
    /**
     * 处理中
     */
    PROCESS("2"),
    /**
     * 失效
     */
    INVALID("3");

    private String state;

    ApplyStateEnum(String state) {
        this.state = state;
    }


    public String getState() {
        return state;
    }
}
