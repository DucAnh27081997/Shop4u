<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
img {
	margin: 10px;
}
.item:hover {
    background-color: #c2e2f9 !important;
}
</style>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<div class="row">
	<a class="btn btn-danger right" href="/cart/add-to-cart/${item.id}">CART <span class="badge">5</span></a>
</div>
<div class="row">
	<c:forEach items="${listProduc}" var="item">
		<div class="col-sm-3 item" style="text-align: center;">
			<h3>${item.name}</h3>
			<img src="${item.img}" class="img img-rounded" alt="Cinque Terre"
				width="200" height="200">
				<br>
			<b>Giá:${item.cost} VND <a class="btn btn-sm btn-success" href="../cart/add-to-cart/${item.id}"><i class='fas fa-cart-plus'></i></a></b>
		
		</div>
	</c:forEach>
</div>