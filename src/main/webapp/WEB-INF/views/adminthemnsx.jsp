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
    <title>Admin thêm sản phẩm</title>
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
            <h2>THÊM NHÀ SẢN XUẤT</h2>
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
         <form:form action="xulyadminthemnsx" modelAttribute="nsx" method="post" role="form" enctype="multipart/form-data">
                <div class="form-group row">
                    <label for="example-text-input" class="col-3 col-form-label">Tên nhà sản xuất</label>
                    <div class="col-9">
                        <form:input class="form-control" type="text"  required="true"  path="tenNSX"/>
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
