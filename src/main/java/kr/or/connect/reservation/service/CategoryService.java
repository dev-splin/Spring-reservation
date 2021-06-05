package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getCategories();
	int getCountByCategoryId(Long categoryId);
	int getCount();
}
