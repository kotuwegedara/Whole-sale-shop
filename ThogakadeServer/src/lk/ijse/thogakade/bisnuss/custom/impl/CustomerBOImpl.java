/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss.custom.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.thogakade.bisnuss.custom.CustomerBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dao.custom.CustomerDAO;
import lk.ijse.thogakade.dto.CustomerDTO;


public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO;
    private Connection connection;

    public CustomerBOImpl() throws Exception {
       try {
            connection=ConnectionFactory.getInstance().getConnection();
            
            this.customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
            customerDAO.setConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean save(CustomerDTO customer) throws Exception {
        
        //customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
//        return customerDAO.save(SuperDAO.Tables.CUSTOMER, customer);
        return customerDAO.save(customer);
    }
    
   
    @Override
    public boolean update(CustomerDTO t) throws Exception {
        
        return customerDAO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
       
//         customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
         System.out.println("Welcome to Business Layer");
//         return customerDAO.delete(id);
           return customerDAO.delete(id);
//         return true;
    }

    @Override
    public CustomerDTO getById(String id) throws Exception {
        return customerDAO.getById(id);
    }

    public ArrayList<CustomerDTO> getAll() throws Exception {
        System.out.println("Welcome to Business Layer");
        //Connection connection=ConnectionFactory.getInstance().getConnection();
        //customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

        //customerDAO.setConnection(connection);
        
        ArrayList<CustomerDTO> all = customerDAO.getAll();
        //connection.close();
        return all;
        
    }

}
