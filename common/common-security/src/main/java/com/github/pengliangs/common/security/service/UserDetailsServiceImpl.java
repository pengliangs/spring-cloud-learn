package com.github.pengliangs.common.security.service;

import com.github.pengliangs.common.security.constant.SecurityConstants;
import com.github.pengliangs.common.security.feign.RemoteBaseInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author pengliang
 * @date 2019/10/19 21:13
 */
@Slf4j
@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final PasswordEncoder passwordEncoder;

	private  final RemoteBaseInfoService remoteBaseInfoService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("调用用户访问：{}",remoteBaseInfoService.ping2("测试啊",SecurityConstants.IGNORE_AUTH_HEAD_VALUE));
		log.info("请求用户：{}",username);
		String password = passwordEncoder.encode("123456");
		log.info("用户密码：{}",password);
		return new SysUser(1L,username,password,Boolean.TRUE,Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
			AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
