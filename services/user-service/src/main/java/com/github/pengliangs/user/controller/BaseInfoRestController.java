package com.github.pengliangs.user.controller;

import com.github.pengliangs.common.core.responce.ResultData;
import com.github.pengliangs.user.mapper.BaseInfoMapper;
import com.github.pengliangs.user.module.vo.BaseInfoVO;
import com.github.pengliangs.user.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class BaseInfoRestController {

    @Autowired
    private BaseInfoMapper baseInfoMapper;

    @Autowired
    private BaseInfoService baseInfoService;

    @GetMapping("/ping")
    public String ping() {
        return "success";
    }

    @GetMapping("/{userId:\\d+}")
    public BaseInfoVO getUserBaseInfoById(@PathVariable("userId") Long userId) {
        return baseInfoMapper.toBaseInfoVO(baseInfoService.getById(userId));
    }

    @GetMapping("/two")
    public BaseInfoVO resultDataTwo() {
        BaseInfoVO baseInfoVO = new BaseInfoVO();
        baseInfoVO.setId(1L);
        baseInfoVO.setUserNickName("张三");
        int i = 1/0;
        int b = 0/1;
        return baseInfoVO;
    }
}
