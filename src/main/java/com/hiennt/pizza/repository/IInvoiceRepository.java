package com.hiennt.pizza.repository;

import com.hiennt.pizza.entity.TblInvoice;
import com.hiennt.pizza.entity.TblInvoiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IInvoiceRepository extends JpaRepository<TblInvoice, TblInvoiceId> {
	List<TblInvoice> findByIdCusId (Integer cusId);
	List<TblInvoice> findByTblCustomerCusNameContaining (String cusName);
	List<TblInvoice> findByTblProductProNameContaining (String proName);
	TblInvoice findById (TblInvoiceId invoiceId);
}
