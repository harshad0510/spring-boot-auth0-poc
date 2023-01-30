package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRoleIdsDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("role_ids")
    private RoleIdListDTO roleIdListDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoleIdListDTO getRoleIdListDTO() {
        return roleIdListDTO;
    }

    public void setRoleIdListDTO(RoleIdListDTO roleIdListDTO) {
        this.roleIdListDTO = roleIdListDTO;
    }
}
