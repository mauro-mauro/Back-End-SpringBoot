package com.maurote.portfolio.security.dto;

//se utiliza al momento de loguear
public class JwtDto {
    private String token;

    public JwtDto(String token) {
        this.token = token;
    }

    public JwtDto() {
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
