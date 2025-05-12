package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CartDTO;
import com.rays.dto.ProjectDTO;

public class CartForm  extends BaseForm{
	
	
	@Pattern(regexp = "^[A-Za-z ]+$", message = "Only letters are Allowed")

	@NotEmpty(message= "please Enter Customer name")
	private String customerName ;
	

	@NotEmpty(message= "please Enter product Name")
	private String product ;
	
	
	@NotNull(message = "please enter transactiion date")
	private Date date;
	
	@NotEmpty(message= "please Enter Quantitity Order")
	private String quantityOrdered ;

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
	
	public BaseDTO getDto() {

		CartDTO dto = initDTO(new CartDTO());
		dto.setCustomerName(customerName);
		dto.setProduct(product);
		dto.setDate(date);
		dto.setQuantityOrdered(quantityOrdered);
		return dto;
		
	

}
}
