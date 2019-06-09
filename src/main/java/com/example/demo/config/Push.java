package com.example.demo.config;

//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix="push")
public class Push {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
