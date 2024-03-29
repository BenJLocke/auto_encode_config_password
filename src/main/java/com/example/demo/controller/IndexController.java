package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

	@Value("${code.push.password}")
	String password;

    @GetMapping("/")
    String index() {
		return password;
    }
}
