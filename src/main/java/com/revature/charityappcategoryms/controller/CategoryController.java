package com.revature.charityappcategoryms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.charityappcategoryms.dto.Message;
import com.revature.charityappcategoryms.model.Category;
import com.revature.charityappcategoryms.service.CategoryService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CategoryController {
	

	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("addCategory")
	@ApiOperation(value = "CategoryAPI")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Category added", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Category", response = Category.class) })

	public ResponseEntity<?> addCategory(@RequestParam("created_by") int creator,@RequestParam("category_name") String categoryName) {

		Message message = null;
		String errorMessage = null;
		String status = null;
	

		try {
			Category category=new Category();
			category.setCreator(creator);
			category.setCategoryName(categoryName);
			categoryService.addCategory(category);
			
			status = "Category successfully added";
		} catch (Exception e) {
			errorMessage = e.getMessage();
		}

		if (status != null) {

			message = new Message(status);
			return new ResponseEntity<>(message, HttpStatus.CREATED);
		} else {
			message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("viewCategory")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Category> viewCategory() {
		Category category = null;
		List<Category> viewResponse = null;

		viewResponse = categoryService.listCategory(category);
		return viewResponse;

	}
}
