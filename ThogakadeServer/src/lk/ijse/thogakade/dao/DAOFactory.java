/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import lk.ijse.thogakade.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.ItemDAOImpl;
import lk.ijse.thogakade.dao.custom.impl.OrderDAOImpl;

/**
 *
 * @author Nawanjana
 */
public class DAOFactory {
    
    private static DAOFactory daoFactory;
    
    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAILS;
    }
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoType){
        switch(daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            default:
                return null;
        }
    }
    
}
