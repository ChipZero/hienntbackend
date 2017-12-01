package com.hiennt.pizza.service;

import com.hiennt.pizza.entity.TblProduct;
import com.hiennt.pizza.entity.TblProtype;
import com.hiennt.pizza.repository.IProductRepository;
import com.hiennt.pizza.repository.IProtypeRepository;
import com.hiennt.pizza.utils.Errors;
import com.hiennt.pizza.utils.HienntException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<TblProduct> getAll() {
        Iterable<TblProduct> iter = productRepository.findAll();
        List<TblProduct> list= new ArrayList<>();
        iter.forEach( cus -> list.add(cus));
        return list;
    }

    @Override
    public TblProduct getById(int id) {
        TblProduct obj = productRepository.findOne(id);
        return obj;
    }

	@Override
	public TblProduct add(TblProduct product) throws Exception {
		if(checkFieldExists(product)) {
			productRepository.save(product);
			return product;
		}
		throw new HienntException(Errors.PRO_ERROR.getMessage(), Errors.PRO_ERROR.getId());
	}

	@Override
	public TblProduct update(TblProduct product) throws Exception{
		if(checkFieldExists(product)) {
			productRepository.save(product);
			return product;
		}
		throw new HienntException(Errors.PRO_ERROR.getMessage(), Errors.PRO_ERROR.getId());
	}

	@Override
	public TblProduct delete(int id) throws Exception {
		TblProduct obj = productRepository.findOne(id);
		if(obj != null) {
			productRepository.delete(id);
			return obj;
		}
		throw new HienntException(Errors.PRO_ERROR_ID.getMessage(), Errors.PRO_ERROR_ID.getId());
	}

	@Override
	public List<TblProduct> getByName(String name) {
		List<TblProduct> products = productRepository.findByProNameContaining(name);
		return products;
	}

	@Override
	public List<TblProduct> getByPrice(float price) {
		List<TblProduct> products = productRepository.findByProUnitPrice(price);
		return products;
	}
	
	boolean checkFieldExists(TblProduct product) throws HienntException {
		if (productRepository.findByProName(product.getProName())!= null)
			throw new HienntException(Errors.PRO_ERROR_NAME.getMessage(),Errors.PRO_ERROR_NAME.getId());
		return true;
	}
	
}
