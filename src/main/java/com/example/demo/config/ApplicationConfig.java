package com.example.demo.config;

import java.util.List;

//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;

//@Component
//@Configuration
//@ConfigurationProperties(prefix="")
public class ApplicationConfig {
	private Code code;
	private Jasypt jasypt;
	private List<Host> hosts;

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Jasypt getJasypt() {
		return jasypt;
	}

	public void setJasypt(Jasypt jasypt) {
		this.jasypt = jasypt;
	}

	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}
}
