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
import com.rays.dto.ItemDTO;
import com.rays.form.ItemForm;
import com.rays.service.CartServiceInt;
import com.rays.service.ItemServiceInt;




@RestController
@RequestMapping(value = "Item") 
public class ItemCtl extends BaseCtl<ItemForm, ItemDTO, ItemServiceInt> {
	@Autowired
	private ItemServiceInt itemService;
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		ItemDTO dto = new ItemDTO();
		
		List<DropdownList> list = itemService.search(dto, userContext);
		res.addResult("ItemList", list);
		return res;
	}

	@GetMapping("name/{name}")
	public ORSResponse get(@PathVariable String name) {
		ORSResponse res = new ORSResponse(true);
		ItemDTO dto = baseService.findByName(name, userContext);
		
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
			res.addMessage("Record not found");
		}
		return res;
	}
	

}
