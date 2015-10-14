/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.bean.UserDetailsBean;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author saumil
 */
public class UserDetailsDAO {
 
    Connection con = null;
    PreparedStatement ps = null;
    Statement s = null;
    ResultSet rs = null;
    
    //when user uses the direct registration
    public UserDetailsBean directSignup(UserDetailsBean userDetailsBean){
        
        String fName = userDetailsBean.getFName();
        String lName = userDetailsBean.getLName();
        String email = userDetailsBean.getEmail();
        String password = userDetailsBean.getPassword();
        String userId = "";
        
        try{
        
            con = DBConnection.createConnection();
            
            con  = DBConnection.createConnection();
            
            String query = "insert into userDetails (firstName, lastName, email, password, type) values "
                    + "('"+fName+"', '"+lName+"', '"+email+"', '"+password+"', 'direct')";
            s = con.createStatement();
            s.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            rs = s.getGeneratedKeys();
            if (rs.next()){
                userDetailsBean.setUserId(rs.getString(1));
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return userDetailsBean;
        
    }
    
    //method to check if the email address is already registered or not
    public boolean checkEmail(String email){
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select userId from userDetails where email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()){
                return false;
            }
            
            con.close();
            return true;
                    
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        
    }
    
    //fetching the encrypted password according to the entered email
    public String getPassword(String email){
        
        String password = "";
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select password from userDetails where email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while(rs.next()){
                password =  rs.getString("password");
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return password;
        
    }
    
    //get user details
    public UserDetailsBean getUserDetails(String email){
        
        UserDetailsBean userDetailsBean = new UserDetailsBean();
        
        try{
        
            con = DBConnection.createConnection();
            
            String query = "select * from userDetails where email = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            while(rs.next()){
                userDetailsBean.setEmail(email);
                userDetailsBean.setFName(rs.getString("firstName"));
                userDetailsBean.setLName(rs.getString("lastName"));
                userDetailsBean.setUserId(rs.getString("userId"));
            }
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        return userDetailsBean;
        
    }
    
}
