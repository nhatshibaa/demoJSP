package com.example.demojsp.model;

import com.example.demojsp.entity.Category;
import com.example.demojsp.entity.Customer;
import com.example.demojsp.entity.Product;
import com.example.demojsp.entity.enums.CategoryStatus;
import com.example.demojsp.entity.enums.ProductStatus;
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
                    "(id, categoryId, name, price, thumbnails, description, detail, createdAt, updatedAt) " +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getId());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setString(3, product.getName());
            preparedStatement.setBigDecimal(4, product.getPrice());
            preparedStatement.setString(5, product.getThumbnails());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setString(7, product.getDetail());
            preparedStatement.setString(8, product.getCreatedAt().toString());
            preparedStatement.setString(9, product.getUpdatedAt().toString());
//            preparedStatement.setInt(10, product.getStatus().getValue());
            preparedStatement.execute();
            System.out.println("Create product success!");
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
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id= resultSet.getString("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String thumbnail = resultSet.getString("thumbnails");
                String description = resultSet.getString("description");
                String detail = resultSet.getString("detail");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                Product product = new Product(id, name, price, thumbnail, description, detail);
                product.setCreatedAt(createdAt);
                product.setUpdatedAt(updatedAt);
                product.setStatus(ProductStatus.of(status));
                list.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findById(String id) {
        Product product = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, ProductStatus.ACTIVE.getValue());
            preparedStatement.setString(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String thumbnail = resultSet.getString("thumbnails");
                String description = resultSet.getString("description");
                String detail = resultSet.getString("detail");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int status = resultSet.getInt("status");
                product = new Product(id, name, price, thumbnail, description, detail);
                product.setCreatedAt(createdAt);
                product.setUpdatedAt(updatedAt);
                product.setStatus(ProductStatus.of(status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product update(String id, Product updateProduct) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products " +
                    "set categoryId = ?, name = ?, price = ?, thumbnails = ?, description= ?, detail =?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateProduct.getCategoryId());
            preparedStatement.setString(2, updateProduct.getName());
            preparedStatement.setBigDecimal(3, updateProduct.getPrice());
            preparedStatement.setString(4, updateProduct.getThumbnails());
            preparedStatement.setString(5, updateProduct.getDescription());
            preparedStatement.setString(6, updateProduct.getDetail());
            preparedStatement.setString(7, updateProduct.getCreatedAt().toString());
            preparedStatement.setString(8, updateProduct.getUpdatedAt().toString());
            preparedStatement.setInt(9, updateProduct.getStatus().getValue());
            preparedStatement.setString(10, id);
            System.out.println("Update success!");
            preparedStatement.execute();
            return updateProduct;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String id) {try {
        Connection connection = ConnectionHelper.getConnection();
        String sqlQuery = "update products " +
                "set status = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, ProductStatus.DELETED.getValue());
        preparedStatement.setString(2, id);
        System.out.println("Delete success!");
        preparedStatement.execute();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return false;
    }
}
