/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.thogakade.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.thogakade.dto.SuperDTO;

/**
 *
 * @author Nawanjana
 */
public interface SuperDAO<T extends SuperDTO> {
    
    public enum Tables{
        
        CUSTOMER("customer"), ITEM("item"), ORDER("order"), ORDER_DETAILS("orderdetails");
        
        private String tblName;
        
        private Tables(String tableName){
            tblName = tableName;
        }
        
        public String getTableName(){
            return tblName;
        }
    }
    
    public enum PrimaryKeys{
        CUSTID("id"), CODE("code");
        
        private String priKey;
        
        private PrimaryKeys(String primaryKey){
            priKey = primaryKey;
        }
        
        public String getPrimaryKeyName(){
            return priKey;
        }
    }
    public void setConnection(Connection connection)throws Exception;
    
    public Connection getConnection();
    
     public default boolean save(SuperDTO dto)throws Exception{
         
          Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Class<? extends SuperDTO> aClassDTO = dto.getClass();
        Field[] declaredFields = aClassDTO.getDeclaredFields();
        String sqlStm = "INSERT INTO " + tableName + " VALUES(";
        for (int i = 1; i < declaredFields.length; i++) {
            sqlStm += "?,";
        }
        sqlStm += "?)";
        System.out.println(sqlStm);
        PreparedStatement pst = connection.prepareStatement(sqlStm);
        int i = 1;

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(dto);
            pst.setObject(i, value);
            i++;
        }

        int result = pst.executeUpdate();
        return (result > 0);
    }
     
    public default boolean update(T dto) throws Exception{
         Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Class<? extends SuperDTO> aClassDTO = dto.getClass();
        Field[] declaredFields = aClassDTO.getDeclaredFields();
        Statement statement = connection.createStatement();
        ResultSet rstColoumnHedding = statement.executeQuery("desc " + tableName + ";");

        rstColoumnHedding.next();
        String primaryField = rstColoumnHedding.getString(1);

        String sqlStm = "UPDATE " + tableName + " SET ";

        while (rstColoumnHedding.next()) {
            sqlStm += (rstColoumnHedding.getString(1) + " = ?,");
        }

        sqlStm = sqlStm.substring(0, sqlStm.length() - 1);
        sqlStm += " WHERE " + primaryField + " = ?";

        System.out.println(sqlStm);
        PreparedStatement pst = connection.prepareStatement(sqlStm);

        int i = declaredFields.length;

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(dto);
            System.out.println(value);
            if (i == declaredFields.length) {
                pst.setObject(i, value);
                i = 0;
            } else {
                pst.setObject(i, value);
            }
            i++;
        }
        System.out.println(pst.toString());
        int result = pst.executeUpdate();
        return (result > 0);
    }
    
    public default boolean delete(String id)throws Exception{
        
        Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        System.out.println(tableName);

        Field[] declaredFields = aClass.getDeclaredFields();
        Statement statement = connection.createStatement();
        ResultSet rstColoumnHedding = statement.executeQuery("desc " + tableName + " ;");

        rstColoumnHedding.next();
        String primaryKey = rstColoumnHedding.getString(1);

        System.out.println(primaryKey);

        String sqlStm = "DELETE FROM " + tableName + " WHERE " + primaryKey + " = '" + id + "' ";
        PreparedStatement pst = connection.prepareStatement(sqlStm);

        System.out.println(pst.toString());
        int result = pst.executeUpdate();
        return (result < 1);
        
    }
    
    
    public default T getById(String id)throws Exception{
        
        Class<? extends SuperDAO> aClass = this.getClass();
        Field constTableName = aClass.getDeclaredField("TABLE_NAME");
        constTableName.setAccessible(true);
        String tableName = (String) constTableName.get(this);
        
        SuperDTO dto = null;
        
        String sqlStm = "SELECT * FROM " + tableName;
        
        Connection connection = this.getConnection();
        PreparedStatement pstm = connection.prepareStatement(null);
        
        return (T) dto;
    }
    
        public default T getById(Tables table,T t)throws Exception{
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Class<? extends SuperDTO> aClass = t.getClass();
        Field[] declaredFields;
        declaredFields = aClass.getDeclaredFields();
        PreparedStatement stm = (PreparedStatement) connection.createStatement();
        ResultSet rst1 = stm.executeQuery("desc "+table.getTableName()+" ;");
        rst1.next();
        String primaryKey;
        primaryKey = rst1.getString(1);
        
        String sqlStm="SELECT * FROM "+table.getTableName()+" WHERE "+primaryKey+"='";
        declaredFields[0].setAccessible(true);        
        sqlStm+=declaredFields[0].get(t).toString()+"'";
        PreparedStatement stm2=(PreparedStatement) connection.createStatement();
        ResultSet rst = stm2.executeQuery(sqlStm);
        rst.next();
        int i=0;
        for(Field field:declaredFields){
            field.set(t, rst.getObject(i));
        }
        return t;
    }
    
    public default ArrayList<T> getAll() throws Exception{
        ArrayList<T> all = new ArrayList<>();

        Class<? extends SuperDAO> aClass = this.getClass();

        Field constTabelName = aClass.getDeclaredField("TABLE_NAME");
        constTabelName.setAccessible(true);
        String tableName = (String) constTabelName.get(this);

        Connection connection = this.getConnection();

        Type t = this.getClass().getInterfaces()[0].getGenericInterfaces()[0];
        ParameterizedType pt = (ParameterizedType) t;
        Class dtoTemp = (Class) pt.getActualTypeArguments()[0];
        T dtoA = (T) dtoTemp.newInstance();

        Class<? extends SuperDTO> aClassDTO = dtoA.getClass();
        Field[] declaredFields = aClassDTO.getDeclaredFields();

        String sqlStm = "SELECT * FROM " + tableName;
        PreparedStatement pst = connection.prepareStatement(sqlStm);
        ResultSet rst = pst.executeQuery(sqlStm);

        while (rst.next()) {
            int i = 1;
            T dto = (T) dtoTemp.newInstance();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);

                Object object = rst.getObject(i);
                if (object instanceof BigDecimal) {
                    BigDecimal b = (BigDecimal) object;
                    declaredField.set(dto, b.doubleValue());
                } else {
                    declaredField.set(dto, rst.getObject(i));
                }
                i++;
            }
            all.add(dto);
        }
        return all;
//        Class<? extends SuperDAO> aClass = this.getClass();
//        Field constTableName = aClass.getDeclaredField("TABLE_NAME");
//        constTableName.setAccessible(true);
//        String tableName = (String) constTableName.get(this);
//        ArrayList<T> alCustomers = new ArrayList<>();
//        
//        SuperDTO dto = null;
//        
//        String sqlStm = "SELECT * FROM " + tableName;
//        
//        Connection connection = this.getConnection();
//        PreparedStatement pstm = connection.prepareStatement(sqlStm);
//        
//        return alCustomers;
    }
    
//     public default ArrayList<T> getAll(Tables table,T t)throws Exception{
//        System.out.println(this);
//        
//        Connection connection = ConnectionFactory.getInstance().getConnection();
//        
//        Class<? extends SuperDTO> dtoClass = t.getClass();
//        
//        Field[] declaredFields = dtoClass.getDeclaredFields();
//        
//        String sqlStm = "SELECT * FROM "+table.getTableName()+";";
//        
//        ArrayList<T> all = new ArrayList<>();
//        
////        for(int i=1;i<declaredFields.length;i++){
////            sqlStm+="?, ";
////        }
////        sqlStm+="?)";
//        PreparedStatement ps=connection.prepareStatement(sqlStm);
////        int i=0;
////        for(Field f:declaredFields){
////            f.setAccessible(true);
////            ps.setObject(i, f.get(t));
////            i++;
//          
////            
////        }
//        
//        System.out.println(sqlStm);
//        int result=ps.executeUpdate();
//        connection.close();
//         all.add(t);
//        
//        return (ArrayList<T>) all;
//    }
//    
}
