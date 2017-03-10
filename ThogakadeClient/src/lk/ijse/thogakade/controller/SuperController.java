/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observer;
import lk.ijse.thogakade.dto.SuperDTO;


public interface SuperController<T extends SuperDTO> extends Observer {

    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String id) throws Exception;

    public T getById(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
    
    public void registerObserver(Observer observer) throws RemoteException;
    
    public void unregisterObserver(Observer observer) throws RemoteException;
    
    public boolean reserve(String customerId)throws RemoteException;
    
    public boolean release(String customerId)throws RemoteException;   

}
