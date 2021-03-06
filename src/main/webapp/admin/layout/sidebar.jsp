<%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/16/2022
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<aside class="left-sidebar" data-sidebarbg="skin6">
    <!-- Sidebar scroll-->
    <div class="scroll-sidebar" data-sidebarbg="skin6">
        <!-- Sidebar navigation-->
        <nav class="sidebar-nav">
            <ul id="sidebarnav">
                <li class="sidebar-item"><a class="sidebar-link sidebar-link" href="index.html"
                                            aria-expanded="false"><i data-feather="home" class="feather-icon"></i><span
                        class="hide-menu">Dashboard</span></a></li>
                <li class="list-divider"></li>
                <li class="nav-small-cap"><span class="hide-menu">Entity</span></li>
                <li class="sidebar-item"><a class="sidebar-link has-arrow" href="javascript:void(0)"
                                            aria-expanded="false"><i class="fa-solid fa-user"></i><span
                        class="hide-menu">Customers </span></a>
                    <ul aria-expanded="false" class="collapse  first-level base-level-line">
                        <li class="sidebar-item"><a href="/admin/customers/create" class="sidebar-link"><span
                                class="hide-menu"> Create
                                        </span></a>
                        </li>
                        <li class="sidebar-item"><a href="/admin/customers/list" class="sidebar-link"><span
                                class="hide-menu"> List
                                        </span></a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-item"><a class="sidebar-link has-arrow" href="javascript:void(0)"
                                            aria-expanded="false"><i class="fa-solid fa-boxes"></i><span
                        class="hide-menu">Products </span></a>
                    <ul aria-expanded="false" class="collapse  first-level base-level-line">
                        <li class="sidebar-item"><a href="/admin/products/create" class="sidebar-link"><span
                                class="hide-menu"> Create
                                        </span></a>
                        </li>
                        <li class="sidebar-item"><a href="/admin/products/list" class="sidebar-link"><span
                                class="hide-menu"> List
                                        </span></a>
                        </li>
                    </ul>
                </li>
                <li class="sidebar-item"><a class="sidebar-link has-arrow" href="javascript:void(0)"
                                            aria-expanded="false"><i class="fa-solid fa-clipboard-list"></i><span
                        class="hide-menu">Categories </span></a>
                    <ul aria-expanded="false" class="collapse  first-level base-level-line">
                        <li class="sidebar-item"><a href="/admin/categories/create" class="sidebar-link"><span
                                class="hide-menu"> Create
                                        </span></a>
                        </li>
                        <li class="sidebar-item"><a href="/admin/categories/list" class="sidebar-link"><span
                                class="hide-menu"> List
                                        </span></a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- End Sidebar navigation -->
    </div>
    <!-- End Sidebar scroll-->
</aside>
</body>
</html>
