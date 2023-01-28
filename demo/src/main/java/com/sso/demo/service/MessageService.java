package com.sso.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getPublicMessage() {
        return "Public message";
    }

    public String getProtectedMessage() {
        return "This is a protected message.";
    }
}
