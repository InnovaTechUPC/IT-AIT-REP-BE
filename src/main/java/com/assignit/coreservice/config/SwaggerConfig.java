package com.assignit.coreservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class SwaggerConfig {

    @Value("${springdoc.server.url:http://localhost:8080}")
    private String[] serverUrl;

    private final List<Server> serverList = new ArrayList<>();

    @Bean
    public OpenAPI customizeOpenAPI(OpenAPI openApi) {
        openApi.info(new Info()
                .title("API Docs")
                .version("1.0"));

        for (String server: serverUrl) {
            serverList.add(new Server()
                    .url(server)
                    .description("Server URL"));
        }

        openApi.servers(serverList);

        return openApi;
    }

}
