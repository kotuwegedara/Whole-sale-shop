
package lk.ijse.thogakade.service.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Observer;
import lk.ijse.thogakade.bisnuss.BOFactory;
import lk.ijse.thogakade.bisnuss.custom.CustomerBO;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.reservation.Reservation;
import lk.ijse.thogakade.reservation.impl.ReservationImpl;
import lk.ijse.thogakade.service.SuperService;
import lk.ijse.thogakade.service.custom.CustomerService;

/**
 *
 * @author Nawanjana
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    private CustomerBO customerBO;
    
     private static ArrayList<Observer> alObservers = new ArrayList<>();
    
    private static Reservation customerReservation = new ReservationImpl();

    public CustomerServiceImpl() throws Exception {
        try {
            customerBO = (CustomerBO) BOFactory.getInstance().getBOTypes(BOFactory.BOType.CUSTOMER);
            
        } catch (Exception ex) {

        }
    }

    @Override
    public boolean save(CustomerDTO t) throws Exception {
        return customerBO.save(t);
    }

    @Override
    public boolean update(CustomerDTO t) throws Exception {
        return customerBO.update(t);
    }

    @Override
    public boolean delete(String id) throws Exception {
         System.out.println("Welcome to Service Layer");
        return customerBO.delete(id);
    }

    @Override
    public CustomerDTO getById(String id) throws Exception {
        return customerBO.getById(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws Exception {
        return customerBO.getAll();
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        alObservers.remove(observer);
    }

//    @Override
//    public void notifyAllObservers(String message) throws RemoteException {
//        for (Observer alObserver : alObservers) {
//            alObservers.update();
//        }
//    }

    @Override
    public void notifyAllObservers(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public boolean reserve(String customerId) throws RemoteException {
//        return customerReservation.reserve(customerId);
//    }

    @Override
    public boolean release(String customerId) throws RemoteException {
        return customerReservation.release(customerId);
    }

    @Override
    public boolean reserve(String customerId, SuperService service) throws RemoteException {
        return customerReservation.reserve(customerId, service);
    }

    
}
