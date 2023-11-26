package com.assignit.coreservice.ai.controller;

import com.assignit.coreservice.ai.beans.AiBean;
import com.assignit.coreservice.ai.beans.AiRestRequest;
import com.assignit.coreservice.ai.beans.AiRestResponse;
import com.assignit.coreservice.ai.service.AiService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Api
@RestController
@RequestMapping("/service/ai-chat")
@Tag(name = "AiChatController", description = "Ai Chat EndPoint")
public class AiChatController {

    @Autowired
    private AiService aiService;

    @PostMapping()
    public ResponseEntity<?> aiChat(@RequestBody AiRestRequest aiBean) {
        try {
            return new ResponseEntity<>(aiService.aiChatService(aiBean), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
