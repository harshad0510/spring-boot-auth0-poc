package com.sso.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
public class PasswordChangeUrlRequestDTO {

     @JsonProperty("user_id")
     private String userId;

     @JsonProperty("result_url")
     private String resultUrl;

     @JsonProperty("client_id")
     private String clientId;

     @JsonProperty("ttl_sec")
     private Integer ttlSec;

     @JsonProperty("mark_email_as_verified")
     private boolean markEmailAsVerified;

     @JsonProperty("includeEmailInRedirect")
    private boolean includeEmailInRedirect;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getTtlSec() {
        return ttlSec;
    }

    public void setTtlSec(Integer ttlSec) {
        this.ttlSec = ttlSec;
    }

    public boolean isMarkEmailAsVerified() {
        return markEmailAsVerified;
    }

    public void setMarkEmailAsVerified(boolean markEmailAsVerified) {
        this.markEmailAsVerified = markEmailAsVerified;
    }

    public boolean isIncludeEmailInRedirect() {
        return includeEmailInRedirect;
    }

    public void setIncludeEmailInRedirect(boolean includeEmailInRedirect) {
        this.includeEmailInRedirect = includeEmailInRedirect;
    }
}
