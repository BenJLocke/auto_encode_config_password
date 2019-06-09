package com.example.demo.config;

//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationProperties(prefix="code")
public class Code {
	private Push push;

	public Push getPush() {
		return push;
	}

	public void setPush(Push push) {
		this.push = push;
	}
}
