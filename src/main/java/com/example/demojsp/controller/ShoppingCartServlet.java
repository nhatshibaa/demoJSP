package com.example.demojsp.controller;

import com.example.demojsp.entity.cart.ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/user/shoppingcart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
