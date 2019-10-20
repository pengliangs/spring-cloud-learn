package com.github.pengliangs.common.constant;

/**
 * @author pengliang
 * @date 2019/10/19 22:40
 */
public interface SecurityConstants {
	/**
	 * oauth_client_details表字段
	 */
	String CLIENT_FIELDS = " client_id, client_secret, resource_ids, scope, "
		+ "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
		+ "refresh_token_validity, additional_information, autoapprove ";

	/**
	 * JdbcClientDetailsService 查询语句
	 */
	String CLIENT_SELECT_ALL = "SELECT " + CLIENT_FIELDS
		+ " FROM oauth_client_details";

	/**
	 * 默认的查询语句
	 */
	String CLIENT_SELECT_ALL_ORDER_BY_CLIENT_ID = CLIENT_SELECT_ALL + " order by client_id";

	/**
	 * 按条件client_id 查询
	 */
	String CLIENT_SELECT_BY_CLIENT_ID = CLIENT_SELECT_ALL + " where client_id = ?";

	/**
	 * 前缀
	 */
	String PROJECT_PREFIX = "pl_";

	/**
	 * oauth 相关前缀
	 */
	String OAUTH_PREFIX = "oauth:";

	/**
	 *资源服务默认bean
	 */
	String RESOURCE_SERVER_CONFIGURER = "defaultResourceServerConfigurerAdapter";

	/**
	 * 用户ID字段
	 */
	String DETAILS_USER_ID = "user_id";

	/**
	 * 用户名字段
	 */
	String DETAILS_USERNAME = "username";

	/**
	 * 协议信息
	 */
	String LICENSE = "license";

	/**
	 * ajax 请求头
	 */
	String AJAX_HEADER = "X-Requested-With";

	/**
	 * ajax 请求头,类容
	 */
	String AJAX_HEADER_CONTENT = "XMLHttpRequest";

	/**
	 * 授权头部
	 */
	String AUTHORIZATION_HEADER = "Authorization";

	/**
	 */
	String AUTH_BASIC = "Basic ";

	/**
	 * token类型Bearer
	 */
	String AUTH_BEARER = "Bearer ";

	/**
	 * 编码
	 */
	String ENCODING_UTF8 = "UTF-8";
}
