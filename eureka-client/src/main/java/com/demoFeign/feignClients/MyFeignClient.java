package com.demoFeign.feignClients;

import com.demoFeign.FallbackClient2;
import org.codehaus.jettison.json.JSONException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="eureka-client-2", url="http://localhost:8002/" ,fallback = FallbackClient2.class)
public interface MyFeignClient {
	
	@GetMapping
	String client2Response() throws JSONException;
}
