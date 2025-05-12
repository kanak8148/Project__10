package com.rays.service;

import com.rays.common.BaseServiceInt;
import com.rays.common.UserContext;
import com.rays.dto.ItemDTO;

public interface ItemServiceInt extends BaseServiceInt<ItemDTO> {
	public ItemDTO findByName(String name, UserContext userContext);


}
