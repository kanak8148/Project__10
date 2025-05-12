package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.CartDAOInt;
import com.rays.dto.CartDTO;
import com.rays.dto.ProjectDTO;
@Service
@Transactional
public class CartServiceImpl extends BaseServiceImpl<CartDTO, CartDAOInt> implements CartServiceInt {
	
	@Transactional(readOnly = true)
	public CartDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("customerName", name, userContext);
	}

}
