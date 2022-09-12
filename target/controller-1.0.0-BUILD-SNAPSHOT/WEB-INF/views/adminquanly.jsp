<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 
		<!DOCTYPE html>
		<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="resources/images/favicon.png">

<title>Admin quan ly</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="_adminmenu.jsp"></jsp:include>

	<!-- trang quan ly -->
	<div class="col-sm-10">
		<div class="row">
			<div class="col-sm-4">
				<form class="form-inline" action="admintimsp" method="GET">
					<input name="tensp" class="form-control mr-sm-2" type="text" placeholder="Tên sản phẩm..."> 
						<input style="background-color: gray" class="btn btn-success" value="Search" type="submit" />
					<p style="color: red">${erro404 }</p>
				</form>
			</div>
			<div class="col-sm-6">
				<h2>Danh sách sản phẩm</h2>
			</div>
			<div class="col-sm-2">

				<a
					style="padding: 10px; background-color: rgb(139, 199, 127); border-radius: 5px; text-decoration: none;"
					href="adminthemsp"> Thêm mới</a>
			</div>
		</div>
		<!-- TABLE DANH SÃCH -->
		 
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Mã SP</th>
						<th>Tên SP</th>
						<th>Giá SP</th>
						<th>Số lượng</th>
						<th>Ngày nhập</th>
						<th>Loại</th>
						<th>Nhà sản xuất</th>
						<th>Mô tả</th>
						<th>Hình ảnh</th>
						<th>Xóa</th>
						<th>Cập nhật</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="items" items="${dssp}">
						<tr>
							<td>${items.maSp }</td>
							<td>${items.tenSp }</td>
							<td>${items.giaSp }</td>
							<td>${items.tongSLSp }</td>
							<td>${items.ngayNhap }</td>
							<td>${items.loaiSP }</td>
							<td>${items.nsx.tenNSX }</td>
							<td>${items.moTaSp }</td>
							<td><img style="width: 100px; height: auto;"
								src="resources/${items.hinhAnhSp }"></td>
							<td><a style="text-decoration: none"
								href="adminxoasp/${items.maSp }">Xóa</a></td>
							<td>
							<form action="admineditsp" method="get">
							<input hidden="true" name="maSP" value="${items.maSp }">
							<button>
							Cập nhật
							</button>
							</form>
							 </td>
						</tr>
					</c:forEach>
					<!-- admin tim xe -->

					<c:forEach var="items" items="${admintimsp}">
						<tr>
							<td>${items.maSp }</td>
							<td>${items.tenSp }</td>
							<td>${items.giaSp }</td>
							<td>${items.tongSLSp }</td>
							<td>${items.ngayNhap }</td>
							<td>${items.loaiSP }</td>
							<td>${items.nsx.tenNSX }</td>
							<td>${items.moTaSp }</td>
							<td><img style="width: 100px; height: auto;"
								src="resources/${items.hinhAnhSp }"></td>
							<td><a style="text-decoration: none"
								href="adminxoasp/${items.maSp }">Xóa</a></td>
							<td><a style="text-decoration: none"
								href="adminedt/${items.maSp }">Cập nhật</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		 
		
		
		<!-- formxe -->
	</div>
	</div>
	</div>

</body>
</html>
	 
 
