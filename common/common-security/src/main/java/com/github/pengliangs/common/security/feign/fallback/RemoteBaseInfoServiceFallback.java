package com.github.pengliangs.common.security.feign.fallback;

import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.common.security.feign.RemoteBaseInfoService;
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
	public ResultData ping(String head) {
		log.info("调用ping失败:{}",head);
		return ResultData.failure();
	}

	@Override
	public ResultData ping2(String name, String head) {
		log.info("调用ping2失败:{}",head);
		return ResultData.failure();
	}

}
