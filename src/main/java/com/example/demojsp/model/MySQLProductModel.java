package com.example.demojsp.model;

import com.example.demojsp.entity.Customer;
import com.example.demojsp.entity.Product;
import com.example.demojsp.util.ConnectionHelper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductModel implements IProduct{

    @Override
    public Product save(Product product) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into products " +
                    "(id, name, price, thumbnails, description, createdAt, updatedAt, status) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setString(4, product.getThumbnails());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getCreatedAt().toString());
            preparedStatement.setString(7, product.getUpdatedAt().toString());
            preparedStatement.setInt(8, product.getStatus());
            System.out.println("Create success!");
            preparedStatement.execute();
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from products where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, 1);
            System.out.println("Connection success!");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id= resultSet.getString("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String thumbnail = resultSet.getString("thumbnail");
                String description = resultSet.getString("description");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Product product = new Product(id, name, price, thumbnail, description, createdAt, updatedAt, status);
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public Product update(String id, Product updateProduct) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
