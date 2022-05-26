<%@ page import="com.example.demojsp.entity.Customer" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.demojsp.entity.Product" %>
<%@ page import="com.example.demojsp.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/16/2022
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    List<Category> categories = (List<Category>) request.getAttribute("category");
    if (categories == null) {
        categories = new ArrayList<>();
    }
    int action = (int) request.getAttribute("action");
    String url = "/admin/products/create";
    if (action == 2) {
        url = "/admin/products/edit";
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
    <script src="https://cdn.ckeditor.com/4.19.0/standard/ckeditor.js"></script>
    <script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>
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
                    <h4 class="page-title text-truncate text-dark font-weight-medium mb-1">Products</h4>
                    <div class="d-flex align-items-center">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb m-0 p-0">
                                <li class="breadcrumb-item"><a href="/home" class="text-muted">Home</a></li>
                                <li class="breadcrumb-item text-muted active" aria-current="page">Create Product</li>
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
                            <a href="/admin/products/list/list">Back to list</a>
                            <div class="basic-form">
                                <form action="<%=url%>" method="post">
                                    <div class="row">
                                        <div class="form-group col-6">
                                            <strong><label>ID</label></strong>
                                            <input type="text" name="id" class="form-control input-rounded"
                                                   placeholder="ID"
                                                   value="<%=product.getId()%>" <%=action == 2 ? "readonly":""%>>
                                        </div>
                                        <div class="form-group col-6">
                                            <strong><label>Name</label></strong>
                                            <input type="text" name="name" class="form-control"
                                                   placeholder="Name" value="<%=product.getName()%>">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-6">
                                            <strong><label>Price</label></strong>
                                            <input type="text" name="price" class="form-control"
                                                   placeholder="Price" value="<%=product.getPrice()%>">
                                        </div>
                                        <div class="form-group col-6">
                                            <strong><label>Category</label></strong>
                                            <select name="categoryId" class="form-control">
                                                <option value="">Vui lòng chọn danh mục</option>
                                                <%
                                                    for (int i = 0; i < categories.size(); i++) {
                                                %>
                                                <option value="<%=categories.get(i).getId()%>"><%=categories.get(i).getName()%>
                                                </option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <strong><label>Thumbnail</label></strong>
                                        <input type="hidden" class="form-control" id="hello" name="thumbnail">
                                        <button type="button" id="upload_widgetn" class="btn btn-sm btn-primary">Chọn
                                            ảnh
                                        </button>
                                        <img id="preview-image" style="display: none" src="" alt="" class="img-bordered mt-2" width="200px">
                                        <%--                                            <input type="text" name="thumbnail" class="form-control input-rounded"--%>
                                        <%--                                                   placeholder="Thumbnail" value="<%=product.getThumbnails()%>">--%>
                                    </div>
                                    <div class="form-group">
                                        <strong><label>Description</label></strong>
                                        <input type="text" name="description" class="form-control input-rounded"
                                               placeholder="Description" value="<%=product.getDescription()%>">
                                    </div>
                                    <div class="form-group">
                                        <strong><label>Detail</label></strong>
                                        <textarea name="detail" id="editor1"
                                                  value="<%=product.getDetail()%>"></textarea>
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
<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'dcmr49l2j',
            uploadPreset: 'gqjyapbf'
        }, (error, result) => {
            if (!error && result && result.event === "success") {
                var inputThumbnail = document.getElementById('hello');
                var previewdiv = document.getElementById('preview-div');
                if (inputThumbnail) {
                    var currentImagevalue = inputThumbnail.value;
                    if (currentImagevalue.length > 0) {
                        currentImagevalue += ','
                    }
                    currentImagevalue += result.info.secure_url;
                    inputThumbnail.value = currentImagevalue;

                    previewdiv.innerHTML += `<img src="${result.info.secure_url}" width="150xp">`;
                    previewdiv.classList.remove('hidden');


                }
            }
        }
    )
    document.getElementById("upload_widgetn").addEventListener("click", function () {
        myWidget.open();
    }, false);
</script>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        $('#reservationdate').datetimepicker({
            format: 'YYYY-MM-DD'
        });
    })
</script>
<script>
    CKEDITOR.replace('editor1');
</script>
</body>
</html>
