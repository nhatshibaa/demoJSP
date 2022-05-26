<%@ page import="com.example.demojsp.entity.Account" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/26/2022
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account account = (Account) request.getAttribute("account");
    if(account == null){
        account = new Account();
    }
%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="layout/css-page.jsp"/>
</head>
<body>
<div class="body-wrapper">
    <jsp:include page="layout/header.jsp"/>
    <div class="breadcrumb-area">
        <div class="container">
            <div class="breadcrumb-content">
                <ul>
                    <li><a href="index.html">Home</a></li>
                    <li class="active">Register</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Li's Breadcrumb Area End Here -->
    <!-- Begin Login Content Area -->
    <div class="page-section mb-60">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-lg-6 col-xs-12" style="margin-left: 320px">
                    <form action="/register" method="post">
                        <div class="login-form">
                            <h4 class="login-title">Register</h4>
                            <div class="row">
                                <div class="col-md-6 col-12 mb-20">
                                    <label>Username</label>
                                    <input class="mb-0" type="text" name="username" value="<%=account.getUsername()%>">
                                </div>
                                <div class="col-md-6 col-12 mb-20">
                                    <label>Phone</label>
                                    <input class="mb-0" type="text" name="phone" value="<%=account.getPhone()%>">
                                </div>
                                <div class="col-md-12 mb-20">
                                    <label>Email</label>
                                    <input class="mb-0" type="email" name="email" value="<%=account.getEmail()%>">
                                </div>
                                <div class="col-md-6 mb-20">
                                    <label>Password</label>
                                    <input class="mb-0" type="password" name="password" placeholder="Password">
                                </div>
                                <div class="col-md-6 mb-20">
                                    <label>Confirm Password</label>
                                    <input class="mb-0" type="password" name="confirmPassword" placeholder="Confirm Password">
                                </div>
                                <div class="row">
                                    <div class="col-12">
                                        <button type="submit" class="btn btn-info mt-0">Submit</button>
                                        <button type="reset" class="btn btn-warning mt-0">Reset</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="layout/js-page.jsp"/>
</body>
</html>
