package com.sso.demo.rest;

import com.sso.demo.dto.CreateUserRequestDTO;
import com.sso.demo.dto.PasswordChangeUrlRequestDTO;
import com.sso.demo.dto.UpdateUserRequestDTO;
import com.sso.demo.dto.UserIdRequestDTO;
import com.sso.demo.service.CRUDAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public String getUser(@RequestBody UserIdRequestDTO userIdRequestDTO) {
        return crudapiService.getUser(userIdRequestDTO);
    }

    @PutMapping(value = "/test/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateUser(@RequestBody UpdateUserRequestDTO updateUserRequestDTO) {
        return crudapiService.updateUser(updateUserRequestDTO);
    }

    @DeleteMapping(value = "/test/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String deleteUser(@RequestBody UserIdRequestDTO userIdRequestDTO) {
        return crudapiService.deleteUser(userIdRequestDTO);
    }

    @PostMapping(value = "/test/password-change-url", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getPasswordChangeUrl(@RequestBody Object request) {
        return crudapiService.getPasswordChangeUrl(request);
    }

    @PostMapping(value = "/test/send-password-change-email", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String sendPasswordChangeEmail(@RequestBody Object request) {
        return crudapiService.sendPasswordResetEmail(request);
    }

    @GetMapping(value = "/test/verify-jwt", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String verifyJwtToken(@RequestHeader("Authorization") String token) {
        crudapiService.verifyJwt(token.substring(7));
        return "Done";
    }

}
