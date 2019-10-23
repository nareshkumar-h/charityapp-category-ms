package com.revature.charityappcategoryms.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CategoryDTO {
	
	private int id;
	private String categoryName;
	private int createdBy;
	private boolean active;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

}
