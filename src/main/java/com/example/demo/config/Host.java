package com.example.demo.config;

//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix="host")
public class Host {
	private String hostName;
	private String user;
	private String password;
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
