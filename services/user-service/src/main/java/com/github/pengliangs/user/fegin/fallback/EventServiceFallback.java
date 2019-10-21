package com.github.pengliangs.user.fegin.fallback;

import com.github.pengliangs.common.core.response.ResultData;
import com.github.pengliangs.user.fegin.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pengliang
 * @date 2019/10/21 22:52
 */
@Slf4j
@Component
public class EventServiceFallback implements EventService {

	@Override
	public ResultData pingEvent() {
		log.error("pingEvent error");
		return ResultData.failure();
	}

}
