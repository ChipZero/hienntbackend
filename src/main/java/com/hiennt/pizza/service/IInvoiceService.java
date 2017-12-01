package com.hiennt.pizza.service;

import com.hiennt.pizza.entity.TblInvoice;

import java.util.List;

public interface IInvoiceService {
    List<TblInvoice> getAll();
    TblInvoice getById(Integer cusId, Integer proId);
    TblInvoice add(TblInvoice invoice) throws Exception;
    TblInvoice update(TblInvoice invoice) throws Exception;
    TblInvoice delete(Integer cusId, Integer proId) throws Exception;
    List<TblInvoice> getByIdCusId (Integer cusId);
    List<TblInvoice> searchByCusName (String cusName);
    List<TblInvoice> searchByProName (String proName);
}
