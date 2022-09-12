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

<title>Admin quan ly hoa don</title>
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
				 
			</div>
			<div class="col-sm-6">
				<h2>Danh sách chi tiết hóa đơn</h2>
			</div>
			<div class="col-sm-2">
 
			</div>
		</div>
		<!-- TABLE  -->
		 
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Mã CTHD</th>
						<th>Mã SP</th>
						<th>Tên SP</th>
						<th>Đơn giá SP</th>
						<th>Số lượng mua</th>
						<th>Tổng tiền</th>						 
					

					</tr>
				</thead>
				<tbody>
					<c:forEach var="items" items="${listCTHD}">
						<tr>
							<td>${items.maCTHD }</td>
							<td>${items.sp.maSp }</td>
							<td>${items.sp.tenSp }</td>
							<td>${items.sp.giaSp }</td>
							<td>${items.slMua }</td>
						 	<td>${items.tongTien }</td>
							 
					</c:forEach>
					<!-- admin tim xe -->

					 
				</tbody>
			</table>
		</div>
		 
		
		
		<!-- formxe -->
	</div>
	</div>
	</div>

</body>
</html>
	 
 
