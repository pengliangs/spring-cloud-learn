package com.github.pengliangs.common.security.service;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author pengliang
 * @date 2019/10/19 23:46
 */
public class SysUser extends User {

	/**
	 * 用户id
	 */
	@Getter
	private Long id;

	/**
	 * 用户认证信息
	 * @param id 用户id
	 * @param username 用户名
	 * @param password 密码
	 * @param enabled 是否启用 true：已启动
	 * @param accountNonExpired 账号是否过期  true：未过期
	 * @param credentialsNonExpired 凭证是否过期 true：未过期
	 * @param accountNonLocked 账号是否锁定 true：未锁定
	 * @param authorities 给予权限
	 */
	public SysUser(Long id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.id = id;
	}
}
