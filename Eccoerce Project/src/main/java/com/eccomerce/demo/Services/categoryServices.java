package com.eccomerce.demo.Services;

import com.eccomerce.demo.Entity.Category;
import com.eccomerce.demo.Exceptions.ResourceNotFoundException;
import com.eccomerce.demo.Repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class categoryServices {
    categoryRepository categoryRepository;

    @Autowired
    public categoryServices(categoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public String getAllCategories() {
     return categoryRepository.findAll().toString();

    }


    public Category addCategory(Category category) {

        return categoryRepository.save(category);

    }

    public boolean deleteCategoryById(String category_id) {
        Optional<Category> optionalCategory = categoryRepository.findById(Integer.valueOf(category_id));
        if (optionalCategory.isPresent()) {
            categoryRepository.deleteById(Integer.valueOf(category_id));
            return true;
        } else {
            return false;
        }
    }

    public ResponseEntity<Category> updateCategory(Integer category_id, Category categoryDetails) {

        Category updateCategory = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Person does not exist with id :" + category_id));
        updateCategory.setName(categoryDetails.getName());
        updateCategory.setDescription(categoryDetails.getDescription());
        updateCategory.setImage_Url(categoryDetails.getImage_Url());
        categoryRepository.save(updateCategory);
        return ResponseEntity.ok(updateCategory);
    }

    }


