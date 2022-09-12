<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="resources/images/favicon.png">
<title>Xe may</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<link href="resources/css/sequence-looptheme.css" rel="stylesheet"
	media="all" />
<link href="resources/css/style.css" rel="stylesheet">
 
</head>
<body>
	<div class="wrapper">
		<!-- gan heder -->
		<jsp:include page="_header.jsp"></jsp:include>
		<div class="clearfix"></div>
		<!-- body -->
		<div class="container_fullwidth">
			<div class="container">
				<div class="row">
					<!-- menu trai -->
					<jsp:include page="_menu_traiphai.jsp"></jsp:include>
					<!-- dssp -->
					<div class="col-md-9">
						<div class="banner">
							<div class="bannerslide" id="bannerslide">
								<ul class="slides">
									<li><a href="#"> <img src="resources/images/baner.png"
											alt="banner" />
									</a></li>

								</ul>
							</div>
						</div>
						<div class="clearfix"></div>
						<!-- dssp -->
						<div class="products-grid">
							<div class="clearfix"></div>

							<div class="row">
								<!-- tung o sp -->


								<!-- danh sach tat ca xe -->
								<c:forEach var="dsxe" items="${listSP }">
									<div class="col-md-4 col-sm-6">
										<div class="products">
											<div class="thumbnail">

												<a href="chitietsanpham?masp=${dsxe.maSp }"> <img
													src="resources/${dsxe.hinhAnhSp }" alt="Product Name">
												</a>
											</div>
											<div class="productname">${dsxe.tenSp }</div>
											<h4 class="price">${dsxe.giaSp } $USD</h4>
											<div class="productname">${dsxe.nsx.tenNSX }</div>
											
											<form action="themgiohang" method="post" onsubmit="return ktSoLuong()" >
												<div class="wided">
													<div  class="button_group">
														 <input type="hidden" name="cartMaSp" value="${dsxe.maSp}"> 
															<input type="hidden"
															name="cartGiaSp" value="${dsxe.giaSp}"> 
															<input required="true" value="1" type="number" name="cartSLSp" class="add-cart" style="padding: auto; width: 80px;">
															
													</div>
													<div class="button_group">
														<button class="button add-cart" type="submit">
															Thêm vào giỏ hàng</button>
													</div>
												</div>
											</form>
											 
										</div>
									</div>
								</c:forEach>




								<!-- danh sach tim theo nsx va loai xe -->
								<c:forEach var="dsxe" items="${timsptheonsx}">
									<div class="col-md-4 col-sm-6">
										<div class="products">
											<div class="thumbnail">

												<a href="chitietsanpham?masp=${dsxe.maSp }"> <img
													src="resources/${dsxe.hinhAnhSp }" alt="Product Name">
												</a>
											</div>
											<div class="productname">${dsxe.tenSp }</div>
											<h4 class="price">${dsxe.giaSp }$USD</h4>
											<div class="productname">${dsxe.nsx.tenNSX }</div>

											<div class="button_group">
												<a href="chitietsanpham?masp=${dsxe.maSp }">
													<button class="button add-cart" type="button">Xem
														Chi Tiết</button>
												</a>
											</div>



										</div>
									</div>
								</c:forEach>

								<!-- danh tim theo ten loai nsx -->
								<c:if test="${tuKhoatimxe !=null }">
									<div>

										Kết quả tìm kiếm:
										<h4>
											<i style="color: red">${tuKhoatimxe }</i>
										</h4>
									</div>


								</c:if>
								<hr>
								<!-- 
								<marquee direction="down" scrollamount="3">
									<h2 style="color: red">${erro404 }</h2>
								</marquee>
								 -->
								<h2 style="color: red">${erro404 }</h2>

								<c:forEach var="dsxe" items="${timxe}">
									<div class="col-md-4 col-sm-6">
										<div class="products">
											<div class="thumbnail">

												<a href="chitietsanpham?masp=${dsxe.maSp }"> <img
													src="resources/${dsxe.hinhAnhSp }" alt="Product Name">
												</a>
											</div>
											<div class="productname">${dsxe.tenSp }</div>
											<h4 class="price">${dsxe.giaSp }$USD</h4>
											<div class="productname">${dsxe.nsx.tenNSX }</div>

											<div class="button_group">
												<a href="chitietsanpham?masp=${dsxe.maSp }">
													<button class="button add-cart" type="button">Xem
														Chi Tiết</button>
												</a>
											</div>



										</div>
									</div>
								</c:forEach>



							</div>

						</div>
					</div>
				</div>


			</div>
		</div>
		<div class="clearfix"></div>
		<!-- gan footer -->
		<jsp:include page="_footer.jsp"></jsp:include>
	</div>
	<!-- Bootstrap core JavaScript==================================================-->
 
</body>
</html>