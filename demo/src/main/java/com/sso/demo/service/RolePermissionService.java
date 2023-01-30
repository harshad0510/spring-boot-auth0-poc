package com.sso.demo.service;

import com.sso.demo.dto.PermissionListDTO;
import com.sso.demo.dto.RoleIdListDTO;
import com.sso.demo.dto.UserIdRequestDTO;
import com.sso.demo.dto.UserPermissionsDTO;
import com.sso.demo.dto.UserRoleIdsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RolePermissionService {

    @Autowired
    private CRUDAPIService crudapiService;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String urlHost;

    public String getUserRoles(UserIdRequestDTO userIdRequestDTO) {
        String accessToken = crudapiService.getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userIdRequestDTO.getId() + "/roles";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String assignRolesToUser(UserRoleIdsDTO userRoleIdsDTO) {
        String accessToken = crudapiService.getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<RoleIdListDTO> entity = new HttpEntity<>(userRoleIdsDTO.getRoleIdListDTO(), headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userRoleIdsDTO.getId() + "/roles";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    public String removeRolesFromUser(UserRoleIdsDTO userRoleIdsDTO) {
        String accessToken = crudapiService.getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<RoleIdListDTO> entity = new HttpEntity<>(userRoleIdsDTO.getRoleIdListDTO(), headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userRoleIdsDTO.getId() + "/roles";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        return response.getBody();
    }

    public String getUserPermissions(UserIdRequestDTO userIdRequestDTO) {
        String accessToken = crudapiService.getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userIdRequestDTO.getId() + "/permissions";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String assignPermissionsToUser(UserPermissionsDTO userPermissionsDTO) {
        String accessToken = crudapiService.getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        PermissionListDTO permissionListDTO = new PermissionListDTO();
        permissionListDTO.setPermissionDTOList(userPermissionsDTO.getPermissionDTOList());

        HttpEntity<PermissionListDTO> entity =
                new HttpEntity<>(permissionListDTO, headers);


        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userPermissionsDTO.getId() + "/permissions";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

}
