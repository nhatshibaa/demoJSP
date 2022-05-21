package com.example.demojsp.controller.customers;

import com.example.demojsp.entity.Customer;
import com.example.demojsp.model.ICustomer;
import com.example.demojsp.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomerServlet extends HttpServlet {
    private ICustomer iCustomer;

    public DeleteCustomerServlet() {
        this.iCustomer = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lấy tham số rollNumber(id)
        String id = req.getParameter("id");
        // kiểm tra trong database xem có tồn tại không.
        Customer customer = iCustomer.findById(id);
        // nếu không trả về trang 404
        if (customer == null) {
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
        } else {
            boolean result = iCustomer.delete(id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/customers/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
            }
        }
    }
}
