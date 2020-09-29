<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<b>Gio Hang</b>
<table class="table">
	<thead class="thead-light">
		<tr>
			<th scope="col">id</th>
			<th scope="col">Sản Phẩm</th>
			<th scope="col">Giá</th>
			<th scope="col">Số Lượng</th>
			<th scope="col">Thành Tiền</th>
			<th scope="col">tool</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${oder.list}" var="item">
			<tr>
				<td scope="row">${item.productDTO.id}</td>
				<td>
				<img src="${item.productDTO.img}" class="img img-rounded" alt="${item.productDTO.name}" width="100" height="100">
				${item.productDTO.name}
				</td>
				<td>${item.productDTO.cost} VND</td>
				<td>x ${item.number} </td>
				<td><b style="color: red;">${item.productDTO.cost * item.number} VND</b></td>
				
				<th scope="col">
				<a class="btn btn-sm btn-success" href="<c:url value='./add-to-cart/${item.productDTO.id}'/>">Thêm</a> 
				<a class="btn btn-sm btn-danger" href="<c:url value='./remove-product/${item.productDTO.id}'/>"
					title="Xoa san pham khoi gio hang ${item.productDTO.id}">Xoa</a> 
				<a class="btn btn-sm btn-info" href="">update</a></th>
			</tr>
		</c:forEach>
	</tbody>
</table>
