package com.github.pengliangs.common.security.aspect;

import cn.hutool.core.util.StrUtil;
import com.github.pengliangs.common.security.annotation.IgnoreAuth;
import com.github.pengliangs.common.security.constant.SecurityConstants;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pengliang
 * @date 2019/10/20 21:41
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class SecurityIgnoreAuthAspect implements Ordered {

	private final HttpServletRequest request;

	@SneakyThrows
	@Around("@annotation(ignoreAuth)")
	public Object around(ProceedingJoinPoint point, IgnoreAuth ignoreAuth) {
		String header = request.getHeader(SecurityConstants.IGNORE_AUTH_HEAD);
		if (ignoreAuth.value() && !StrUtil.equals(SecurityConstants.IGNORE_AUTH_HEAD_VALUE, header)) {
			log.warn("访问接口 {} 没有权限", point.getSignature().getName());
			throw new AccessDeniedException("Access is denied");
		}
		return point.proceed();
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE + 1;
	}
}
