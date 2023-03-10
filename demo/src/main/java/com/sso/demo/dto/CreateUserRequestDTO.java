package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUserRequestDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("connection")
    private String connection;

    @JsonProperty("name")
    private String name;

    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("email_verified")
    private boolean emailVerified;

    @JsonProperty("user_metadata")
    private Object userMetadata;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public Object getUserMetadata() {
        return userMetadata;
    }

    public void setUserMetadata(Object userMetadata) {
        this.userMetadata = userMetadata;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
