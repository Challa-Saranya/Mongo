package com.cg.product.service;

import java.util.List;


import com.cg.product.dto.Product;

public interface ProductService {

	public List<Product> showAllProduct();
	public Product addProduct(Product prod);
	public Product searchByProductId(int prod);
	public void deleteProduct(int proId);
	public Product updateProduct(Product prod);
	public Product save(Product product);

}
