/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.controller.custom;

import java.util.ArrayList;
import lk.ijse.thogakade.controller.SuperController;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.dto.ItemDTO;
import lk.ijse.thogakade.dto.OrderDTO;

/**
 *
 * @author Nawanjana
 */
public interface PlaceOrderController extends SuperController<OrderDTO>{

    public ArrayList<CustomerDTO> getAllCustomer();

    public ArrayList<ItemDTO> getAllItem();
    
}
