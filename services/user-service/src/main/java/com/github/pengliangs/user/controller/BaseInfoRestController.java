package com.github.pengliangs.user.controller;

import com.github.pengliangs.common.core.enums.BaseErrorEnum;
import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.core.utils.ApiAssert;
import com.github.pengliangs.common.security.annotation.IgnoreAuth;
import com.github.pengliangs.user.fegin.EventService;
import com.github.pengliangs.user.mapper.BaseInfoMapper;
import com.github.pengliangs.user.module.dto.BaseInfoDTO;
import com.github.pengliangs.user.module.entity.BaseInfo;
import com.github.pengliangs.user.module.vo.BaseInfoVO;
import com.github.pengliangs.user.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


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

	@Autowired
	private EventService eventService;

	@IgnoreAuth
	@GetMapping("/ping")
	public String ping() {
		return "success";
	}

	@IgnoreAuth
	@GetMapping("/ping2/{name}")
	public String ping2(@PathVariable("name") String name) {
		return name;
	}

	@GetMapping("/ping3")
	public ResultData ping3() {
		return eventService.pingEvent();
	}

	@GetMapping("/ping4")
	public String ping4() {
		return "success4";
	}

	@GetMapping("/{userId:\\d+}")
	public BaseInfoVO getUserBaseInfoById(@PathVariable("userId") Long userId) {
		return baseInfoMapper.toBaseInfoVO(baseInfoService.getById(userId));
	}

	@PostMapping
	public BaseInfoVO save(@RequestBody BaseInfoDTO baseInfoDTO) {
		BaseInfo baseInfo = baseInfoMapper.toBaseInfo(baseInfoDTO);
		ApiAssert.isTrue(BaseErrorEnum.SAVE_FAILURE, baseInfoService.save(baseInfo));
		return baseInfoMapper.toBaseInfoVO(baseInfo);
	}
}
