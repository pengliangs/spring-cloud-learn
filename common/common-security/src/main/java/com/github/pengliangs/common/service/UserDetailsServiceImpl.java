package com.github.pengliangs.common.service;

import com.github.pengliangs.common.feign.RemoteBaseInfoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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
		log.info("调用用户访问：{}",remoteBaseInfoService.ping());
		log.info("请求用户：{}",username);
		String password = passwordEncoder.encode("123456");
		log.info("用户密码：{}",password);
		return new SysUser(1L,username,password,Boolean.TRUE,Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
			AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
	}

}
