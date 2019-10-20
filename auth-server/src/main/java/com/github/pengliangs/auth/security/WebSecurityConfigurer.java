package com.github.pengliangs.auth.security;

import com.github.pengliangs.common.exception.CustomAccessDeniedHandler;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author pengliang
 * @date 2019/10/19 22:08
 */
@Primary
@Order(org.springframework.boot.autoconfigure.security.SecurityProperties.BASIC_AUTH_ORDER)
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Override
	@SneakyThrows
	protected void configure(HttpSecurity http) {
		http
			.authorizeRequests()
			.antMatchers(
				"/actuator/**",
				"/token/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
	}

	@Bean
	@Override
	@SneakyThrows
	public AuthenticationManager authenticationManagerBean() {
		return super.authenticationManagerBean();
	}

}
