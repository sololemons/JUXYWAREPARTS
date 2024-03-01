package com.eccomerce.demo.Entity;

import jakarta.persistence.*;
@Entity
@Table(name = "ProductModel")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer product_id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "ImageUrl")
    private String Image_Url;
    @Column(name = "Price")
    private long Price;
@ManyToOne
@JoinColumn(name = "category_id")
Category category;


    public Product() {
    }

    public Product(Integer product_id, String productName, String description, String image_Url, long price) {
        this.product_id = product_id;
        this.productName = productName;
        this.description = description;
        Image_Url = image_Url;
        Price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_Url() {
        return Image_Url;
    }

    public void setImage_Url(String image_Url) {
        Image_Url = image_Url;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "product_id=" + product_id +
                ", productName=" + productName +
                ", description='" + description + '\'' +
                ", Image_Url='" + Image_Url + '\'' +
                ", Price=" + Price +
                '}';
    }



}
