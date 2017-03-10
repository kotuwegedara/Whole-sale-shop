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
import lk.ijse.thogakade.bisnuss.BOFactory;
import lk.ijse.thogakade.bisnuss.custom.ItemBO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.reservation.Reservation;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author Nawanjana
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService{

    private ItemBO itemBO;

    private static ArrayList<Observer> alObservers = new ArrayList<>();
    
    private static Reservation itemReservation = new Reservation() {
        @Override
        public boolean reserve(String itemCode,SuperService service) throws RemoteException {
            return itemReservation.reserve(itemCode,service);
        }

        @Override
        public boolean release(String itemCode) throws RemoteException {
           return itemReservation.release(itemCode);
        }
    };

    
    public  ItemServiceImpl() throws Exception{
        try {
            itemBO = (ItemBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.ITEM);
        } catch (Exception ex) {
            System.out.println("a  " + ex);
        }
    }
    
    @Override
    public boolean save(ItemDTO t) throws Exception {
        return itemBO.save(t);
    }

    @Override
    public boolean update(ItemDTO t) throws Exception {
        return itemBO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return itemBO.delete(id);
    }

   
    @Override
    public ItemDTO getById(String id) throws Exception {
       return itemBO.getById(id);
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        return itemBO.getAll();
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
    public boolean reserve(String itemCode, SuperService service) throws RemoteException {
       return itemReservation.reserve(itemCode, service);
    }

    @Override
    public boolean release(String itemCode) throws RemoteException {
        return itemReservation.release(itemCode);
    }
    
}
