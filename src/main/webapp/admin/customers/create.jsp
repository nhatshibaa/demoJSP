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
    <jsp:include page="../layout/css-page.jsp"/>
</head>
<body>
<div class="preloader">
    <div class="lds-ripple">
        <div class="lds-pos"></div>
        <div class="lds-pos"></div>
    </div>
</div>
<div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
     data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
    <jsp:include page="../layout/header.jsp"/>
    <jsp:include page="../layout/sidebar.jsp"/>
    <div class="page-wrapper">
        <!-- ============================================================== -->
        <!-- Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <div class="page-breadcrumb">
            <div class="row">
                <div class="col-7 align-self-center">
                    <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">Customers</h4>
                    <div class="d-flex align-items-center">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb m-0 p-0">
                                <li class="breadcrumb-item"><a href="/home" class="text-muted">Home</a></li>
                                <li class="breadcrumb-item text-muted active" aria-current="page">Create Customer</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="card" style="margin-left: 171px; margin-right: 225px;">
                        <div class="card-body">
                            <h4 class="card-title">Form Create</h4>
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
                                    <div class="text-center">
                                        <input type="submit" class="btn btn-info" value="Save">
                                        <input type="reset" class="btn btn-warning" value="Reset">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../layout/footer.jsp"/>
</div>
<jsp:include page="../layout/js-page.jsp"/>
</body>
</html>
