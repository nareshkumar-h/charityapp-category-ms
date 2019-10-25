package com.revature.charityappcategoryms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.charityappcategoryms.dto.CategoryDTO;
import com.revature.charityappcategoryms.dto.Message;
import com.revature.charityappcategoryms.exception.ServiceException;
import com.revature.charityappcategoryms.model.Category;
import com.revature.charityappcategoryms.service.CategoryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

 /*
 * This method is used to add a new category
 * Takes object as parameters
 * returns the success or failure message
 * 
 */
	@PostMapping()
	@ApiOperation(value = "categoryAPI")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Category added", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Category", response = Category.class) })

	public ResponseEntity<?> addCategory(@RequestBody CategoryDTO categoryDTO) {

		try {
			categoryService.addCategory(categoryDTO);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (ServiceException e) {
			Message message = new Message(e.getMessage());
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
		}

	}

	/*
	 * This method shows the list of different categories
	 * It does not takes input parameters
	 * returns the category list
	 * 
	 */
	
	@GetMapping("/listCategory")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Category> viewCategory() {
		List<Category> viewResponse = categoryService.listCategory();
		return viewResponse;

	}
}
