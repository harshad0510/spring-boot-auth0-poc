package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserRequestDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("update_user_request")
    private UpdateUserRequest updateUserRequest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UpdateUserRequest getUpdateUserRequest() {
        return updateUserRequest;
    }

    public void setUpdateUserRequest(UpdateUserRequest updateUserRequest) {
        this.updateUserRequest = updateUserRequest;
    }
}
