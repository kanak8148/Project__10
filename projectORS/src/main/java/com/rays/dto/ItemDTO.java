package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;


@Entity
@Table(name = "ST_ITEM")

public class ItemDTO  extends BaseDTO {
	
	@Column(name = "OVERVIEW", length = 10000)
	private String overview = null;

	@Column(name = "TITLE", length = 100)
	private String title = null;

	@Column(name = "PURCHASEDATE")

	private Date purchaseDate;

	@Column(name = "CATEGORY", length = 100)
	private String category = null;
	
	
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
	public String getKey() {
		return category;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return category;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "overview";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return overview;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return overview;
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("overview", "asc");
		return map;
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("category", category);
		return map;
	}
	

}
