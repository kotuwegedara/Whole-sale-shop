/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.bisnuss;

import java.rmi.Remote;
import java.util.ArrayList;
import lk.ijse.thogakade.dto.SuperDTO;

/**
 *
 * @author Nawanjana
 */
public interface SuperBO<T extends SuperDTO> extends Remote {

    public boolean save(T t) throws Exception;

    public boolean update(T t) throws Exception;

    public boolean delete(String id) throws Exception;

    public T getById(String id) throws Exception;

    public ArrayList<T> getAll() throws Exception;

}
