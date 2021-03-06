<%@ page import="com.example.demojsp.entity.cart.ShoppingCart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demojsp.entity.cart.CartItem" %><%--
  Created by IntelliJ IDEA.
  User: kaotu
  Date: 5/26/2022
  Time: 8:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
    if (shoppingCart == null){
        shoppingCart = new ShoppingCart();
    }
%>
<html>
<head>
    <title>Shopping Cart</title>
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
                    <li class="active">Shopping Cart</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="Shopping-cart-area pt-60 pb-60">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <form action="#">
                        <div class="table-content table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th class="li-product-remove">remove</th>
                                    <th class="li-product-thumbnail">Image</th>
                                    <th class="cart-product-name">Product</th>
                                    <th class="li-product-price">Unit Price</th>
                                    <th class="li-product-quantity">Quantity</th>
                                    <th class="li-product-subtotal">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <% List<CartItem> items = shoppingCart.getListItems();
                                    for (int i = 0; i < items.size(); i++) { %>
                                <tr>
                                    <td class="li-product-remove"><a href="#"><i class="fa fa-times"></i></a></td>
                                    <td class="li-product-thumbnail"><img src="<%=items.get(i).getProductThumbnail()%>"></td>
                                    <td class="li-product-name"><%=items.get(i).getProductName()%></td>
                                    <td class="li-product-price"><span class="amount"><%=items.get(i).getUnitPrice()%></span></td>
                                    <td class="quantity">
                                        <label>Quantity</label>
                                        <div class="cart-plus-minus">
                                            <input class="cart-plus-minus-box" value="<%=items.get(i).getQuantity()%>" type="text">
                                            <div class="dec qtybutton"><i class="fa fa-angle-down"></i></div>
                                            <div class="inc qtybutton"><i class="fa fa-angle-up"></i></div>
                                        </div>
                                    </td>
                                    <td class="product-subtotal"><span class="amount"><%=items.get(i).getUnitPrice()%></span></td>
                                </tr>
                                <%}%>                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="coupon-all">
                                    <div class="coupon">
                                        <input id="coupon_code" class="input-text" name="coupon_code" value="" placeholder="Coupon code" type="text">
                                        <input class="button" name="apply_coupon" value="Apply coupon" type="submit">
                                    </div>
                                    <div class="coupon2">
                                        <input class="button" name="update_cart" value="Update cart" type="submit">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 ml-auto">
                                <div class="cart-page-total">
                                    <h2>Cart totals</h2>
                                    <ul>
                                        <li>Subtotal <span>$130.00</span></li>
                                        <li>Total <span>$130.00</span></li>
                                    </ul>
                                    <a href="#">Proceed to checkout</a>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="layout/footer.jsp"/>
</div>
<jsp:include page="layout/js-page.jsp"/>
</body>
</html>
