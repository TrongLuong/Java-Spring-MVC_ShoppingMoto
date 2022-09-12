<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
      <meta name="description" content="">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="shortcut icon" href="resources/images/favicon.png">
      <title>Gio hang</title>
      <link href="resources/css/bootstrap.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
      <link href="resources/css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
      <link href="resources/css/sequence-looptheme.css" rel="stylesheet" media="all"/>
      <link href="resources/css/style.css" rel="stylesheet">
    


</head>
  <body>
  <div class="wrapper">
    <!-- gan heder -->
    <jsp:include page="_header.jsp"></jsp:include>
    <div class="clearfix">
    </div>
        <!-- giohang -->
        
  <div class="container_fullwidth">
    <div class="container shopping-cart">
      <div class="row">
        <div class="col-md-12">
          <h3 class="title">
           Giỏ hàng
          </h3>
          <div class="clearfix">
          </div>
          <table class="shop-table">
            <thead>
              <tr style="border: 1px">
        
                <th style="width: 8%">Hình ảnh</th>                
                <th style="width: 30%">Chi tiết</th>
                <th>Giá</th>
                <th>Số lượng mua</th>
                <th>Thanh toán</th>
                <th>Xóa</th>            
             
              </tr>
            </thead>
            <tbody>
            
         <c:forEach var="cart" items="${GioHang.listCTHD }">
         
            <tr>
        
                <td>
                   <img src="resources/${cart.sp.hinhAnhSp }" alt="${cart.sp.hinhAnhSp }">
                </td>
                <!--  -->
                <td style="width: 30%">
                  <div class="shop-details">
                    <div class="productname">
                    
                          <h3 class=" light-red">${cart.sp.tenSp }  </h3>
                     
                      <p>Mô tả: <span class=" light-red">${cart.sp.moTaSp }</span>
                      </p>
                  
                      
                    </div>
                </td>
                <td>
                  <h5>${cart.sp.giaSp } $USD</h5>
                </td>
                <td>
                <form action="capnhatgiohang" method="POST"  onsubmit="return ktSoLuong()" >
                 <input style="width: 100%; margin-bottom:5px; " id="getSL" type="number" name="editSlmua" value="${cart.slMua }"/> 
                 <input type="hidden" name="maSP" value="${cart.sp.maSp}">             
                  <button class="pull-center">
                	 Update
                  </button>
                
                </form>
               
  
                </td>
                <td>
                  <h5>
                    <strong class="red">${cart.tongTien} $USD
                    </strong>
                  </h5>
                </td>
                <td>
                
                  <a href="deleteitem/maSP=${cart.sp.maSp} "> 
                        
                    <img style="width: 30px; height: 30px;" src="<c:url value='/resources/images/remove.png' />"  />
                   
                                            
                  </a>
               
                </td>
              </tr>
     
             </c:forEach>
            </tbody>
            <tfoot>
              <tr>
                <td colspan="6">
                 
                   <a href="xemay"> 
                    <button class="pull-left">
                   Tiếp tục mua hàng
                    </button>
                   </a> 
                
                 
                </td>
              </tr>
            </tfoot>
          </table>
          <div class="clearfix">
          </div>
          <div class="row">
            <div class="col-md-8 col-sm-6"></div>

            <div class="col-md-4 col-sm-6">
              <div class="shippingbox">               
                <div class="grandtotal">
                  <h5>
                   Tổng cộng
                  </h5>
                  <span>
             		${GioHang.togTien } $USD
                  </span>
                </div>
                <a href="thanhtoan">
                 <button>
                  Thanh toán
                </button>
                </a>
                <span style="color: red"><p>${hdNll }</p>
                </span>
                  <span style="color: red"><p>${tkNll }</p></span>
               
              </div>
            </div>
          </div>
          </div>
        </div>
        <div class="clearfix">
        </div>
       
      </div>
    </div>
        
   
    <div class="clearfix">
    </div>
    <!-- gan footer -->
     <jsp:include page="_footer.jsp"></jsp:include>
  </div>
  
</body>
</html>