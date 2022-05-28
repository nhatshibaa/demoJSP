package com.example.demojsp.entity;

import com.example.demojsp.entity.base.BaseEntity;
import com.example.demojsp.entity.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Product extends BaseEntity {
    private String id;
    private Integer CategoryId;
    private String name;
    private BigDecimal price;
    private String thumbnails;
    private String description;
    private String detail;
    private ProductStatus status;

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid(){
        checkValidate();
        return errors.size() == 0;
    }

    private void checkValidate() {
        // validate dữ liệu theo kiểu cùi bắp.
        if (id == null || id.length() == 0) {
            errors.put("id", "Please enter ID!");
        }
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name!");
        }
        if (CategoryId == 0) {
            errors.put("cateId", "Please choose category id!");
        }
        if (thumbnails == null || thumbnails.length() == 0) {
            errors.put("thumbnail", "Please choose thumbnail!");
        }
        if (description == null || description.length() == 0) {
            errors.put("description", "Please enter description!");
        }
        if (detail == null || detail.length() == 0) {
            errors.put("detail", "Please enter detail!");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public Product() {
        this.id = "";
        this.name = "";
        this.price = BigDecimal.valueOf(0);
        this.thumbnails = "";
        this.description = "";
        this.detail = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    public Product(String id, String name, BigDecimal price, String thumbnails, String description, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnails = thumbnails;
        this.description = description;
        this.detail = detail;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = ProductStatus.ACTIVE;
    }

    public Product(String id, String name, BigDecimal price, String thumbnails, String description, String detail, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnails = thumbnails;
        this.description = description;
        this.detail = detail;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = status;
    }

    public Product(String id, String name, BigDecimal price, String thumbnails, String description, String detail, Integer categoryId, ProductStatus status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnails = thumbnails;
        this.description = description;
        this.detail = detail;
        CategoryId = categoryId;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = status;
    }

    public Product(String id, String name, String thumbnails, String description, String detail) {
        this.id = id;
        this.name = name;
        this.thumbnails = thumbnails;
        this.description = description;
        this.detail = detail;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public Product(String id, Integer categoryId, String name, BigDecimal price, String thumbnails, String description, String detail) {
        this.id = id;
        CategoryId = categoryId;
        this.name = name;
        this.price = price;
        this.thumbnails = thumbnails;
        this.description = description;
        this.detail = detail;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
