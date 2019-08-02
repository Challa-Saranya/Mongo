package com.cg.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.dao.ProductDao;
import com.cg.product.dto.Product;



@Service

public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productdao;

	

	@Override
	public List<Product> showAllProduct() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}

	@Override
	public Product addProduct(Product prod) {
		// TODO Auto-generated method stub
		return productdao.save(prod);
	}

	@Override
	public Product searchByProductId(int proId) {
		// TODO Auto-generated method stub
		Product id = productdao.findById(proId).get();
		return id;
	}

	@Override
	public void deleteProduct(int proId) {
		// TODO Auto-generated method stub
		productdao.deleteById(proId);
		
	}

	@Override
	/*public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeerepository.save(emp);
		return emp;
	}*/
	public Product updateProduct(Product prod) {
	// TODO Auto-generated method stub
	Optional<Product> pro1=productdao.findById(prod.getProId());
	Product pro=pro1.get();
	  pro.setProName(prod.getProName()); 
	  pro.setProPrice(prod.getProPrice());
	  productdao.save(pro);
	return prod;

	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}

