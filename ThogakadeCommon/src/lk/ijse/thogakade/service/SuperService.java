
package lk.ijse.thogakade.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observer;
import lk.ijse.thogakade.reservation.Reservation;


public interface SuperService<T> extends Remote,Reservation {

    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String id) throws Exception;

    public T getById(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;
    
    public void registerObserver(Observer observer) throws RemoteException;
    
    public void unregisterObserver(Observer observer) throws RemoteException;
    
    public void notifyAllObservers(String message)throws RemoteException;

}
