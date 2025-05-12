package com.rays.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.ProductDAOInt;
import com.rays.dto.ProductDTO;
import com.rays.dto.ProjectDTO;
@Service
@Transactional
public class ProductServiceImpl extends BaseServiceImpl<ProductDTO, ProductDAOInt> implements ProductServiceInt{

	@Transactional(readOnly = true)
	public ProductDTO findByName(String name, UserContext userContext) {
		return baseDao.findByUniqueKey("name", name, userContext);
	}
}
		
	
	

	
	


