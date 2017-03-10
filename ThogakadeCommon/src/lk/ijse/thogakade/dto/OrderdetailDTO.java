/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Nawanjana
 */
public class OrderdetailDTO extends SuperDTO{

    private Integer qty;
    private BigDecimal unitPrice;
    private OrderDTO orders;
    private ItemDTO item;
    
    public OrderdetailDTO() {
    }

    public OrderdetailDTO(Integer qty, BigDecimal unitPrice, OrderDTO orders) {
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.orders = orders;
    }

    public OrderdetailDTO(String text, String toString, int parseInt, double parseDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDTO getOrders() {
        return orders;
    }

    public void setOrders(OrderDTO orders) {
        this.orders = orders;
    }

    public ItemDTO getItem() {
        return item;
    }
    public void setItem(ItemDTO item){
        this.item = item;
    }

}
