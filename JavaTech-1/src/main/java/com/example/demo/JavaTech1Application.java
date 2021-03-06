package com.example.demo;

import org.json.simple.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class JavaTech1Application {
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/eureka-client-1")
	
	public String home()
	{
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message",  "Hello from the Eureka Client 1");
		return jsonObject.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaTech1Application.class, args);
	}

}
