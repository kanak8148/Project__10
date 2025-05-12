package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CartDTO;
import com.rays.dto.ItemDTO;

public class ItemForm extends BaseForm {

	@NotEmpty(message = "Please enter a brief overview")
	@Size(max = 1000, message = "Overview must not exceed 1000 characters")
	private String overview;

	@NotEmpty(message = "please Enter Title")
	private String title;

	@NotNull(message = "please enter Purchase date")
	private Date purchaseDate;

	@NotEmpty(message = "please Enter Category")
	private String category;

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BaseDTO getDto() {

		ItemDTO dto = initDTO(new ItemDTO());
		dto.setOverview(overview);
		dto.setTitle(title);
		dto.setPurchaseDate(purchaseDate);
		dto.setCategory(category);
		return dto;

	}

}
