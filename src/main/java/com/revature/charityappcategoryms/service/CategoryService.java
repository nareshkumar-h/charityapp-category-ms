package com.revature.charityappcategoryms.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.charityappcategoryms.dto.MessageConstant;
import com.revature.charityappcategoryms.exception.ServiceException;
import com.revature.charityappcategoryms.model.Category;
import com.revature.charityappcategoryms.repository.CategoryRepository;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional
	public void addCategory(Category category) throws ServiceException {
		category.setActive(true);
		category.setCreatedDate(LocalDateTime.now());
		category.setModifiedDate(LocalDateTime.now());
		category = categoryRepository.save(category);
		if (category == null) {
			throw new ServiceException(MessageConstant.INVALID_CATEGORY);
		}

	}
	
	@Transactional
	public List<Category> listCategory(Category category) {
		return categoryRepository.findAll();
	}

}
