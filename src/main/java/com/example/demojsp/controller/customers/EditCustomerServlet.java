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

public class EditCustomerServlet extends HttpServlet {
    private ICustomer iCustomer;

    public EditCustomerServlet() {
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
            // nếu có trả về trang detail
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/create.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // xử lý validate và save.
        String id= req.getParameter("id");
        Customer existCustomer = iCustomer.findById(id);
        if(existCustomer == null){
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
        }else{
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String image = req.getParameter("image");
            String stringBirthday = req.getParameter("dob");
            LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
            Customer customer = new Customer(id, name, phone, image, birthday);
            // validate dữ liệu
            if (iCustomer.update(id, customer) != null) {
                resp.sendRedirect("/admin/customers/list");
            } else {
                // nếu có trả về trang form
                req.setAttribute("customer", customer);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/customers/create.jsp").forward(req, resp);
            }
        }
    }
}
