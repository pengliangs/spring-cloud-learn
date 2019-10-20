package com.github.pengliangs.common.core.utils;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * @author pengliang
 * @date 2019/10/20 14:15
 */
public class IdWorkerUtils {

	/**
	 * 获取workerId
	 *
	 * @return
	 */
	static long getId() {
		return IdWorker.getId();
	}

	/**
	 * <p>
	 * 时间 ID = Time + ID
	 * </p>
	 * <p>
	 * 例如：可用于商品订单 ID
	 * </p>
	 */
	static String getTimeId() {
		return IdWorker.getTimeId();
	}

	/**
	 * 使用ThreadLocalRandom获取UUID获取更优的效果 去掉"-"
	 *
	 * @return
	 */
	static String get32UUID() {
		return IdWorker.get32UUID();
	}

	/**
	 * string类型workerId
	 *
	 * @return
	 */
	static String getIdStr() {
		return IdWorker.getIdStr();
	}

	/**
	 * 格式化的毫秒时间
	 *
	 * @return
	 */
	static String getMillisecond() {
		return IdWorker.getMillisecond();
	}
}
