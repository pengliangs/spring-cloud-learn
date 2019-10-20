/*
 *  Copyright (c) 2019-2020, 冷冷 (wangiegie@gmail.com).
 *  <p>
 *  Licensed under the GNU Lesser General Public License 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  <p>
 * https://www.gnu.org/licenses/lgpl.html
 *  <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.pengliangs.filter;

import cn.hutool.core.util.StrUtil;
import com.github.pengliangs.exception.ForbiddenException;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局拦截器，所有的微服务
 * @author pengliang
 * @date 2019/10/20 15:41
 */
//@Component
//public class RequestGlobalFilter implements GlobalFilter, Ordered {
//
//
//	@Override
//	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//		ServerHttpRequest request = exchange.getRequest();
//
//		//1.验证请求中是否包含认证信息 Authorization
//		if (request.getHeaders().containsKey("Authorization")){
//			throw new ForbiddenException("No authorization to deny access.");
//		}
//
//
//		//2.验证是否是认证请求
//		if (StrUtil.containsAnyIgnoreCase(request.getURI().getPath(), "oauth/token")){
//			return chain.filter(exchange);
//		}
//
//
//		//3.验证token是否有效
//
//
//
//		return chain.filter(exchange);
//	}
//
//	@Override
//	public int getOrder() {
//		return -1000;
//	}
//}
