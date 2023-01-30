package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PermissionDTO {

    @JsonProperty("permission_name")
    private String permissionName;

    @JsonProperty("resource_server_identifier")
    private String resourceServerIdentifier;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getResourceServerIdentifier() {
        return resourceServerIdentifier;
    }

    public void setResourceServerIdentifier(String resourceServerIdentifier) {
        this.resourceServerIdentifier = resourceServerIdentifier;
    }
}
