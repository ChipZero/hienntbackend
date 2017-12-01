package com.hiennt.pizza.service;


import com.hiennt.pizza.entity.TblCustomer;
import com.hiennt.pizza.repository.ICustomerRepository;
import com.hiennt.pizza.utils.Errors;
import com.hiennt.pizza.utils.HienntException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    
    @Override
    public List<TblCustomer> getAll() {
        Iterable<TblCustomer> iter = customerRepository.findAll();
        List<TblCustomer> listCus= new ArrayList<>();
        iter.forEach( cus -> listCus.add(cus));
        return listCus;
    }

    @Override
    public TblCustomer getById(int id) {
        TblCustomer obj = customerRepository.findOne(id);
        return obj;
    }


    @Override
    public TblCustomer update(TblCustomer customer) throws HienntException {
    	if(checkExistsInData(customer)) {
    		customerRepository.save(customer);
    		return customer;
    	}
		throw new HienntException(Errors.CUS_ERROR.getMessage(), Errors.CUS_ERROR.getId());
    }

    @Override
    public TblCustomer delete(int id) throws HienntException {
    	TblCustomer customer = customerRepository.findOne(id);
    	if (customer !=null) {
    		customerRepository.delete(customer);
    		return customer;
    	}
    	throw new HienntException(Errors.CUS_ERROR_ID.getMessage(),Errors.CUS_ERROR_ID.getId());
    }

	@Override
	public TblCustomer add(TblCustomer customer) throws HienntException{
		if(checkExistsInData(customer)) {
    		customerRepository.save(customer);
    		return customer;
    	}
		throw new HienntException(Errors.CUS_ERROR.getMessage(), Errors.CUS_ERROR.getId());
	}

	@Override
	public List<TblCustomer> getByName(String name) {
		List<TblCustomer> customer = customerRepository.findByCusNameContaining(name);
		return customer;
	}
	
	public boolean checkExistsInData(TblCustomer customer) throws HienntException {
		if (customerRepository.findByCusName(customer.getCusName())!= null)
			throw new HienntException(Errors.CUS_ERROR_NAME.getMessage(),Errors.CUS_ERROR_NAME.getId());
		else if (customerRepository.findByCusZip(customer.getCusZip())!= null)
			throw new HienntException(Errors.CUS_ERROR_ZIP.getMessage(),Errors.CUS_ERROR_ZIP.getId());
		return true;
	}
	
}
