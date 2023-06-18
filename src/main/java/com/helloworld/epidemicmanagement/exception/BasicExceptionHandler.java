package com.helloworld.epidemicmanagement.exception;

import com.helloworld.epidemicmanagement.utils.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fsyj
 */
@Slf4j
@RestControllerAdvice
public class BasicExceptionHandler {

    /**
     * 未知异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResult exceptionHandler(Exception e) {
        // 把错误信息输入到日志中
        e.printStackTrace();
        log.error(e.getCause().getMessage());
        return AjaxResult.error(e.getMessage());
    }
}
