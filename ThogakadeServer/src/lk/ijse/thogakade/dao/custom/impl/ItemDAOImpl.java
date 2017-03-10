/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dto.ItemDTO;

/**
 *
 * @author Nawanjana
 */
public class ItemDAOImpl implements ItemDAO {
    
    private Connection connection;
    
    private final String TABLE_NAME = "item";

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }  
    
     @Override
    public Connection getConnection() {
        return this.connection;
    }

//    @Override
//    public boolean save(ItemDTO item) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("INSERT INTO Item VALUES(?,?,?,?)");
//        pst.setObject(1, item.getCode());
//        pst.setObject(2, item.getDescription());
//        pst.setObject(3, item.getQtyOnHand());
//        pst.setObject(4, item.getUnitPrice());
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

//    @Override
//    public boolean update(ItemDTO item) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("Update Item set description=?, unitPrice=?, qtyOnHand=? where code=?");
//        pst.setObject(4, item.getCode());
//        pst.setObject(1, item.getDescription());
//        pst.setObject(3, item.getQtyOnHand());
//        pst.setObject(2, item.getUnitPrice());
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }

//    @Override
//    public boolean delete(String id) throws Exception {
//        PreparedStatement pst = connection.prepareStatement("Delete From Item where code='" + id + "'");
//        int result = pst.executeUpdate();
//        return (result > 0);
//    }
//   

//    @Override
//    public ArrayList<ItemDTO> getAll() throws Exception {
//        return null;
//    }

//    @Override
//    public ItemDTO getById(String id) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   

}
