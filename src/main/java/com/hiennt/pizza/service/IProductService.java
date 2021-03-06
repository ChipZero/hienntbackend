package com.hiennt.pizza.service;


import com.hiennt.pizza.entity.TblProduct;

import java.util.List;

public interface IProductService {
    List<TblProduct> getAll();
    TblProduct getById(int id);
    TblProduct add(TblProduct product) throws Exception;
    TblProduct update(TblProduct product) throws Exception;
    TblProduct delete(int id) throws Exception;
    List<TblProduct> getByName (String name);
    List<TblProduct> getByPrice (float price);
}
