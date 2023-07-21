package com.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.model.Category;
import com.grocery.repository.CategoryRepository;
@Service
public class CategoryService 
{
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getAllCategory()
	{
		return categoryRepository.getAllCategory();
		
	}

	public void AddCategoryService(List<Category> category) 
	{
		categoryRepository.AddCategoryRepository(category);
		
	}

	public void UpdateCategory(Category category) 
	{
		int b=categoryRepository.UpdateCategory(category);
		if(b==0) 
		{
			System.out.println("please enter valid id");
		}
	}

	public void DeleteCategory(Category category) 
	{
		int b=categoryRepository.DeleteCategory(category);
		if(b==0) 
		{
			System.out.println("please enter valid id");
		}
		
	}

}
