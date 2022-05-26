package com.example.demojsp.controller.products;

import com.example.demojsp.entity.Customer;
import com.example.demojsp.entity.Product;
import com.example.demojsp.model.ICustomer;
import com.example.demojsp.model.IProduct;
import com.example.demojsp.model.MySQLProductModel;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {

    private IProduct iProduct;

    public ListProductServlet() {
        this.iProduct = new MySQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = iProduct.findAll();
        req.setAttribute("listProduct", list);
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);
    }
}
