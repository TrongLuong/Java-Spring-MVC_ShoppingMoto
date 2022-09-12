<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
		function ktSoLuong() {
			var sl = $("#getSL").val();
			if(sl == "") {
				alert("Số lượng không được rỗng");
				return false;
			}
			else if(sl < 0) {
				alert("Số lượng > 0");
				return false;
			}
			else if(sl > 10) {
				alert("Số lượng < 10");
				return false;
			}
			return true;
		}
 
		function submitThanhToan() {
			if(ktInputThanhToan()) {
				alert("Đơn hàng đã được gửi. Vui lòng kiểm tra email của bạn.");
				return true;
			}
			alert("Thông tin nhập chứa đủ hoặc không chính xác");
			return false;
		}
	</script>
 </head>
 <body>
      <div class="header">
          <div class="container">
            <div class="row">
              <!-- logo -->
              <div class="col-md-2 col-sm-2">
                <div class="logo">
                  <a href="/controller">
                    <img src="resources/images/logo-header.png" alt="logo">
                  </a>
                </div>
              </div>
    
              <div class="col-md-10 col-sm-10">
                <!-- header_top -->
                <div class="header_top">
                  <div class="row">
                    <div class="col-md-8">
                    </div>
                    <!-- login -->
                    <div class="col-md-4">
                      <ul class="usermenu">
                       
                          
                            <c:choose>                                	
									<c:when test="${userDN != null}">
									 <c:if test="${userDN.loaiTK !=0}">
									  <li> <a href="adminquanlysp"  > ADMIN VIEW</a></li>	
									 </c:if>
									
									 
										<li><a href="#" class="log">${userDN.hoTenKH }</a></li>	
										<li><a href="dangxuat" class="reg">Exit</a></li>					
									</c:when>
									 <c:otherwise>
										  <li><a href="dangnhap" class="log">Login</a><li>
										  <li><a href="dangky" class="reg">Register</a> </li>
	                            	</c:otherwise>
								</c:choose>
                        
                        
                      </ul>
                    </div>
                  </div>
                </div>
                <div class="clearfix"></div>
    
                <div class="header_bottom">
                  <!-- formsearch va gio hang-->
                  <ul class="option">
                    <li id="search" class="search">
    
                      <form action="timsanpham" method="GET"   >                               
                                <input  class="search" id="txtTim"  placeholder="Tên sản phẩm, nhà sản xuất..." type="text" value="" name="tensp_nsx">
                                <input class="search-submit"  type="submit" value="" >
                            </form>
                    </li>
                    <li class="option-cart">
                      <a href="xemgiohang" class="cart-icon">cart
                     		 <c:choose>
									<c:when test="${demItem != null}">
									 <span class="cart_no">${demItem}</span>									
									</c:when>
									<c:otherwise> <span class="cart_no">0</span></c:otherwise>
								</c:choose>                       
                      </a>
    
                    </li>
                  </ul>
                  <!-- menu -->
                  <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                      <li>
                        <a href="/controller">Home</a>
                      </li>
                      <li   >
                        <a href="xemay">Xe máy</a>
                      </li>
                      <li>
                        <a href="phukienxe">Phụ kiện xe</a>
                      </li>
                      <li>
                        <a href="#">Liên hệ</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
    <div class="clearfix">


  </div>

  </body>

 