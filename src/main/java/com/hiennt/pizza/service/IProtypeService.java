package com.hiennt.pizza.service;

import com.hiennt.pizza.entity.TblProtype;

import java.util.List;

public interface IProtypeService {
    List<TblProtype> getAll();
    TblProtype getById(int id);
    TblProtype add(TblProtype tblProtype) throws Exception;
    TblProtype update(TblProtype tblProtype) throws Exception;
    TblProtype delete(int id) throws Exception;
}
