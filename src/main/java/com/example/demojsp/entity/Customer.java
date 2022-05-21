package com.example.demojsp.entity;

import com.example.demojsp.util.DateTimeHelper;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private String id;
    private String name;
    private String phone;
    private String image;
    private LocalDateTime dob;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer status;



    public Customer(String name, String phone, String image, LocalDateTime dob) {
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(String id, String name, String phone, String image, LocalDateTime dob) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.dob = dob;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }
    public Customer() {
        this.id = "";
        this.name = "";
        this.phone = "";
        this.image = "";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(String id, String name, String phone, String image) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = 1;
    }

    public Customer(String id, String name, String phone, String image, LocalDateTime dob, LocalDateTime createdAt, LocalDateTime updatedAt, Integer status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.dob = dob;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", dob=" + dob +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", status=" + status +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDob() {
        return dob;
    }
    public String getDobString() {
        if(this.dob != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.dob);
        }
        return "";
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getJoinedAt() {
        if(this.createdAt != null){
            return DateTimeHelper.convertLocalDateTimeToString(this.createdAt);
        }
        return "";
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
