package com.assignit.coreservice.ai.restservice;

import com.assignit.coreservice.ai.beans.AiRestRequest;
import com.assignit.coreservice.ai.beans.AiRestResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
public class AiServiceRestClient {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.rest.client.ai-service}")
    private String url;

    private static final String AI_SERVICE_PATH = "ai-service";

    public AiRestResponse aiChatService(AiRestRequest request) {
        AiRestResponse aiRestResponse = new AiRestResponse();
        try {
            String url = getURL(AI_SERVICE_PATH);
            aiRestResponse = this.restTemplate.postForObject(url, request, AiRestResponse.class);
        }
        catch (Exception e) {
            log.error(e);
        }
        return aiRestResponse;
    }

    private String getURL(String path) {
        return url + path;
    }
}
