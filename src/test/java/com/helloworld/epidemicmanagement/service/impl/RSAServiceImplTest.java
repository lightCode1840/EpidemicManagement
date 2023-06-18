package com.helloworld.epidemicmanagement.service.impl;

class RSAServiceImplTest {

    RSAServiceImpl rsaServiceImpl;

    void getPublicKey() throws InterruptedException {
        String publicKey = rsaServiceImpl.getPublicKey();
        System.out.println("--------------");
        System.out.println(rsaServiceImpl.encode("123456789", publicKey));
        Thread.sleep(100000);
    }
}
