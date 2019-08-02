package com.cg.product.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="producttable")
public class Product {
	@Id
	@Column(name="pro_Id")
	private Integer proId;
	@Column(name="pro_Name")
	private String proName;
	@Column(name="pro_Desc")
	private String proDesc;
	@Column(name="pro_Price")
	private Double proPrice;
	@Column(name="pro_Category")
	private String proCategory;
	@Column(name="logo")
	private byte[] logo;
	@Column(name="file_name")
	private String filename;
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public Double getProPrice() {
		return proPrice;
	}
	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] bs) {
		this.logo = bs;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Product(Integer proId, String proName, String proDesc, Double proPrice, String proCategory, byte[] logo,
			String filename) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proPrice = proPrice;
		this.proCategory = proCategory;
		this.logo = logo;
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName + ", proDesc=" + proDesc + ", proPrice=" + proPrice
				+ ", proCategory=" + proCategory + ", logo=" + logo + ", filename=" + filename + "]";
	}
	
	

}
