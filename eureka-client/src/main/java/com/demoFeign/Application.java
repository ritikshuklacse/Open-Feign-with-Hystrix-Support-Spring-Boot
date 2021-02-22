package com.demoFeign;

import com.demoFeign.dto.Post;
import com.demoFeign.dto.UserResponse;
import com.demoFeign.feignClients.MyFeignClient;
import com.demoFeign.feignClients.UserDataFeignClient;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class Application {
	
	@Autowired
	private MyFeignClient myFeignClient;

	@Autowired
	private UserDataFeignClient userDataFeignClient;

	@RequestMapping("/")
	public String home() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("message from client 1", "Message 1");
 		jsonObject.put("message from client 2", new JSONObject(myFeignClient.client2Response()));
		return jsonObject.toString();
	}

	@GetMapping("/findAllUsers")
	public List<UserResponse> getAllUsers() {
		return userDataFeignClient.getUsers();
	}

	@GetMapping("/findAllPosts")
	public List<Post> getAllPosts() {
		return userDataFeignClient.getPosts();
	}



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
