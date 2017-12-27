package com.liangke.http.response;

import java.util.List;

/**
 * Created by LK on 2017/12/21.
 */

public class RegisterResponse {

    /**
     * auth : ["admin"]
     * code : 200
     * token : 43fcc080-475d-4b27-ae7d-a77154eb4cfe
     */

    private int code;
    private String token;
    private List<String> auth;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getAuth() {
        return auth;
    }

    public void setAuth(List<String> auth) {
        this.auth = auth;
    }
}
