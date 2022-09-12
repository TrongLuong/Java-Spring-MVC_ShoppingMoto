<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="resources/images/favicon.png">
    <title>
      Chi tiet xe
    </title>
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="resources/css/flexslider.css" type="text/css"  rel="stylesheet" media="screen"/>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css">
	 
  </head>
  
  <body>
    <div class="wrapper">
    <jsp:include page="_header.jsp"></jsp:include>
    <!-- header -->
      <div class="container_fullwidth">
        <div class="container">
          <div class="row">
            <div class="col-md-9">
              <div class="products-details">
                <div class="preview_image">
                  <div class="preview-small">
                    <img id="zoom_03" src="resources/${ctxe.hinhAnhSp }" data-zoom-image="resources/${ctxe.hinhAnhSp }" alt=" ${ctxe.tenSp }">
                  </div>
                   
                </div>
                <!-- chitietsp -->
                <div class="products-description">
                  <h5 class="name">
                   Chi tiết sản phẩm
                  </h5>
                  
                  <p >
                Tên 
                    <span class=" light-red">
                    ${ctxe.tenSp }
                    </span>
                  </p>
                 
                    <p>
                      Nhà sản xuất
                        <span class=" light-red">
                          ${ctxe.nsx.tenNSX }
                        </span>
                      </p>
                      <p>
                        Loại 
                           <span class=" light-red">
                             ${ctxe.loaiSP }
                           </span>
                         </p>
                         <p>
                         Số lượng trong kho
                           <span class=" light-red">
                             ${ctxe.tongSLSp }
                           </span>
                         </p>
                          <p>
                       Ngày nhập
                           <span class=" light-red">
                             ${ctxe.ngayNhap }
                           </span>
                         </p>
                   
                  <hr class="border">
                  <div class="price">
                    Giá : 
                    <span class="new_price">
                     ${ctxe.giaSp}
                      <sup> $USD</sup>
                    </span>
                    
                  </div>
                  <hr class="border">
                  
                  
                  
                  
                 <!-- form nhap so luong xe mua -->
                  <form action="themgiohang" method="post" onsubmit="return ktSoLuong()">
                  <div class="wided">               
                    <div class="qty">
                     Số lượng
                      &nbsp;&nbsp;
                      		<input type="hidden" name="cartMaSp" value="${ctxe.maSp}">                      		 
							<input type="hidden" name="cartGiaSp" value="${ctxe.giaSp}">
                      		<input required="true" value="1" type="number" name ="cartSLSp" class="add-cart" style="padding: auto;width: 80px;"   >  
                    </div>
                    <div class="button_group">
                        <button class="button add-cart" type="submit">
                        Thêm vào giỏ hàng
                        </button>                                        
                      </div>
                  </div>
                  </form>
                  
                  
                  <div class="clearfix">
                  </div>
                  <hr class="border">
                  <img src="images/share.png" alt="" class="pull-right">
                </div>
              </div>
              <div class="clearfix">
              </div>
              <!-- mo ta -->
              <div class="tab-box">
                <div id="tabnav">
                  <ul>
                    <li style=" text-align: center">
                     <a href="/controller">
                          Tiếp tục mua hàng
                        </a>
                    
                    
                    </li>
                    <li style=" text-align: center">
                      <a href="">
                        Mô tả chi tiết
                      </a>
                      </li>
                     
                  </ul>
                </div>
                <div class="tab-content-wrap">
                  <div class="tab-content" id="Descraption">
                   <p>
                     ${ctxe.moTaSp }
                   </p>
                  
                  </div>
                  
                
                </div>
              </div>
              <div class="clearfix">
              </div>
             
              
            </div>
            <!-- menu trai -->
          <jsp:include page="_menu_traiphai.jsp"></jsp:include>
       
                
                <div class="clearfix">
                </div>
                <div class="leftbanner">
                  <img src="images/banner-small-01.png" alt="">
                </div>
              </div>
          </div>
          <div class="clearfix">
          </div>
          
        </div>
      </div>
      <div class="clearfix">
      </div>
       <jsp:include page="_footer.jsp"></jsp:include>
    </div>
  
     
  </body>
</html>