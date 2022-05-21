<%@ page import="com.example.demojsp.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/16/2022
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<head>
    <title>Title</title>
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
                            </div>
                            <div>
                                Name: <%=customer.getName()%>
                            </div>
                            <div>
                                Phone: <%=customer.getPhone()%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/js-page.jsp"/>
</body>
</html>
