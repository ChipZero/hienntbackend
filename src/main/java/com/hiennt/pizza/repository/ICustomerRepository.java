package com.hiennt.pizza.repository;

import com.hiennt.pizza.entity.TblCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ICustomerRepository extends JpaRepository<TblCustomer, Integer> {
	List<TblCustomer> findByCusNameContaining(String cusName);
	TblCustomer findByCusName (String cusName);
	TblCustomer findByCusZip (String cusZip);
	TblCustomer findByCusPhone(String cusPhone);
	TblCustomer findByCusId (Integer cusId);
}
