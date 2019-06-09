package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix="jasypt")
public class Jasypt {
	private Encryptor encryptor;

	public Encryptor getEncryptor() {
		return encryptor;
	}

	public void setEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}
}
