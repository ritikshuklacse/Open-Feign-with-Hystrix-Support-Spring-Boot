package com.demoFeign;

import com.demoFeign.feignClients.MyFeignClient;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class FallbackClient2 implements MyFeignClient {
    @Override
    public String client2Response() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Fallback message", "Fallback from client 2");
        return jsonObject.toString();
    }
}
