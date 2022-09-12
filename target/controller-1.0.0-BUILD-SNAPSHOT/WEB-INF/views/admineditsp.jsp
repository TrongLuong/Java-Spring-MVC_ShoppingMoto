<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:choose>
	<c:when test="${userDN != null}">
<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="resources/images/favicon.png">
    <title>Admin edit sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
   <jsp:include page="_adminmenu.jsp"></jsp:include>
   
	<div class="col-sm-10">
    <div class="row">
        <div class="col-sm-4">
           
        </div>
        <div class="col-sm-6">
            <h2>FORM EDIT SẢN PHẨM</h2>
        </div>
        <div class="col-sm-2">

            
        </div>
    </div>
    <!-- TABLE DANH SÃCH -->
   
    
    <!-- formxe -->
   <div class="row">  
        <div class="col-sm-2"></div>
        <div class="col-sm-6">
        
        
           
    <!-- formxe -->
    <h3 style="color: red;">${err }</h3>
         <form:form action="xulyeditmnsp" modelAttribute="spedit" method="post" role="form" enctype="multipart/form-data">
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Tên Sản phẩm</label>
                    <div class="col-9">
                        <form:input class="form-control" type="text"  required="true" path="tenSp"/>
                         <form:input  hidden="true" class="form-control" type="text"   path="maSp"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Đơn giá</label>
                    <div class="col-9">
                        <form:input class="form-control" type="number" required="true" path="giaSp"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Số lượng</label>
                    <div class="col-9">
                        <form:input class="form-control" type="number" required="true" path="tongSLSp"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-number-input" class="col-3 col-form-label">Mô tả</label>
                    <div class="col-9">
                        <form:input class="form-control" required="true" type="text" path="moTaSp"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Hình ảnh</label>
                    <div class="col-9">
                        <input required   class="form-control-file" type="file" name="file" path="hinhAnhSp">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Nhà sản xuất</label>
                    <div class="col-9">
                    
                     <form:select class="form-control" path="maNSX">	
                     <c:forEach  items="${listNSX }" var="nsx">
                       <form:option value="${nsx.maNSX }">${nsx.tenNSX } </form:option>
                     </c:forEach>						 
			     
         			
         			  
					</form:select>
                       
                       
                    </div>
                </div>
               
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Loại sản phẩm</label>
                   
                    <div class="col-9">
                     <form:select class="form-control" path="loaiSP">
							<form:option value="Xe"/>
							<form:option value="Phu kien"/>
						</form:select>
                      
                    </div>
                </div>
                
                <div class="form-group row">
                        <label for="example-text-input" class="col-3 col-form-label"> </label>
                        <div class="col-9">
                                <input value="Lưu"  style="background-color: gray" class="btn btn-success form-control" type="submit"/>
                        </div>
                    </div>                            
            </form:form>
        </div>
        <div class="col-sm-2"></div>

    </div> 
   
      </div>
  
</body>

</html>
	</c:when>
	<c:otherwise>
		<jsp:include page="err404.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
