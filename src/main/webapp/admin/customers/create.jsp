<%@ page import="com.example.demojsp.entity.Customer" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/16/2022
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
    int action = (int) request.getAttribute("action");
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    String url = "/admin/customers/create";
    if (action == 2) {
        url = "/admin/customers/edit";
    }
    if (errors == null) {
        errors = new HashMap<>();
    }
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
<%--    <jsp:include page="../layout/css-page.jsp"/>--%>
</head>
<body>
<h4 class="card-title">Input Style</h4>
<a href="/admin/customers/list">Back to list</a>
<div class="basic-form">
    <form action="<%=url%>" method="post">
        <div class="form-group">
            <input type="text" name="name" class="form-control input-rounded"
                   placeholder="Name" value="<%=customer.getName()%>">
        </div>
        <div class="form-group">
            <input type="text" name="phone" class="form-control input-rounded"
                   placeholder="Phone" value="<%=customer.getPhone()%>">
        </div>
        <div class="form-group">
            <input type="text" name="image" class="form-control input-rounded"
                   placeholder="Image" value="<%=customer.getImage()%>">
        </div>
        <div class="form-group">
            <input type="date" name="birthday"
                   class="complex-colorpicker form-control input-rounded"
                   placeholder="Birthday" value="<%=customer.getDob()%>">
        </div>
        <div>
            <input type="submit" value="Save">
            <input type="reset"  value="Reset">
        </div>
    </form>
</div>
</body>
</html>
