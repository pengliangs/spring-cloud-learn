package com.github.pengliangs.user;

import com.github.pengliangs.common.security.annotation.EnableAuthResourceServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author: pengliang
 * @date: 2019/8/23 18:21
 * @description：用户服务
 */
@MapperScan("com.github.pengliangs.user.dao")
@EnableAuthResourceServer
@SpringCloudApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
