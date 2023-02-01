package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateUserRequest {
    @JsonProperty("connection")
    private String connection;

    @JsonProperty("name")
    private String name;

    @JsonProperty("family_name")
    private String familyName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("app_metadata")
    private Object appMetadata;

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Object getAppMetadata() {
        return appMetadata;
    }

    public void setAppMetadata(Object appMetadata) {
        this.appMetadata = appMetadata;
    }
}
