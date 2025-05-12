package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CartDTO;
import com.rays.dto.ItemDTO;
@Repository
public class ItemDAOImpl extends BaseDAOImpl<ItemDTO>implements ItemDAOInt {

	@Override
	protected List<Predicate> getWhereClause(ItemDTO dto, CriteriaBuilder builder, Root<ItemDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();

		if (!isEmptyString(dto.getOverview())) {

			whereCondition.add(builder.like(qRoot.get("overview"), dto.getOverview()+ "%"));
		}
		

		if (!isEmptyString(dto.getTitle())) {

			whereCondition.add(builder.like(qRoot.get("title"), dto.getTitle() + "%"));
		}
		
		if (!isEmptyString(dto.getCategory())) {

			whereCondition.add(builder.like(qRoot.get("category"), dto.getCategory() + "%"));
		}
		if (isNotNull(dto.getPurchaseDate())) {
			

			whereCondition.add(builder.equal(qRoot.get("purchasedate"), dto.getPurchaseDate()));
		}


		return whereCondition;
	}
	

	@Override
	public Class<ItemDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return ItemDTO.class;
	}
	

}
