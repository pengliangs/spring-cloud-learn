package com.github.pengliangs.common.security.feign;

import com.github.pengliangs.common.core.feign.ClientConstant;
import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.security.constant.SecurityConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author pengliang
 * @since 2019-08-26
 */
@FeignClient(ClientConstant.USER_SERVICE)
public interface RemoteBaseInfoService {

	@GetMapping("/base/info/ping")
	ResultData ping(@RequestHeader(SecurityConstants.IGNORE_AUTH_HEAD) String head);

	@GetMapping("/base/info/ping2/{name}")
	ResultData ping2(@PathVariable("name")String name,@RequestHeader(SecurityConstants.IGNORE_AUTH_HEAD) String head);
}
