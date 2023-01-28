package com.sso.demo.rest;

import com.sso.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/public", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getPublic() {
        return messageService.getPublicMessage();
    }

    @GetMapping(value = "/protected", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getProtected() {
        return messageService.getProtectedMessage();
    }

}
