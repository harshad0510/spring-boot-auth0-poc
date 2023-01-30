package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserPermissionsDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("permissions")
    private List<PermissionDTO> permissionDTOList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PermissionDTO> getPermissionDTOList() {
        return permissionDTOList;
    }

    public void setPermissionDTOList(List<PermissionDTO> permissionDTOList) {
        this.permissionDTOList = permissionDTOList;
    }
}
