package com.helloworld.epidemicmanagement.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OssServiceImplTest {

    @Resource
    OssServiceImpl ossServiceImpl;

    @Test
    void createAuth() {
        Assertions.assertNotNull(ossServiceImpl.createAuth());
    }
}
