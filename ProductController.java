package com.cg.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.product.dto.Product;
import com.cg.product.response.Response;
import com.cg.product.service.ProductService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
	@RequestMapping("/emplist")
	@CrossOrigin(origins="http://localhost:4200")
	public class ProductController {
		@Autowired
		ProductService productservice;
		@PostMapping(value="saveUserProfile")
		public ResponseEntity<Response> saveUserProfile(@RequestParam("file") MultipartFile file,@RequestParam("user") String user) throws JsonParseException, JsonMappingException, IOException{
			Product product=new ObjectMapper().readValue(user,Product.class);
			product.setLogo(file.getBytes());
			product.setFilename(file.getOriginalFilename());	
			Product dbProduct=productservice.save(product);
			if(dbProduct!=null) {
				return new ResponseEntity<Response>(new Response("saved"),HttpStatus.OK);
			}
			return new ResponseEntity<Response>(new Response("not saved"),HttpStatus.BAD_REQUEST);
			
		}
		
		//@RequestMapping(value="/getalldata",method = RequestMethod.GET)
		@GetMapping("/getalldata")
		public ResponseEntity<List<Product>> showAllProduct() {
			List<Product> myList=productservice.showAllProduct();
			if(myList.isEmpty()) {
				return new ResponseEntity("No Employee Found", HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Product>>(myList,HttpStatus.OK);
			
		}
		@PostMapping("/adddata")
		public ResponseEntity<Product> addProduct(@RequestBody Product prod) {
			Product data=productservice.addProduct(prod);
			if(data==null) {
				return new ResponseEntity("Data Not Added", HttpStatus.NOT_FOUND);
			}
			
			 return new ResponseEntity<Product>(prod,HttpStatus.OK);
			
		}

		/*
		 * @RequestMapping(value = "/updateemployee", method = RequestMethod.POST)
		 * public Employee updateProduct(@RequestBody Employee employee) { return
		 * employeeservice.updateEmployee(employee); }
		 */
		@PostMapping("/updateData")
		public ResponseEntity<Product> update(@RequestBody Product prod) {
			Product data=productservice.updateProduct(prod);
			if(data==null) {
			return new ResponseEntity("data not added",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Product>(prod,HttpStatus.OK);
			}
		@RequestMapping(value="/searchemployee/{eid}",method=RequestMethod.GET)
		public Product searchemployee(@PathVariable("eid") Integer proId)
		{
		return productservice.searchByProductId(proId);
		}
		@RequestMapping(value = "/deletemployee/{eid}", method = RequestMethod.DELETE)
		public String delProduct(@PathVariable("eid") Integer employeeid) {
			productservice.deleteProduct(employeeid);
		return  employeeid+" is deleted";
		}

	}

