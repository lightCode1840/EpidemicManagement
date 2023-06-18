package com.helloworld.epidemicmanagement.service.impl;

import com.power.common.util.RSAUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("rsaServiceImpl")
public class RSAServiceImpl {

    static Map<String,String> keyMap = RSAUtil.createKeys(2048);

    public String getPublicKey() {
        return keyMap.get(RSAUtil.PUBLIC_KEY);
    }

    public String decode(String encode) {
        return RSAUtil.decryptString(encode, keyMap.get(RSAUtil.PRIVATE_KEY));
    }

    public String encode(String raw, String publicKey) {
        return RSAUtil.encryptString(raw, publicKey);
    }

}
