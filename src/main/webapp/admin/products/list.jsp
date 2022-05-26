<%@ page import="com.example.demojsp.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/24/2022
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> productList = (List<Product>) request.getAttribute("listProduct");
    if (productList == null){
        productList = new ArrayList<>();
    }
%>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../layout/css-page.jsp"/>
    <link href="${pageContext.request.contextPath}/resource/assets/extra-libs/datatables.net-bs4/css/dataTables.bootstrap4.css"
          rel="stylesheet">
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
                            <div class="table-responsive">
                                <table id="zero_config" class="table table-striped table-bordered no-wrap">
                                    <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
<%--                                        <th>Category</th>--%>
                                        <th>Price</th>
                                        <th>Thumbnail</th>
                                        <th>CreatedAt</th>
                                        <th>Status</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <%for (Product prd : productList) {
                                        %>
                                    <tr>
                                        <td>
                                            <%=prd.getId()%>
                                        </td>
                                        <td>
                                            <%=prd.getName()%>
                                        </td>
<%--                                        <td>--%>
<%--                                            <%=prd.getCategoryId().toString()%>--%>
<%--                                        </td>--%>
                                        <td>
                                            <%=prd.getPrice()%>
                                        </td>
                                        <td>
                                            <img src="<%=prd.getThumbnails()%>" class="img-thumbnail" style="width: 75px;">
                                        </td>
                                        <td>
                                            <%=prd.getCreatedAt()%>
                                        </td>
                                        <td>
                                            <%=prd.getStatus()%>
                                        </td>
                                        <td>
                                            <div style="margin-left: 40px">
                                                <a href="/admin/products/detail?id=<%=prd.getId()%>"><i
                                                        class="fa-solid fa-circle-info" style="margin-right: 7px"></i></a>
                                                <a href="/admin/products/edit?id=<%=prd.getId()%>"><i
                                                        class="fa fa-pen-square"></i></a>&nbsp;&nbsp;
                                                <a href="/admin/products/delete?id=<%=prd.getId()%>"
                                                   onclick="confirm('Are you sure?')"><i
                                                        class="fa-solid fa-circle-xmark"></i></a>
                                            </div>
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
<script src="${pageContext.request.contextPath}/resource/assets/extra-libs/sparkline/sparkline.js"></script>
<script src="${pageContext.request.contextPath}/resource/dist/js/sidebarmenu.js"></script>
<!--Custom JavaScript -->
<script src="${pageContext.request.contextPath}/resource/dist/js/custom.min.js"></script>
<!--This page plugins -->
<script src="${pageContext.request.contextPath}/resource/assets/extra-libs/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resource/dist/js/pages/datatable/datatable-basic.init.js"></script>
</body>
</html>
