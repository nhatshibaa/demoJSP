package com.example.demojsp.controller.products;

import com.example.demojsp.entity.Category;
import com.example.demojsp.entity.Customer;
import com.example.demojsp.entity.Product;
import com.example.demojsp.model.*;
import com.example.demojsp.util.DateTimeHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateProductServlet extends HttpServlet {
    private IProduct iProduct;
    private ICategory iCategory;

    public CreateProductServlet() {
        this.iProduct = new MySQLProductModel();
        this.iCategory = new MySQLCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("category", iCategory.findAll());
        req.setAttribute("product", new Product());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id = req.getParameter("id");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");
        BigDecimal price =  BigDecimal.valueOf(Long.parseLong(req.getParameter("price")));
        String thumbnails = req.getParameter("thumbnail");
        String description = req.getParameter("description");
        String detail = req.getParameter("detail");
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCategoryId(categoryId);
        product.setThumbnails(thumbnails);
        product.setDescription(description);
        product.setDetail(detail);
        product.setPrice(price);
        //validate
        if (!product.isValid()) {
            req.setAttribute("category", iCategory.findAll());
            req.setAttribute("product", product);
            req.setAttribute("action", 1);
            req.setAttribute("errors", product.getErrors());
            req.getRequestDispatcher("/admin/products/create.jsp").forward(req, resp);
            return;
        }
        if (iProduct.save(product) != null) {
            resp.sendRedirect("/admin/products/list");
        } else {
            req.getRequestDispatcher("/admin/products/create.jsp").forward(req, resp);
        }
    }
}
