package com.demoFeign;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class Application {
	
	@Autowired
	private MyFeignClient myFeignClient;

	@RequestMapping("/")
	public String home() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message from client 2", "Message 2");
		jsonObject.put("message from client 3", new JSONObject(myFeignClient.client3Response()));
		return jsonObject.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
