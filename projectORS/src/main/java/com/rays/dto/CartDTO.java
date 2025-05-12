package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_CART")
public class CartDTO extends BaseDTO {

	@Column(name = "CUSTOMERNAME", length = 100)
	private String customerName = null;

	@Column(name = "PRODUCT", length = 100)
	private String product = null;

	@Column(name = "DATE")

	private Date date;

	@Column(name = "QUANTITYORDERED", length = 100)
	private String quantityOrdered = null;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(String quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "customerName";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return customerName;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return customerName;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("customerName", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
