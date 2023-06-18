package com.helloworld.epidemicmanagement.domain;

/**
 * @author fsyj
 */
public enum HealthEnum {
    /**
     * 超过3天未进行核酸检测且最近一次核酸检测不为阳性
     */
    NOT_DETECTED,
    /**
     * 最近一次核酸检测未超过3天，且最近一次不为阳性
     */
    NO_RISK,
    /**
     * 最近一次核酸检测结果为阳性
     */
    POSITIVE
}
