package com.example.demo;

import org.springframework.http.HttpMethod;



import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class JavaTech2Application {
	
	@Bean public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@RequestMapping("/eureka-client-2")
	
	public String home()
	{
		JSONObject jsonObject = new JSONObject(
				);
		jsonObject.put("message",  "Hello from the Eureka Client 2 json file");
		jsonObject.put("message-2",
				restTemplate.exchange("http://localhost:8005/eureka-client-1/",
						HttpMethod.GET, null, String.class).getBody());
		return jsonObject.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaTech2Application.class, args);
	}

}
