package com.demoFeign;

import org.codehaus.jettison.json.JSONException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="eureka-client-3", url="http://localhost:8003/" ,fallbackFactory= FallbackClient3.class)
public interface MyFeignClient {
	
	@GetMapping
	public String client3Response() throws JSONException;
}

