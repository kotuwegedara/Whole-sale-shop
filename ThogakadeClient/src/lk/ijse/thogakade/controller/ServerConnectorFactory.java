/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Observer;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.CustomerService;
import lk.ijse.thogakade.service.custom.ItemService;
import lk.ijse.thogakade.service.custom.OrderService;


public class ServerConnectorFactory {
    
    private static ServerConnectorFactory serverConnector;
    private static ServiceFactory serviceFactory;
    private static CustomerService customerService;
    private static ItemService itemService;
    private static OrderService orderService;

    private  ServerConnectorFactory() throws Exception {
        serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/ThogakadeServer");
        customerService = (CustomerService) serviceFactory.getService(ServiceFactory.ServiceTypes.CUSTOMER);
        itemService = (ItemService) serviceFactory.getService(ServiceFactory.ServiceTypes.ITEM);
        orderService = (OrderService) serviceFactory.getService(ServiceFactory.ServiceTypes.ORDER);
    }
    
    public static ServerConnectorFactory getInstance() throws Exception{
        if (serverConnector==null) {
            serverConnector = new ServerConnectorFactory();
        }
        return serverConnector;
    
    }
    
     public  void getRegisted(Observer observer) throws RemoteException{
//        serviceFactory.registerObserver(observer);
          customerService.registerObserver(observer);
    }
    
    public SuperService getService(ServiceFactory.ServiceTypes serviceType){
        switch(serviceType){
            case CUSTOMER:
                return customerService;
            case ITEM:
                return itemService;
            case ORDER:
                return orderService;
            default:
                return null;
        }
    }
    
   
}
