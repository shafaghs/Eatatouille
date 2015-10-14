/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.bean.UserDetailsBean;
import com.dao.UserDetailsDAO;
import com.util.PasswordHash;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saumil
 */
public class UserDetails extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session  = request.getSession();
            UserDetailsBean userDetailsBean = new UserDetailsBean();
            UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
            boolean flag = false;
            
            String fName = "";
            String lName = "";
            String email = "";
            String password = "";
            
            String task = request.getParameter("task");
            String type = request.getParameter("type");
            switch(task){
                
                case "signup":
                    
                    if("direct".equals(type)){
                        
                        fName = request.getParameter("fName");
                        lName = request.getParameter("lName");
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        
                        //checking if the email address is already registered
                        flag = userDetailsDAO.checkEmail(email);
                        if(!flag){
                            session.setAttribute("registerErr", "This email address is already registered!!!");
                            response.sendRedirect("index.jsp");
                        }else{
                        
                            userDetailsBean.setEmail(email);
                            userDetailsBean.setFName(fName);
                            userDetailsBean.setLName(lName);
                            userDetailsBean.setPassword(password);

                            //encrypting the password
                            password = PasswordHash.createHash(password);
                            userDetailsBean.setPassword(password);

                            //saving the user details
                            userDetailsBean = userDetailsDAO.directSignup(userDetailsBean);

                            if(flag){
                                //saving the user details in session variable for easy access
                                session.setAttribute("userDetails", userDetailsBean);
                                session.removeAttribute("registerErr");
                                response.sendRedirect("Home");
                            }else{
                                request.getRequestDispatcher("index.jsp").forward(request, response);
                            }
                            
                        }
                        
                    }
                    
                    break;
                    
                case "login":
                    
                    if("direct".equals(type)){
                        
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        
                        //fetching the password hash for the given email address
                        String storedHash = userDetailsDAO.getPassword(email);
                        
                        //validating the stored hash with the entered password
                        flag = PasswordHash.validatePassword(password, storedHash);
                        if(flag){
                            //getting the stored user details and storing it in the session variable
                            userDetailsBean = userDetailsDAO.getUserDetails(email);
                            session.setAttribute("userDetails", userDetailsBean);
                            session.removeAttribute("loginErr");
                            response.sendRedirect("Home");
                            
                        }else{
                            session.setAttribute("loginErr", "Email/Passoword incorrect!!!");
                            response.sendRedirect("index.jsp");
                        }
                        
                    }
                    
                    break;
                    
                case "logout":
                        
                    //removing the session variables
                    session.removeAttribute("userDetails");
                    
                    response.sendRedirect("index.jsp");
                        
                    break;
                    
                case "fb":
                    
                    fName = request.getParameter("fName");
                    lName = request.getParameter("lName");
                    email = request.getParameter("email");
                    
                    break;
                
            }
            
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(UserDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
