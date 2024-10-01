package com.imps.IMPS.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notification {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    private String requestID;
    
    private String userID;
    
    private String header;
    
    private String content;
    
    private Date createdDate;
    
    private Boolean isRead;
    private Boolean isStaff;
    private Boolean isHead;
    private Boolean isAdmin;
    private String role; 

    public Notification() {}

    public Notification(String requestID, String userID, String header, String content, Date createdDate, String role, Boolean isRead, Boolean isHead, Boolean isStaff, Boolean isAdmin) {
        this.setRequestID(requestID);
        this.setUserID(userID);
        this.setHeader(header);
        this.setContent(content);
        this.setCreatedDate(createdDate);
        this.setIsRead(false);
        this.setRole(role);
        this.setIsStaff(isStaff);
        this.setIsAdmin(isAdmin);
        this.setIsHead(isHead);
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Boolean getIsHead() {
        return isHead;
    }

    public void setIsHead(Boolean isHead) {
        this.isHead = isHead;
    }

    public Boolean getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Boolean isStaff) {
        this.isStaff = isStaff;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
