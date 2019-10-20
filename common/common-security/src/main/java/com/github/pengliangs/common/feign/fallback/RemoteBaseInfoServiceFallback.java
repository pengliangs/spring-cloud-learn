package com.github.pengliangs.common.feign.fallback;

import com.github.pengliangs.common.feign.RemoteBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pengliang
 * @date 2019/10/20 19:31
 */
@Component
@Slf4j
public class RemoteBaseInfoServiceFallback implements RemoteBaseInfoService {

	@Override
	public String ping() {
		log.info("调用ping失败");
		return "error";
	}

}
