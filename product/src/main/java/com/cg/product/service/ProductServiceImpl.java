package com.cg.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.product.dao.ProductDao;
import com.cg.product.dto.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productdao;

	@Override
	public Product addProducts(Product prod) {
		// TODO Auto-generated method stub
		return productdao.addProducts(prod);
	}

	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		return productdao.showAllProducts();
	}

	@Override
	public Product searchProductById(int prodId) {
		// TODO Auto-generated method stub
		return productdao.searchProductById(prodId);
	}

	@Override
	public Product updateProduct(Product prod) {
		// TODO Auto-generated method stub
		return productdao.updateProduct(prod);
	}

	@Override
	public void deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		productdao.deleteProduct(prodId);
		
	}

}
