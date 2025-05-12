package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ProjectDTO;
import com.rays.dto.RoleDTO;

public class ProjectForm extends BaseForm {
	
	
	@NotEmpty(message= "please enter name")
	private String name;
	
	@NotEmpty(message= "please enter description")
	private String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BaseDTO getDto() {

	ProjectDTO dto = initDTO(new ProjectDTO());
	dto.setDescription(description);
	System.out.println(dto.getDescription()+"___________");
	dto.setName(name);
	return dto;
	

}
	
}
	