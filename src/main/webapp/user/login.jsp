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
    <title>Login</title>
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
                    <li class="active">Login</li>
                </ul>
            </div>
        </div>
    </div>
    <!-- Li's Breadcrumb Area End Here -->
    <!-- Begin Login Content Area -->
    <div class="page-section mb-60">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-md-12 col-xs-12 col-lg-6 mb-30" style="margin-left: 320px">
                    <!-- Login Form s-->
                    <form action="/login" method="post">
                        <div class="login-form">
                            <h4 class="login-title">Login</h4>
                            <div class="row">
                                <div class="col-md-12 col-12 mb-20">
                                    <label>Username</label>
                                    <input class="mb-0" type="text" name="username">
                                </div>
                                <div class="col-12 mb-20">
                                    <label>Password</label>
                                    <input class="mb-0" type="password" name="password" placeholder="Password">
                                </div>
                                <div class="col-md-8">
                                    <div class="check-box d-inline-block ml-0 ml-md-2 mt-10">
                                        <input type="checkbox" id="remember_me">
                                        <label for="remember_me">Remember me</label>
                                    </div>
                                </div>
                                <div class="col-md-4 mt-10 mb-20 text-left text-md-right">
                                    <a href="#"> Forgotten password?</a>
                                </div>
                                <div class="col-md-3" style="margin-left: 150px">
                                    <form action="" method="post">
                                        <button class="btn btn-primary mt-0">Login</button>
                                    </form>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-secondary"><a href="/register">Register</a></button>
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
