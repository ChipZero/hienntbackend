package com.hiennt.pizza.repository;

import com.hiennt.pizza.entity.TblProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductRepository extends JpaRepository<TblProduct, Integer> {
	TblProduct findByProName (String proName);
	List<TblProduct> findByProNameContaining (String proName);
	List<TblProduct> findByProUnitPrice (Float proUnitPrice);
	TblProduct findByProId (Integer proId);
}
