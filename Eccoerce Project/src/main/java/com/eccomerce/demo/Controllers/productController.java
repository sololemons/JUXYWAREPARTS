package com.eccomerce.demo.Controllers;

import com.eccomerce.demo.Dtos.ProductDto;
import com.eccomerce.demo.Entity.Category;
import com.eccomerce.demo.Entity.Product;
import com.eccomerce.demo.Repository.categoryRepository;
import com.eccomerce.demo.Repository.productRepository;
import com.eccomerce.demo.Services.productServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v2/Product")
public class productController {


    private productServices productServices;
    @Autowired

    public productController(productServices productServices, com.eccomerce.demo.Repository.categoryRepository categoryRepository) {
        this.productServices = productServices;

    }
@Autowired
 private   categoryRepository categoryRepository;

private productRepository productRepository;


    @GetMapping("/Get")
    public String getAllProducts(@RequestBody Product product){
      return   productServices.getProduct(product);
    }
    @PostMapping("/Add")
    public ResponseEntity<ProductDto>addNewProduct(@RequestBody ProductDto productDto){
         Optional<Category>ID= categoryRepository.findById(productDto.getCategory_id());
        if (ID.isPresent()){
            productServices.createNewProduct(productDto,ID.get());
            return ResponseEntity.ok().body(productDto);

        }
        return ResponseEntity.notFound().build();


    }
    @PutMapping("Update/id/{product_id}")
    public ResponseEntity<ProductDto>editProduct(@RequestBody ProductDto productDto,@PathVariable Integer product_id)  {
        Optional<Category> optionalProduct = categoryRepository.findById(productDto.getCategory_id());
        if (optionalProduct.isPresent()){
            productServices.updateProduct(productDto,product_id);
            return ResponseEntity.ok().body(productDto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("Delete/{product_id}")
    public String deleteProductByProductId(@PathVariable Integer product_id) {
        productServices.deleteProductByproductId(product_id);
        return "Product Deleted Sucessfully";
    }
    }


