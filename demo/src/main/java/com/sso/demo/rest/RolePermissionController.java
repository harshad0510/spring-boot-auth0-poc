package com.sso.demo.rest;

import com.sso.demo.dto.RoleIdListDTO;
import com.sso.demo.dto.UserIdRequestDTO;
import com.sso.demo.dto.UserPermissionsDTO;
import com.sso.demo.dto.UserRoleIdsDTO;
import com.sso.demo.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping(value = "/test/get-user-roles", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getUserRoles(@RequestBody UserIdRequestDTO userIdRequestDTO) {
        return rolePermissionService.getUserRoles(userIdRequestDTO);
    }

    @PostMapping(value = "/test/add-user-roles", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String assignRolesToUser(@RequestBody UserRoleIdsDTO userRoleIdsDTO) {
        return rolePermissionService.assignRolesToUser(userRoleIdsDTO);
    }

    @DeleteMapping(value = "/test/remove-user-roles", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String removeRolesFromUser(@RequestBody UserRoleIdsDTO userRoleIdsDTO) {
        return rolePermissionService.removeRolesFromUser(userRoleIdsDTO);
    }

    @PostMapping(value = "/test/get-user-permissions", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String getUserPermissions(@RequestBody UserIdRequestDTO userIdRequestDTO) {
        return rolePermissionService.getUserPermissions(userIdRequestDTO);
    }

    @PostMapping(value = "/test/add-user-permissions", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String assignPermissionsToUser(@RequestBody UserPermissionsDTO userPermissionsDTO) {
        return rolePermissionService.assignPermissionsToUser(userPermissionsDTO);
    }


}
