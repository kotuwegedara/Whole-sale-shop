/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.CustomerController;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.CustomerService;


public class CustomerControllerImpl extends UnicastRemoteObject implements CustomerController {

    private CustomerService customerService;

    public CustomerControllerImpl() throws Exception {
                 
        customerService = (CustomerService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.CUSTOMER);
    }

    public boolean save(CustomerDTO t) throws Exception {
        boolean result = customerService.save(t);
        return result;
    }

    public boolean update(CustomerDTO t) throws Exception {
        System.out.println("Controller");
        boolean result = customerService.update(t);
        return result;
    }

    public boolean delete(String id) throws Exception {
        System.out.println("Welcome to controller Layer");
        boolean result = customerService.delete(id);
        return result;
    }

    public CustomerDTO getById(String id) throws Exception {
        CustomerDTO customer = customerService.getById(id);
        return  customer;
    }

    public ArrayList<CustomerDTO> getAll() throws Exception {
        ArrayList<CustomerDTO> allCustomers = customerService.getAll();
        return allCustomers;
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
         try {
            customerService.registerObserver(observer);
        } catch (RemoteException ex) {
            Logger.getLogger(CustomerControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        try {
            customerService.unregisterObserver(observer);
        } catch (RemoteException ex) {
            Logger.getLogger(CustomerControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserve(String customerId) throws RemoteException {
       return customerService.reserve(customerId, customerService);
    }

    @Override
    public boolean release(String customerId) throws RemoteException {
        return customerService.release(customerId);
    }

    
}
