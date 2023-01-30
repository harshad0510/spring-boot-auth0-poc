package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PermissionListDTO {

    @JsonProperty("permissions")
    private List<PermissionDTO> permissionDTOList;

    public List<PermissionDTO> getPermissionDTOList() {
        return permissionDTOList;
    }

    public void setPermissionDTOList(List<PermissionDTO> permissionDTOList) {
        this.permissionDTOList = permissionDTOList;
    }
}
