package com.demoFeign.feignClients;
import java.util.List;

import com.demoFeign.dto.Post;
import com.demoFeign.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url="https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface UserDataFeignClient {

    @GetMapping("/users")
    public List<UserResponse> getUsers();

    @GetMapping("/posts")
    public List<Post> getPosts();


}
