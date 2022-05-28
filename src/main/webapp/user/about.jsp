<%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/26/2022
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About Us</title>
    <jsp:include page="layout/css-page.jsp"/>
</head>
<body>
<div class="body-wrapper">
    <jsp:include page="layout/header.jsp"/>
    <div class="breadcrumb-area">
        <div class="container">
            <div class="breadcrumb-content">
                <ul>
                    <li><a href="/home">Home</a></li>
                    <li class="active">About Us</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="about-us-wrapper pt-60 pb-40">
        <div class="container">
            <div class="row">
                <!-- About Text Start -->
                <div class="col-lg-6 order-last order-lg-first">
                    <div class="about-text-wrap">
                        <h2><span>Louis Vuiton</span>Premium Product</h2>
                        <p>Louis Vuitton is the world's most valuable luxury brand and is a division of LVMH. Its
                            products include leather goods, handbags, trunks, shoes, watches, jewelry and accessories.
                            Most of these are adorned with the LV monogram. It is one of the most profitable brands in
                            the world with profit margins north of 30%. Louis Vuitton launched its first perfume in 70
                            years during 2016, and LVMH built a state-of-the-art fragrance factory to develop the
                            perfumes. Actress Emma Stone was the star of Louis Vuitton’s first fragrance film. The brand
                            added men's fragrances last year. Maison Louis Vuitton launched a new Paris flagship store
                            in 2017, and the brand celebrates its 165th anniversary this year. Actresses Léa Seydoux and
                            Alicia Vikander continue to serve as brand ambassadors for Louis Vuitton.</p>
                    </div>
                </div>
                <!-- About Text End -->
                <!-- About Image Start -->
                <div class="col-lg-5 col-md-10">
                    <div class="about-image-wrap">
                        <img class="img-full" src="${pageContext.request.contextPath}/resource/user/images/lv1.jpg" alt="About Us" />
                    </div>
                </div>
                <!-- About Image End -->
            </div>
        </div>
    </div>
    <jsp:include page="layout/footer.jsp"/>
</div>
<jsp:include page="layout/js-page.jsp"/>
</body>
</html>
