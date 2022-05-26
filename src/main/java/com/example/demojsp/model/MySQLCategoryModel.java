package com.example.demojsp.model;

import com.example.demojsp.entity.Category;
import com.example.demojsp.entity.Customer;
import com.example.demojsp.entity.enums.CategoryStatus;
import com.example.demojsp.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySQLCategoryModel implements ICategory{

    @Override
    public Category save(Category category) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into categories " +
                    "(name, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getCreatedAt().toString());
            preparedStatement.setString(3, category.getUpdatedAt().toString());
            preparedStatement.setInt(4, category.getStatus().getValue());
            System.out.println("Save category success!");
            preparedStatement.execute();
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id= resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Category category = new Category(id, name);
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                category.setStatus(CategoryStatus.of(status));
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category findById(Integer id) {
        Category category = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                category = new Category(id, name);
                category.setCreatedAt(createdAt);
                category.setUpdatedAt(updatedAt);
                category.setStatus(CategoryStatus.of(status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category update(Integer id, Category updateCategory) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update categories " +
                    "set name = ?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateCategory.getName());
            preparedStatement.setString(2, updateCategory.getCreatedAt().toString());
            preparedStatement.setString(3, updateCategory.getUpdatedAt().toString());
            preparedStatement.setInt(4, updateCategory.getStatus().getValue());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            System.out.println("Update category success!");
            return updateCategory;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update categories " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.DELETED.getValue());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            System.out.println("Delete category success!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
