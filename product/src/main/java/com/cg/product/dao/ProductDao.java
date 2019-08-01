package com.cg.product.dao;

import java.util.List;

import com.cg.product.dto.Product;

public interface ProductDao {
	public Product addProducts(Product prod);
	public List<Product> showAllProducts();
	public Product searchProductById(int prodId);
	public Product updateProduct(Product prod);
	public void deleteProduct(int prodId);

}
