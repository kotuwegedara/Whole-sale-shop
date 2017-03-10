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
import lk.ijse.thogakade.controller.ServerConnectorFactory;
import lk.ijse.thogakade.controller.custom.ItemController;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.service.ServiceFactory;
import lk.ijse.thogakade.service.custom.ItemService;

/**
 *
 * @author Nawanjana
 */
public class ItemControlerImpl implements ItemController {

    private ItemService itemService;

    public ItemControlerImpl() throws Exception {
//        itemService = (ItemService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
        itemService = (ItemService) ServerConnectorFactory.getInstance().getService(ServiceFactory.ServiceTypes.ITEM);
    }

    //@Override
    public boolean save(ItemDTO t) throws Exception {
        return itemService.save(t);
    }

    //@Override
    public boolean update(ItemDTO t) throws Exception {
        return itemService.update(t);
    }

    //@Override
    public boolean delete(String id) throws Exception {
        return itemService.delete(id);
    }

//    @Override
    public ItemDTO getById(String id) throws Exception {
        return itemService.getById(id);
    }

//    @Override
    public ArrayList<ItemDTO> getAll() throws Exception {
        return itemService.getAll();
    }

    @Override
    public void registerObserver(Observer observer) throws RemoteException {
       
       itemService.registerObserver(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws RemoteException {
        itemService.unregisterObserver(observer);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserve(String itemId) throws RemoteException {
         return itemService.reserve(itemId, itemService);
    }

    @Override
    public boolean release(String itemId) throws RemoteException {
        return itemService.release(itemId);
    }

}
