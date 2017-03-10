/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.PlaceOrderController;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author Nawanjana
 */
public class PlaceOrderControllerImpl implements PlaceOrderController {

    private OrderService orderService;

    public PlaceOrderControllerImpl() throws Exception{
        orderService = (OrderService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ORDER);
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
         System.out.println("Welcome to controller Layer");
       return orderService.save(t);
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        return orderService.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
         System.out.println("Welcome to controller Layer");
         return orderService.delete(id);
    }

       @Override
    public OrderDTO getById(String id) throws Exception {
         System.out.println("Welcome to controller Layer");
        return orderService.getById(id);
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        return orderService.getAll();
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
         try {
            orderService.registerObserver(observer);
        } catch (RemoteException ex) {
            Logger.getLogger(CustomerControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        try {
            orderService.unregisterObserver(observer);
        } catch (RemoteException ex) {
            Logger.getLogger(CustomerControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean reserve(String orderId) throws RemoteException {
        return orderService.reserve(orderId, orderService);
    }

    @Override
    public boolean release(String orderId) throws RemoteException {
        return orderService.release(orderId);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
