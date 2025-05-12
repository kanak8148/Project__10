package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ProductDTO;
@Repository
public class ProductDAOImpl extends BaseDAOImpl<ProductDTO> implements ProductDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ProductDTO dto, CriteriaBuilder builder, Root<ProductDTO> qRoot) {
		// TODO Auto-generated method stub
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		

		if (!isEmptyString(dto.getProduct())) {

			whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct() + "%"));
		}
		
		
		if (isNotNull(dto.getDate())) {
			

			whereCondition.add(builder.equal(qRoot.get("date"), dto.getDate()));
		}
         if (isNotNull(dto.getTotalQuantity())) {
			

			whereCondition.add(builder.equal(qRoot.get("totalQuantity"), dto.getTotalQuantity()));
		}
         if (isNotNull(dto.getTotalQuantity())) {
 			

 			whereCondition.add(builder.equal(qRoot.get("totalQuantity"), dto.getTotalQuantity()));
 		}
     	if (!isEmptyString(dto.getTotalCost())) {

			whereCondition.add(builder.like(qRoot.get("totalCost"), dto.getProduct() + "%"));
		}
		
         


		return whereCondition;
	}
	

	@Override
	public Class<ProductDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ProductDTO.class;
	}
	
	

}
