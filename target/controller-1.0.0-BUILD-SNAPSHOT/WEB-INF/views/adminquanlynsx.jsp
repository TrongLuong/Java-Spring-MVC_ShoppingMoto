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
				 
			</div>
			<div class="col-sm-6">
				<h2>Danh sách nhà sản xuất</h2>
			</div>
			<div class="col-sm-2">

				<a
					style="padding: 10px; background-color: rgb(139, 199, 127); border-radius: 5px; text-decoration: none;"
					href="adminthemnsx"> Thêm mới</a>
			</div>
		</div>
		<!-- TABLE DANH SÃCH -->
		 
		<div class="row">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>Mã NSX</th>
						<th>Tên NSX</th>
						<th>Xóa</th>
						<th>Cập nhật</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="items" items="${dsnsx}">
						<tr>
							<td>NSX-${items.maNSX }</td>
							<td>${items.tenNSX }</td>
							 
							<td><a style="text-decoration: none"
								href="adminxoansx/${items.maNSX }">Xóa</a></td>
								
								
							<td>
							<form action="admineditnsx" method="get">
								<input hidden="true" name="maNSX" value="${items.maNSX }">
								<button>Cập nhật</button>
							
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
							<td>
							
							
							
							
							
							</td>
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
	 
 
