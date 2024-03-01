package com.eccomerce.demo.Controllers;

import com.eccomerce.demo.Entity.Category;
import com.eccomerce.demo.Services.categoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/juxware")
public class categoryController {

    private categoryServices categoryServices;

    @Autowired

    public categoryController(categoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("/get")
    public String GetCategory() {
           return categoryServices.getAllCategories();
    }

    @PostMapping("/add")
    public Category addNewCategory(@RequestBody Category category) {
        return categoryServices.addCategory(category);
    }

    @PutMapping("update/id/{category_id}")
    public void changeCategoryCredentials(@PathVariable Integer category_id, @RequestBody Category categoryDetails){

        categoryServices.updateCategory(category_id,categoryDetails);
    }

    @DeleteMapping("/Delete/id/{category_id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String category_id) {
        boolean deleted = categoryServices.deleteCategoryById(category_id);
        if (deleted) {
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

    }
}