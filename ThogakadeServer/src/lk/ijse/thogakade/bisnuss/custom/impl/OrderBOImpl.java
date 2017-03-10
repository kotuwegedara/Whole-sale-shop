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
import lk.ijse.thogakade.bisnuss.custom.OrderBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.SuperDAO;
import lk.ijse.thogakade.dao.custom.OrderDAO;
import lk.ijse.thogakade.dto.OrderDTO;


public class OrderBOImpl implements OrderBO{

    private OrderDAO orderDAO;
    private Connection connection;
    
    public OrderBOImpl() throws Exception{
        try {
            connection=ConnectionFactory.getInstance().getConnection();
            
            this.orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
           orderDAO.setConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(ItemBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean save(OrderDTO t) throws Exception {
        return orderDAO.save(t);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        return orderDAO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return orderDAO.delete(id);
//          return true;
    }

    @Override
    public OrderDTO getById(String id) throws Exception {
        return (OrderDTO) orderDAO.getById(id);
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        return orderDAO.getAll();
    }
    
}
