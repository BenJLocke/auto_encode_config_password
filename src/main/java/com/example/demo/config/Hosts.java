package com.example.demo.config;

import java.util.List;

//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;
//
//@Component
//@ConfigurationProperties(prefix="hosts")
public class Hosts {
	private List<Host> host;

	public List<Host> getHost() {
		return host;
	}

	public void setHost(List<Host> host) {
		this.host = host;
	}
}
