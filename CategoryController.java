package com.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.model.Category;
import com.grocery.service.CategoryService;

@RestController
public class CategoryController 
{
@Autowired
CategoryService categoryService;
@GetMapping("/get/category")
public List<Category>getAllCategory()
{
	
	return categoryService.getAllCategory();
}
@PostMapping("post/category")
public void addCategory(@RequestBody List<Category> category) 
{
	categoryService.AddCategoryService(category);
}
@PutMapping("/{categoryId}")
public void UpdateCategory(@PathVariable Integer categoryid, @RequestBody Category category) 
{
	category.setCategoryId(categoryid);
	categoryService.UpdateCategory(category);
}
@DeleteMapping("/delete/{categoryId}")
public void DeleteCategory(@PathVariable int categoryid,@RequestBody Category category) 
{
	category.setCategoryId(categoryid);
	categoryService.DeleteCategory(category);
}
}
