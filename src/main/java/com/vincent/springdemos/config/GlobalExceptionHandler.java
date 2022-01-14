package com.vincent.springdemos.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * author vincent
 * create at 2022/1/14
 * Description
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public Object handler(HttpServletRequest req, HttpServletResponse res, Exception e) {
        log.info("Restful Http请求发生异常...");

        if (res.getStatus() == HttpStatus.BAD_REQUEST.value()) {
            log.info("修改返回状态值为200");
            res.setStatus(HttpStatus.OK.value());
        }

        if (e instanceof NullPointerException) {
            log.error("代码00：" + e.getMessage(), e);
            return "发生空指针异常";
        } else if (e instanceof IllegalArgumentException) {
            log.error("代码01：" + e.getMessage(), e);
            return "请求参数类型不匹配";
        } else if (e instanceof SQLException) {
            log.error("代码02：" + e.getMessage(), e);
            return "数据库访问异常";
        } else {
            log.error("代码99：" + e.getMessage(), e);
            return e.getMessage();
        }
    }
}
