package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.CartDTO;
import com.rays.dto.ProjectDTO;
import com.rays.form.CartForm;
import com.rays.service.CartServiceInt;
import com.rays.service.ProjectServiceInt;



@RestController
@RequestMapping(value = "Cart") 
  public class CartCtl extends BaseCtl<CartForm, CartDTO, CartServiceInt> {
	@Autowired
	private CartServiceInt CartService;
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		CartDTO dto = new CartDTO();
		
		List<DropdownList> list = CartService.search(dto, userContext);
		res.addResult("ProjectList", list);
		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		CartDTO dto = baseService.findByName(name, userContext);
		
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}
	

}
