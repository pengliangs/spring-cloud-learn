package com.github.pengliangs.common.security.resource;

import com.github.pengliangs.common.security.constant.SecurityConstants;
import com.github.pengliangs.common.security.service.SysUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author pengliang on 2019-10-20 17:50
 * <p>
 * 根据checktoken 的结果转化用户信息
 */
public class CustomUserAuthenticationConverter implements UserAuthenticationConverter {
	private static final String N_A = "N/A";

	/**
	 * Extract information about the user to be used in an access token (i.e. for resource servers).
	 *
	 * @param authentication an authentication representing a user
	 * @return a map of key values representing the unique information about the user
	 */
	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put(USERNAME, authentication.getName());
		if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
			response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
		}
		return response;
	}

	/**
	 * Inverse of {@link #convertUserAuthentication(Authentication)}. Extracts an Authentication from a map.
	 *
	 * @param map a map of user information
	 * @return an Authentication representing the user or null if there is none
	 */
	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		if (map.containsKey(USERNAME)) {
			Collection<? extends GrantedAuthority> authorities = getAuthorities(map);

			String username = (String) map.get(SecurityConstants.DETAILS_USERNAME);
			Long id = Long.valueOf(Objects.toString(map.get(SecurityConstants.DETAILS_USER_ID),"0"));
			SysUser user = new SysUser(id, username, N_A, true
				, true, true, true, authorities);
			return new UsernamePasswordAuthenticationToken(user, N_A, authorities);
		}
		return null;
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
		Object authorities = map.get(AUTHORITIES);
		if (authorities instanceof String) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
		}
		if (authorities instanceof Collection) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
				.collectionToCommaDelimitedString((Collection<?>) authorities));
		}
		throw new IllegalArgumentException("Authorities must be either a String or a Collection");
	}
}
