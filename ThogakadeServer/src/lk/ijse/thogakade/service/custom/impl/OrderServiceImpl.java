/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observer;
import lk.ijse.thogakade.bisnuss.custom.OrderBO;
import lk.ijse.thogakade.dto.OrderDTO;
import lk.ijse.thogakade.reservation.Reservation;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.OrderService;

/**
 *
 * @author Nawanjana
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService {
    
    private OrderBO orderBO;
    
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    
    private static Reservation orderReservation = new Reservation() {
        @Override
        public boolean reserve(String orderId,SuperService service) throws RemoteException {
            return orderReservation.reserve(orderId,service);
        }

        @Override
        public boolean release(String orderId) throws RemoteException {
           return orderReservation.release(orderId);
        }
    };


    public  OrderServiceImpl() throws RemoteException{
        
    }

    @Override
    public boolean save(OrderDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDTO t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDTO getById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyAllObservers(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserve(String orderId, SuperService service) throws RemoteException {
        return orderReservation.reserve(orderId, service);
    }

    @Override
    public boolean release(String orderId) throws RemoteException {
       return orderReservation.release(orderId);
    }
    
}
