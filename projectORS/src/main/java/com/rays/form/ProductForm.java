package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;

import com.rays.dto.ProductDTO;

public class ProductForm extends BaseForm {

	@NotNull(message = "please enter  totalQuantity")
	private Long totalQuantity;

	@NotEmpty(message = "please Enter ProductName")
	private String product;

	@NotNull(message = "please enter Date")
	private Date date;

	@NotEmpty(message = "please Enter Total Cost")
	private String totalCost;

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

	public BaseDTO getDto() {

		ProductDTO dto = initDTO(new ProductDTO());

		dto.setTotalQuantity(totalQuantity);
		dto.setProduct(product);
		dto.setDate(date);
		dto.setTotalCost(totalCost);
		return dto;

	}
}
