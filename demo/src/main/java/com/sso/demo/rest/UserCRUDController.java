package com.sso.demo.rest;

import com.sso.demo.dto.CreateUserRequestDTO;
import com.sso.demo.dto.GetUserDetailRequestDTO;
import com.sso.demo.dto.UpdateUserRequestDTO;
import com.sso.demo.service.CRUDAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCRUDController {

    @Autowired
    private CRUDAPIService crudapiService;

    @GetMapping(value = "/test/management-api-token", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getManagementAPIAccessToken() {
        return crudapiService.getManagementAPIToken();
    }

    @PostMapping(value = "/test/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        return crudapiService.createUser(createUserRequestDTO);
    }

    @PostMapping(value = "/test/get-user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String createUser(@RequestBody GetUserDetailRequestDTO getUserDetailRequestDTO) {
        return crudapiService.getUser(getUserDetailRequestDTO);
    }

    @PutMapping(value = "/test/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateUser(@RequestBody UpdateUserRequestDTO updateUserRequestDTO) {
        return crudapiService.updateUser(updateUserRequestDTO);
    }

}
