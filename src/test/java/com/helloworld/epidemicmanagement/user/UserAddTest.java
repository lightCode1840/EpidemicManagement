package com.helloworld.epidemicmanagement.user;

import com.helloworld.epidemicmanagement.domain.User;
import com.helloworld.epidemicmanagement.service.UserService;
import com.helloworld.epidemicmanagement.utils.UUIDUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserAddTest {

    PasswordEncoder passwordEncoder;

    UserService userServiceImpl;



    public void addUser() {
        for (int i = 0; i < 10; i++) {
            String name = "测试账号" + UUIDUtil.getUUID();
            User user = new User(null, name.substring(0, 20), "0", getRandom1(18), "月球", "月海",
                    getRandom1(11), "0", "0", "#", passwordEncoder.encode("123456789"));
            userServiceImpl.insert(user);
        }
    }

    public static String getRandom1(int len) {
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0; i < len; i++) {
            buffer.append((int) (Math.random() * 9));
        }
        return buffer.toString();
    }

}
