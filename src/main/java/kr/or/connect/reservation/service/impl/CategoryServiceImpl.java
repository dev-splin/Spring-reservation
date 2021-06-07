package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoryDao;
import kr.or.connect.reservation.dto.CategoryDTO;
import kr.or.connect.reservation.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	private final CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
		
	@Override
	@Transactional
	public List<CategoryDTO> getCategories() {
		return categoryDao.selectAll();
	}

	@Override
	@Transactional
	public int getCountByCategoryId(Long categoryId) {
		return categoryDao.selectCountByCategoryId(categoryId);
	}

	@Override
	@Transactional
	public int getCount() {
		return categoryDao.selectCount();
	}
	 
}
