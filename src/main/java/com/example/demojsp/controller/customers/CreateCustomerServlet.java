package com.example.demojsp.controller.customers;

import com.example.demojsp.entity.Customer;
import com.example.demojsp.model.ICustomer;
import com.example.demojsp.model.MySqlCustomerModel;
import com.example.demojsp.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class CreateCustomerServlet extends HttpServlet {
    private ICustomer iCustomer;

    public CreateCustomerServlet() {
        this.iCustomer = new  MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String image = req.getParameter("image");
        String stringBirthday = req.getParameter("dob");
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(id, name, phone, image, birthday);
        //validate
        if (iCustomer.save(customer) != null) {
            resp.sendRedirect("/admin/customers/list");
        } else {
            req.getRequestDispatcher("/admin/customers/create.jsp").forward(req, resp);
        }
    }
}
