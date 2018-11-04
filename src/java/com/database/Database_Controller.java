/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;
import java.sql.*;
import java.io.*;

/**
 *
 * @author lokesh
 */
public class Database_Controller {
    public ResultSet get() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "root");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * from imagetable");
                
              return rs;
        
    }
}
