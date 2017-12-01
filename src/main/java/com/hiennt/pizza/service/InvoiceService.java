package com.hiennt.pizza.service;



import com.hiennt.pizza.entity.TblInvoice;
import com.hiennt.pizza.entity.TblInvoiceId;
import com.hiennt.pizza.repository.ICustomerRepository;
import com.hiennt.pizza.repository.IInvoiceRepository;
import com.hiennt.pizza.repository.IProductRepository;
import com.hiennt.pizza.utils.Errors;
import com.hiennt.pizza.utils.HienntException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InvoiceService implements IInvoiceService {

    @Autowired
    private IInvoiceRepository invoiceRepository;
    
    @Autowired
    private IProductRepository productsRepository;
    
    @Autowired
    private ICustomerRepository customersRepository;
    

    @Override
    public List<TblInvoice> getAll() {
        Iterable<TblInvoice> iter = invoiceRepository.findAll();
        List<TblInvoice> list = new ArrayList<>();
        iter.forEach(invoice -> list.add(invoice));
        return list;
    }

	@Override
	public TblInvoice getById(Integer cusId, Integer proId){
		TblInvoiceId invoiceId = new TblInvoiceId(cusId, proId);
			return invoiceRepository.findOne(invoiceId);
	}

	@Override
	public TblInvoice delete(Integer cusId, Integer proId) throws Exception {
		TblInvoiceId invoiceId = new TblInvoiceId(cusId,proId);
		TblInvoice invoice = invoiceRepository.findOne(invoiceId);
		if (invoice !=null) {
			invoiceRepository.delete(invoice);
			return invoice;
		}
		throw new HienntException(Errors.INV_ERROR.getMessage(),Errors.INV_ERROR.getId());
	}


	@Override
	public TblInvoice add(TblInvoice invoice) throws Exception {
		if (checkDataExists(invoice)) {
			TblInvoiceId invoiceId = new TblInvoiceId(invoice.getId().getCusId(),invoice.getId().getProId());
			if(invoiceRepository.findById(invoiceId)!=null)
				throw new HienntException(Errors.INV_ERROR_ID.getMessage(), Errors.INV_ERROR_ID.getId());
			invoiceRepository.save(invoice);
			return invoice;
		}
		throw new HienntException(Errors.INV_ERROR.getMessage(),Errors.INV_ERROR.getId());
	}

	@Override
	public TblInvoice update(TblInvoice invoice) throws Exception {
		if (checkDataExists(invoice)) {
			invoiceRepository.save(invoice);
			return invoice;
		}
		throw new HienntException(Errors.INV_ERROR.getMessage(),Errors.INV_ERROR.getId());
	}
		

	@Override
	public List<TblInvoice> getByIdCusId(Integer cusId) {
		return invoiceRepository.findByIdCusId(cusId);
	}

	@Override
	public List<TblInvoice> searchByCusName(String cusName) {
		return invoiceRepository.findByTblCustomerCusNameContaining(cusName);
	}

	@Override
	public List<TblInvoice> searchByProName(String proName) {
		return invoiceRepository.findByTblProductProNameContaining(proName);
	}
	
	boolean checkDataExists(TblInvoice invoice) throws HienntException{
		if(customersRepository.findByCusId(invoice.getId().getCusId())== null || productsRepository.findByProId(invoice.getId().getProId())==null)
			throw new HienntException(Errors.INV_ERROR_CUSANDPRO.getMessage(),Errors.INV_ERROR_CUSANDPRO.getId());
		return true;
	}	
}
