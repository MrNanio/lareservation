package com.nankiewic.lareservation.Security.Payload;



public class AuthenticationResponse {
    private String token;
    private String type = "Bearer";

    public AuthenticationResponse(String accessToken) {
        this.token = accessToken;

    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

}
