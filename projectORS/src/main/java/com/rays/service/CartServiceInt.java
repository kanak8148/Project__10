package com.rays.service;

import com.rays.common.BaseDAOInt;
import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.CartDTO;
import com.rays.dto.ProjectDTO;

public interface CartServiceInt extends BaseServiceInt<CartDTO> {
	
	public CartDTO findByName(String name, UserContext userContext);


}
