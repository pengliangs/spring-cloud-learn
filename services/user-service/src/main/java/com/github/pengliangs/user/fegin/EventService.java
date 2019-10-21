package com.github.pengliangs.user.fegin;

import com.github.pengliangs.common.core.feign.ClientConstant;
import com.github.pengliangs.common.core.response.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author pengliang
 * @date 2019/10/21 22:49
 */
@FeignClient(ClientConstant.EVENT_SERVICE)
public interface EventService {

	@GetMapping("/event/ping")
	ResultData pingEvent();
}
