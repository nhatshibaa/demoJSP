<%@ page import="com.example.demojsp.entity.Customer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/16/2022
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> customerList = (List<Customer>) request.getAttribute("listCustomer");
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
<!-- ============================================================== -->
<!-- Main wrapper - style you can find in pages.scss -->
<!-- ============================================================== -->
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
                    <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">Data Customers</h4>
                    <div class="d-flex align-items-center">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb m-0 p-0">
                                <li class="breadcrumb-item"><a href="index.html" class="text-muted">Home</a></li>
                                <li class="breadcrumb-item text-muted active" aria-current="page">Customers</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- End Bread crumb and right sidebar toggle -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <!-- ============================================================== -->
            <!-- Start Page Content -->
            <!-- ============================================================== -->
            <!-- basic table -->
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Zero Configuration</h4>
                            <div class="table-responsive">
                                <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Phone</th>
                                        <th>Date Of Birth</th>
                                        <th>CreatedAt</th>
                                        <th>Status</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Customer cs : customerList) {
                                        %>
                                    <tr>
                                        <td>
                                            <%=cs.getId()%>
                                        </td>
                                        <td>
                                            <%=cs.getName()%>
                                        </td>
                                        <td>
                                            <%=cs.getPhone()%>
                                        </td>
                                        <td>
                                            <%=cs.getDob()%>
                                        </td>
                                        <td>
                                            <%=cs.getJoinedAt()%>
                                        </td>
                                        <td>
                                            <%=cs.getStatus()%>
                                        </td>
                                        <td>
                                            <a href="/admin/customers/detail?id=<%=cs.getId()%>"><i class="fa-solid fa-circle-info"></i></a>&nbsp;&nbsp;
                                            <a href="/admin/customers/edit?id=<%=cs.getId()%>"><i class="fa fa-pen-square"></i></a>&nbsp;&nbsp;
                                            <a href="/admin/customers/delete?id=<%=cs.getId()%>"
                                               onclick="confirm('Are you sure?')"><i class="fa-solid fa-circle-xmark"></i></a>
                                        </td>
                                    </tr>
                                        <%}
                                        %>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>
<jsp:include page="../layout/js-page.jsp"/>
</body>
</html>
