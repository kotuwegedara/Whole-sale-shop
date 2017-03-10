/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nawanjana
 */
public class ConnectionFactory {
    
    private static ConnectionFactory connectionFactory;
    
    private ConnectionFactory(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
           
           ex.printStackTrace();
        }
        
    }
    
    public static ConnectionFactory getInstance(){
        if (connectionFactory == null){
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
    
    public Connection getConnection() throws SQLException{
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        }
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC" , "root" , "toothbrush3");        
//    }
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Company" , "root" , "toothbrush3");
        return connection;
        
    }
}
