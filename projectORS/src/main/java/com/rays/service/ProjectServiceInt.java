package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.ProjectDTO;

public interface ProjectServiceInt extends BaseServiceInt<ProjectDTO>{
	
	public ProjectDTO findByName(String name, UserContext userContext);

}
