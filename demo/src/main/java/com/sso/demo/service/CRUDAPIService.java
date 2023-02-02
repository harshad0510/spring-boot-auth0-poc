package com.sso.demo.service;

import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwk.Jwk;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.sso.demo.dto.CreateUserRequestDTO;
import com.sso.demo.dto.ManagementAPITokenRequestDTO;
import com.sso.demo.dto.ManagementAPITokenResponseDTO;
import com.sso.demo.dto.UpdateUserRequest;
import com.sso.demo.dto.UpdateUserRequestDTO;
import com.sso.demo.dto.UserIdRequestDTO;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.Map;

@Service
public class CRUDAPIService {

    @Value("${user.crud.api.token.client.id}")
    private String clientId;

    @Value("${user.crud.api.token.client.secret}")
    private String clientSecret;

    @Value("${user.crud.api.token.audience}")
    private String audience;

    @Value("${user.crud.api.token.grant.type}")
    private String grantType;

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String urlHost;

    public String getManagementAPIToken() {
        ManagementAPITokenRequestDTO managementAPITokenRequestDTO = new ManagementAPITokenRequestDTO();
        managementAPITokenRequestDTO.setClientId(clientId);
        managementAPITokenRequestDTO.setClientSecret(clientSecret);
        managementAPITokenRequestDTO.setAudience(audience);
        managementAPITokenRequestDTO.setGrantType(grantType);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ManagementAPITokenRequestDTO> entity = new HttpEntity<>(managementAPITokenRequestDTO, headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "oauth/token";
        ManagementAPITokenResponseDTO managementAPITokenResponseDTO =
                restTemplate.postForObject(url, entity, ManagementAPITokenResponseDTO.class);
        return managementAPITokenResponseDTO.getAccessToken();
    }

    public String createUser(CreateUserRequestDTO createUserRequestDTO) {
        String accessToken = getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<CreateUserRequestDTO> entity = new HttpEntity<>(createUserRequestDTO, headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    public String getUser(UserIdRequestDTO userIdRequestDTO) {
        String accessToken = getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userIdRequestDTO.getId();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }

    public String updateUser(UpdateUserRequestDTO updateUserRequestDTO) {
        String accessToken = getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<UpdateUserRequest> entity = new HttpEntity<>(updateUserRequestDTO.getUpdateUserRequest(), headers);

        CloseableHttpClient client = HttpClients.createDefault();
        RestTemplate restTemplate= new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
        String url = urlHost + "api/v2/users/" + updateUserRequestDTO.getId();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PATCH, entity, String.class);
        return response.getBody();
    }

    public String deleteUser(UserIdRequestDTO userIdRequestDTO) {
        String accessToken = getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/users/" + userIdRequestDTO.getId();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
        return response.getBody();
    }

    public String getPasswordChangeUrl(Object request) {
        // in the request we can pass client_id or result_url
        // client_id will be useful for new universal login
        // if we set result_url then after reset password, it will redirect to that url
        // result_url is not working currently for new universal login approach

        String accessToken = getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Object> entity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "api/v2/tickets/password-change";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    public String sendPasswordResetEmail(Object request) {
        String accessToken = getManagementAPIToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<Object> entity = new HttpEntity<>(request, headers);
        RestTemplate restTemplate = new RestTemplate();
        String url = urlHost + "dbconnections/change_password";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return response.getBody();
    }

    public void verifyJwt(String authorizationToken) {
        String token = authorizationToken;
        JwkProvider provider = new UrlJwkProvider(urlHost);
        try {
            DecodedJWT jwt = JWT.decode(token);
            // Get the kid from received JWT token
            Jwk jwk = provider.get(jwt.getKeyId());


            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);


            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(urlHost)
                    .build();

            jwt = verifier.verify(token);
            Map<String, Claim> map = jwt.getClaims();
            Claim permission = map.get("permissions");
            List<String> k = permission.asList(String.class);
            String s = k.get(0);
        } catch (JWTVerificationException e){
            //Invalid signature/claims
            e.printStackTrace();
        } catch (JwkException e) {
            // invalid JWT token
            e.printStackTrace();
        }
    }
}
