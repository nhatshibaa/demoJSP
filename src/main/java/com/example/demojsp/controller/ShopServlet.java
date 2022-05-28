package com.example.demojsp.controller;

import com.example.demojsp.entity.Category;
import com.example.demojsp.entity.Product;
import com.example.demojsp.model.ICategory;
import com.example.demojsp.model.IProduct;
import com.example.demojsp.model.MySQLCategoryModel;
import com.example.demojsp.model.MySQLProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShopServlet extends HttpServlet {

    private IProduct iProduct;

    private ICategory iCategory;

    public ShopServlet() {
        this.iProduct = new  MySQLProductModel();
        this.iCategory = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = iProduct.findAll();
        List<Category> categories = iCategory.findAll();
        req.setAttribute("products", products);
        req.setAttribute("category", categories);
        req.getRequestDispatcher("/user/shop.jsp").forward(req, resp);
    }
}
