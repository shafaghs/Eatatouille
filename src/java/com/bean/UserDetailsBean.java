/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

/**
 *
 * @author saumil
 */
public class UserDetailsBean {
    
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String type;
    private String userId;
    
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return userId;
    }
    
    public void setFName(String fName){
        this.fName = fName;
    }
    public String getFName(){
        return fName;
    }
    
    public void setLName(String lName){
        this.lName = lName;
    }
    public String getLName(){
        return lName;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    
}
