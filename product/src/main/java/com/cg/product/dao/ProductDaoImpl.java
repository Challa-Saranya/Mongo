package com.cg.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.cg.product.dto.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	MongoTemplate mongotemplate;


	@Override
	public Product addProducts(Product prod) {
		// TODO Auto-generated method stub
		return mongotemplate.insert(prod);
	}

	@Override
	public List<Product> showAllProducts() {
		// TODO Auto-generated method stub
		return mongotemplate.findAll(Product.class);
	}

	@Override
	public Product searchProductById(int prodId) {
		// TODO Auto-generated method stub
		Product prod= mongotemplate.findById(prodId, Product.class);
		return prod;
	}

	@Override
	public Product updateProduct(Product prod) {
		// TODO Auto-generated method stub
		return mongotemplate.save(prod);
	}

	@Override
	public void deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		Product prod= mongotemplate.findById(prodId, Product.class);
		mongotemplate.remove(prod);
		
	}

}
