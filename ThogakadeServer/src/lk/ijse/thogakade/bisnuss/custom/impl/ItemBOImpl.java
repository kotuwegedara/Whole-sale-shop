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
import lk.ijse.thogakade.bisnuss.custom.ItemBO;
import lk.ijse.thogakade.dao.ConnectionFactory;
import lk.ijse.thogakade.dao.DAOFactory;
import lk.ijse.thogakade.dao.custom.ItemDAO;
import lk.ijse.thogakade.dto.ItemDTO;


public class ItemBOImpl implements ItemBO{

    private ItemDAO itemDAO;
    private Connection connection;
    
    public ItemBOImpl() throws Exception{        
        //itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM); 
        
         try {
            connection=ConnectionFactory.getInstance().getConnection();
            
            this.itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
           itemDAO.setConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(ItemBOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean save(ItemDTO t) throws Exception {   
//        return true;
        return itemDAO.save(t);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        return itemDAO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return true;
    }

    @Override
    public ItemDTO getById(String id) throws Exception {
        return itemDAO.getById(id);
    }
    
    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        return itemDAO.getAll();
    }


    
    
}
