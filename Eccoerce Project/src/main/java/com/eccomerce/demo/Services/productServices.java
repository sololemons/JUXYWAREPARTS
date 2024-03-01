package com.eccomerce.demo.Services;

import com.eccomerce.demo.Dtos.ProductDto;
import com.eccomerce.demo.Entity.Category;
import com.eccomerce.demo.Entity.Product;
import com.eccomerce.demo.Repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class productServices {

    private productRepository productRepository;

    @Autowired

    public productServices(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getProduct(Product product) {
        return productRepository.findAll().toString();

    }

    public void createNewProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImage_Url(productDto.getImage_Url());
        product.setCategory(category);
        productRepository.save(product);
    }

    public void updateProduct(ProductDto productDto, Integer product_id) {
        Optional<Product> optionalProduct = productRepository.findById(product_id);
        if (optionalProduct.isPresent()) {

            Product product = optionalProduct.get();
            product.setProductName(productDto.getProductName());
            product.setDescription(productDto.getDescription());
            product.setImage_Url(productDto.getImage_Url());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
        }


    }

        public void deleteProductByproductId(Integer product_id) {
            productRepository.deleteById(product_id);
        }
    }



