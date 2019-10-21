package com.github.pengliangs.event;

import com.github.pengliangs.common.security.annotation.EnableAuthResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author pengliang
 * @date 2019/10/21 22:43
 */
@EnableAuthResourceServer
@SpringCloudApplication
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class,args);
	}
}
