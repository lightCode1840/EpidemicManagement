package com.helloworld.epidemicmanagement.controller;

import com.google.code.kaptcha.Producer;
import com.helloworld.epidemicmanagement.utils.AjaxResult;
import com.helloworld.epidemicmanagement.utils.Base64;
import com.helloworld.epidemicmanagement.utils.RedisCache;
import com.helloworld.epidemicmanagement.utils.UUIDUtil;
import com.helloworld.epidemicmanagement.utils.constans.Constants;
import io.swagger.annotations.Api;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author fsyj
 */
@Api("验证码模块")
@RestController
@RequestMapping("/api/1/code")
public class CaptchaController {

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Resource
    private RedisCache redisCache;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult getCode() throws IOException {
        AjaxResult ajax = AjaxResult.success();

        // 保存验证码信息
        String uuid = UUIDUtil.getUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        // 先通过captcha获取一个验证码文本，再通过截取@获取前半部分，生成图片
        String capText = captchaProducerMath.createText();
        capStr = capText.substring(0, capText.lastIndexOf("@"));
        code = capText.substring(capText.lastIndexOf("@") + 1);
        image = captchaProducerMath.createImage(capStr);

        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));
        return ajax;
    }
}
