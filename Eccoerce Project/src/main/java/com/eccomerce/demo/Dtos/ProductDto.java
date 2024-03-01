package com.eccomerce.demo.Dtos;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductDto")
public class ProductDto {


    @Column(name = "ProductName")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "ImageUrl")
    private String Image_Url;
    @Column(name = "Price")
    private Long price;

    private Integer category_id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;


    public ProductDto() {

    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", Image_Url='" + Image_Url + '\'' +
                ", price=" + price +
                ", category_id=" + category_id +
                ", id=" + product_id +
                '}';
    }
}
