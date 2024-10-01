package com.imps.IMPS.models;


public class ServerResponse {
    private Boolean status;
    private String message;
    private String serverToken;
    private User user;
    
    public Boolean isStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getServerToken() {
        return serverToken;
    }
    public void setServerToken(String serverToken) {
        this.serverToken = serverToken;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}