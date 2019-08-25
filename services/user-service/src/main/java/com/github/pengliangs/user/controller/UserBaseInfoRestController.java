package com.github.pengliangs.user.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户基本服务
 *
 * @author pengliang
 * @date 2019/8/25 9:51
 */
@RestController
@RequestMapping(value = "/base/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserBaseInfoRestController {

    @GetMapping("/ping")
    public String ping() {
        return "success";
    }

}
