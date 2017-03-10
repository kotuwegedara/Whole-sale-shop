/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.thogakade.dao.custom.OrderDetailsDAO;
import lk.ijse.thogakade.dto.OrderdetailDTO;

/**
 *
 * @author Nawanjana
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO{
    
    private Connection connection;
    
    private final String TABLE_NAME = "orderdetails";

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }  
    
     @Override
    public Connection getConnection() {
        return this.connection;
    }


//    @Override
//    public boolean save(OrderdetailDTO dto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public boolean update(OrderdetailDTO dto) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public boolean delete(String id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public ArrayList<OrderdetailDTO> getAll() throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setConnection(Connection connection) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public OrderdetailDTO getById(String id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Connection getConnection() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
// 
    
}
