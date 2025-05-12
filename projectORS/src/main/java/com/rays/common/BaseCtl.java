package com.rays.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.rays.dto.UserDTO;

/**
 * Base controller class contains get, search, save, delete REST APIs
 * 
 * @author kanak
 */
public abstract class BaseCtl<F extends BaseForm, T extends BaseDTO, S extends BaseServiceInt<T>> {

	// Form operations
	protected static final String OP_SAVE = "Save";
	protected static final String OP_NEW = "New";
	protected static final String OP_DELETE = "Delete";
	protected static final String OP_CANCEL = "Cancel";
	protected static final String OP_ERROR = "Error";
	protected static final String OP_NEXT = "Next";
	protected static final String OP_PREVIOUS = "Previous";
	protected static final String OP_LOGOUT = "Logout";
	protected static final String OP_GO = "Go";
	protected static final String OP_GET = "Get";

	@Autowired
	protected S baseService;

	@Value("${page.size}")
	private int pageSize = 0;

	protected UserContext userContext = null;

	@ModelAttribute
	public void setUserContext(HttpSession session) {
		userContext = (UserContext) session.getAttribute("userContext");
		if (userContext == null) {
			UserDTO dto = new UserDTO();
			dto.setLoginId("root@sunilos.com");
			dto.setFirstName("demo firstName");
			dto.setLastName("demo lastName");
			dto.setOrgId(0L);
			dto.setRoleId(1L);
			dto.setOrgName("root");
			userContext = new UserContext(dto);
		}
	}

	@GetMapping
	public ORSResponse get() {
		ORSResponse res = new ORSResponse(true);
		res.addData("I am okay " + this.getClass() + " --" + new Date());
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable long id) {
		ORSResponse res = new ORSResponse(true);
		T dto = baseService.findById(id, userContext);
		if (dto != null) {
			res.addData(dto);
		} else {
			res.setSuccess(false);
		}
		return res;
	}

	@GetMapping("delete/{id}")
	public ORSResponse delete(@PathVariable long id) {
		ORSResponse res = new ORSResponse(true);
		try {
			T dto = baseService.delete(id, userContext);
			res.addData(dto);
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
		}
		return res;
	}

	@PostMapping("deleteMany/{ids}")
	public ORSResponse deleteMany(@PathVariable String[] ids, @RequestParam("pageNo") String pageNo, @RequestBody F form) {
		ORSResponse res = new ORSResponse(true);
		try {
			for (String id : ids) {
				baseService.delete(Long.parseLong(id), userContext);
			}
			T dto = (T) form.getDto();
			List<T> list = baseService.search(dto, Integer.parseInt(pageNo), pageSize, userContext);
			res.addData(list);
			res.setSuccess(true);
			res.addMessage("Records Deleted Successfully");
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
		}
		return res;
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody F form) {
		int pageNo = form.getPageNo();
		String operation = form.getOperation();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}
		pageNo = Math.max(pageNo, 0);
		form.setPageNo(pageNo);

		T dto = (T) form.getDto();
		ORSResponse res = new ORSResponse(true);
		res.addData(baseService.search(dto, pageNo, pageSize, userContext));
		return res;
	}

	@RequestMapping(value = "/search/{pageNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ORSResponse search(@RequestBody F form, @PathVariable int pageNo) {
		pageNo = Math.max(pageNo, 0);

		T dto = (T) form.getDto();
		ORSResponse res = new ORSResponse(true); 

		res.addData(baseService.search(dto, pageNo, pageSize, userContext));

		List<T> nextList = baseService.search(dto, pageNo + 1, pageSize, userContext);
		res.addResult("nextList", nextList.size());
		return res;
	}

	@PostMapping("/save")
	public ORSResponse save(@Valid @RequestBody F form, BindingResult bindingResult) {
		ORSResponse res = validate(bindingResult);
		if (!res.isSuccess()) {
			return res;
		}
		try {
			T dto = (T) form.getDto();
			if (dto.getId() != null && dto.getId() > 0) {
				T existDto = baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
				if (existDto != null && dto.getId() != existDto.getId()) {
					res.addMessage(dto.getLabel() + " already exists");
					res.addData(dto);
					res.setSuccess(false);
					return res;
				}
				baseService.update(dto, userContext);
			} else {
				if (dto.getUniqueKey() != null && !dto.getUniqueKey().isEmpty()) {
					T existDto = baseService.findByUniqueKey(dto.getUniqueKey(), dto.getUniqueValue(), userContext);
					if (existDto != null) {
						res.addMessage(dto.getLabel() + " already exists");
						res.setSuccess(false);
						return res;
					}
					res.addData(dto);
				}
				baseService.add(dto, userContext);
			}
			res.addData(dto.getId());
		} catch (Exception e) {
			res.setSuccess(false);
			res.addMessage(e.getMessage());
			e.printStackTrace();
		}
		return res;
	}

	public ORSResponse validate(BindingResult bindingResult) {
		ORSResponse res = new ORSResponse(true);
		if (bindingResult.hasErrors()) {
			res.setSuccess(false);
			Map<String, String> errors = new HashMap<>();
			List<FieldError> list = bindingResult.getFieldErrors();

			list.forEach(e -> {
				errors.put(e.getField(), e.getDefaultMessage());
			});
			res.addInputErrors(errors);
		}
		return res;
		
		
	}
}
