package com.example.demojsp.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {
    private String id;
    private String name;
    private BigDecimal price;
    private String thumbnails;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int status;

    public Product() {
    }

    public Product(String id, String name, BigDecimal price, String thumbnails, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnails = thumbnails;
        this.description = description;
    }

    public Product(String id, String name, BigDecimal price, String thumbnails, String description, LocalDateTime createdAt, LocalDateTime updatedAt, int status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.thumbnails = thumbnails;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
