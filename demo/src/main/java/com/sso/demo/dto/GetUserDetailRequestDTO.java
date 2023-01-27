package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetUserDetailRequestDTO {

    @JsonProperty("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
