/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.bean.RecipeBean;
import com.dao.RecipeDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author saumil
 */
public class RecipeImage extends HttpServlet {
    
    private boolean isMultipart;
    private String filePath;
    private String fileDisplay;
    private int maxFileSize = 5000 * 1024;
    private int maxMemSize = 4000 * 1024;
    private File file ;
    private String fileName = "";

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            
            //retrieving the path to store image from web.xml
            filePath = getServletContext().getInitParameter("recipeImageStorePath");
            
            //retrieving the path to display image from web.xml
            fileDisplay = getServletContext().getInitParameter("recipeImageDisplayPath");
        
            // Check that we have a file upload request
            isMultipart = ServletFileUpload.isMultipartContent(request);
            response.setContentType("text/html");
            java.io.PrintWriter out = response.getWriter( );
            if( !isMultipart ){
               out.println("<html>");
               out.println("<head>");
               out.println("<title>Servlet upload</title>");  
               out.println("</head>");
               out.println("<body>");
               out.println("<p>No file uploaded</p>"); 
               out.println("</body>");
               out.println("</html>");
               return;
            }
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // maximum size that will be stored in memory
            factory.setSizeThreshold(maxMemSize);
            // Location to save data that is larger than maxMemSize.
            factory.setRepository(new File("c:\\temp"));

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);
            // maximum file size to be uploaded.
            upload.setSizeMax( maxFileSize );

            try{ 
            // Parse the request to get file items.
            List fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet upload</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("1");
            while ( i.hasNext () ) 
            {
                out.println("2");
               FileItem fi = (FileItem)i.next();
               if ( !fi.isFormField () )	
               {
                  // Get the uploaded file parameters
                  String fieldName = fi.getFieldName();
                  fileName = fi.getName();
                  fileName = randomString(fileName);
                  String contentType = fi.getContentType();
                  boolean isInMemory = fi.isInMemory();
                  long sizeInBytes = fi.getSize();
                  // Write the file
                  if( fileName.lastIndexOf("\\") >= 0 ){
                     file = new File( filePath + 
                     fileName.substring( fileName.lastIndexOf("\\"))) ;
                  }else{
                     file = new File( filePath + 
                     fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                  }
                  fi.write( file ) ;
                  out.println("Uploaded Filename: " + fileName + "<br>"+filePath);
               }else{
                   out.println("No file");
               }
            }
            out.println("</body>");
            out.println("</html>");
            
            RecipeBean recipeBean = new RecipeBean();
            RecipeDAO recipeDAO = new RecipeDAO();
            
            String image = fileDisplay+""+fileName;
            out.println(image);
            
            HttpSession session = request.getSession();
            String recipeId = (String)session.getAttribute("recipeId");
            session.removeAttribute("recipeId");
            recipeDAO.addImage(recipeId, image);
            
            response.sendRedirect("Home");
            
         }catch(Exception ex) {
             System.out.println(ex);
         }
    }
    
    private String randomString(String fileName){
        return UUID.randomUUID().toString() + fileName;
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
        processRequest(request, response);
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
        processRequest(request, response);
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
