package com.demoFeign;

import feign.hystrix.FallbackFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FallbackClient3 implements FallbackFactory<MyFeignClient> {

    @Override
    public MyFeignClient create(Throwable throwable) {
        return () ->{
            log.error("fallback due to client 3 and cause is ", throwable);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Fallback message", "Fallback from client 3");
            return jsonObject.toString();
        };
    }

//    @Override
//    public String client3Response() throws JSONException {
//        log.error("fallback from client 3");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("Fallback message", "Fallback from client 3");
//        return jsonObject.toString();
//    }

}
