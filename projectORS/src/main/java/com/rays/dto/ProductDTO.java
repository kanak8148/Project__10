package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_PRODUCT")
public class ProductDTO extends BaseDTO {

	@Column(name = "TOTALQUANTITY", length = 50)
	private Long totalQuantity ;

	@Column(name = "PRODUCT", length = 100)
	private String product = null;

	@Column(name = "DATE")

	private Date date;

	@Column(name = "TOTALCOST", length = 100)
	private String totalCost = null;

	public Long getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	@Override
	public String getKey() {
		
		return id + " ";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "product";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("product", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}	
	
}
