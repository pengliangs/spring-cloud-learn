package com.github.pengliangs.common.feign;

import com.github.pengliangs.common.core.feign.ClientConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 用户基础信息表 服务类
 * </p>
 *
 * @author pengliang
 * @since 2019-08-26
 */
@FeignClient(ClientConstant.USER_SERVICE)
@RequestMapping(value = "/base/info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public interface RemoteBaseInfoService {

	@GetMapping("/ping")
	String ping();

}
