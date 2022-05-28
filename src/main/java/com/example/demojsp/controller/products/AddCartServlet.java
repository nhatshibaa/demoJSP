package com.example.demojsp.controller.products;

import com.example.demojsp.entity.Product;
import com.example.demojsp.entity.cart.ShoppingCart;
import com.example.demojsp.model.IProduct;
import com.example.demojsp.model.MySQLProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartServlet extends HttpServlet {
    private IProduct iProduct;

    public AddCartServlet() {
        this.iProduct = new  MySQLProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =  req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
        if (shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        try {
            String productId = req.getParameter("productId");
            Integer quantity = Integer.parseInt(req.getParameter("quantity"));
            Product product = iProduct.findById(productId);
            if (product == null){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req, resp);
                return;
            }
            if (quantity <= 0){
                req.getRequestDispatcher("/user/error/404.jsp").forward(req, resp);
                return;
            }
            shoppingCart.add(product, quantity);
            session.setAttribute("cart", shoppingCart);
            resp.sendRedirect("/shopping-cart");
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher("/user/error/500.jsp").forward(req, resp);
        }
    }
}
