package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RoleIdListDTO {

    @JsonProperty("roles")
    private List<String> roleId;

    public List<String> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<String> roleId) {
        this.roleId = roleId;
    }
}
