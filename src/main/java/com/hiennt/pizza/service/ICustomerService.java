package com.hiennt.pizza.service;

import com.hiennt.pizza.entity.TblCustomer;

import java.util.List;

public interface ICustomerService {
    List<TblCustomer> getAll();
    TblCustomer getById(int id);
    TblCustomer add(TblCustomer customer) throws Exception;
    TblCustomer update(TblCustomer customer) throws Exception;
    TblCustomer delete(int id) throws Exception;
    List<TblCustomer> getByName(String name);
}
