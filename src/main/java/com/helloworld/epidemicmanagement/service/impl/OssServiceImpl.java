package com.helloworld.epidemicmanagement.service.impl;

import com.helloworld.epidemicmanagement.config.OssConfig;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fsyj
 */
@Service
public class OssServiceImpl {

    @Autowired
    private OssConfig ossConfig;

    /**
     * 获取上传凭证
     * @return Token
     */
    public String createAuth() {
        Auth auth = Auth.create(ossConfig.getAccessKey(), ossConfig.getSecretKey());
        StringMap map = new StringMap();
        map.put("returnBody", "{\"fileUrl\": \""+ossConfig.getDomain()+"${key}\"}");
        return auth.uploadToken(ossConfig.getOssName(), null, ossConfig.getExpire(), map);
    }
}
