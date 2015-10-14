/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Saumil
 */
public class DBConnection {
     public static Connection createConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost/eatatouille";
        String username = "root"; //username of database user
        String password = "root"; //password

        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");// differs from DB server to server
            } catch (ClassNotFoundException e) {
                System.out.print(e);
            }

            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.print(e);
        }

        return con;
    }
}
