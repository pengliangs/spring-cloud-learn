package com.github.pengliangs.event.controller;

import org.springframework.http.MediaType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengliang
 * @date 2019/10/21 22:46
 */
@RestController
@RequestMapping(value = "/event",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EventController {

	@GetMapping("/ping")
	public String pingEvent() {
		return "success event.";
	}

}
