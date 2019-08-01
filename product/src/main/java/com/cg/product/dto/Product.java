package com.cg.product.dto;




import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Document(collection="mongoproducts")
public class Product {
	@Id
	private Integer prodId;
	private String prodName;
	private String prodDesc;
	/*
	 * @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) private Date createdDate
	 * = new Date();
	 */
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfPurchase;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer prodId, String prodName, String prodDesc, Date dateOfPurchase) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.dateOfPurchase = dateOfPurchase;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", dateOfPurchase="
				+ dateOfPurchase + "]";
	}
	
	


	
	}