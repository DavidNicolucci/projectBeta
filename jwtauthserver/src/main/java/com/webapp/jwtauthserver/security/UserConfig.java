package com.webapp.jwtauthserver.security;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component 
@ConfigurationProperties("getuser")
@Data
public class UserConfig {

	private String srvUrl;
	private String userId;
	private String password;
	
}
