package com.cg.product.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.product.dto.Product;
import com.cg.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productservice;
	@GetMapping("/getall")
	public ResponseEntity <List<Product>> showAllProducts(){
		List<Product> myLists= productservice.showAllProducts();
		if(myLists.isEmpty()) {
			return new ResponseEntity("No Product Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(myLists,HttpStatus.OK);
		
		
	}
	@PostMapping("/addall")
	public ResponseEntity<Product> addProducts(@RequestBody Product prod) {
		Product data= productservice.addProducts(prod);
		if(data==null) {
			return new ResponseEntity("Data Not Added", HttpStatus.NOT_FOUND);
		}
		
		 return new ResponseEntity<Product>(prod,HttpStatus.OK);
		
	}
	@PutMapping("/updateall")
	public ResponseEntity<Product> updateProduct(@RequestBody Product prod) {
		Product data= productservice.updateProduct(prod);
		if(data==null) {
			return new ResponseEntity("data not added",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Product>(prod,HttpStatus.OK);
		
	}
	@DeleteMapping("/delete")
	public void deleteProduct(@RequestParam("pid") int prodId) {
		productservice.deleteProduct(prodId);
	}
	@GetMapping("/search")
	public ResponseEntity<Product> searchProductById(@RequestParam("pid") int prodId) {
		Product data= productservice.searchProductById(prodId);
		if(data==null) {
			return new ResponseEntity("data not found",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Product>(data,HttpStatus.OK);
		
		
	}
	

}
