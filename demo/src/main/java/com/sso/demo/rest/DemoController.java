package com.sso.demo.rest;

import com.sso.demo.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth0")
public class DemoController {

    @GetMapping(value = "/public")
    public ResponseEntity<ResponseDTO> publicEndpoint() {
        return ResponseEntity.ok(new ResponseDTO("Public Endpoint Working fine !"));
    }

    @GetMapping(value = "/private")
    public ResponseEntity<ResponseDTO> privateEndpoint() {
        return ResponseEntity.ok(new ResponseDTO("Private Endpoint Working fine !"));
    }
}
