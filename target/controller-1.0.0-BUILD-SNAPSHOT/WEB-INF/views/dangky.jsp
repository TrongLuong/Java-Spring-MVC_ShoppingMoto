<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
      <meta name="description" content="">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="shortcut icon" href="resources/images/favicon.png">
      <title>Xe may</title>
      <link href="resources/css/bootstrap.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100' rel='stylesheet' type='text/css'>
      <link href="resources/css/font-awesome.min.css" rel="stylesheet">
      <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
      <link href="resources/css/sequence-looptheme.css" rel="stylesheet" media="all"/>
      <link href="resources/css/style.css" rel="stylesheet">
      <!--[if lt IE 9]><script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script><script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script><![endif]-->
   </head>
  <body>
  <div class="wrapper">
    <!-- gan heder -->
    <jsp:include page="_header.jsp"></jsp:include>
    <div class="clearfix">
    </div>
    <!-- gan form -->
    <div class="container_fullwidth">
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                    </div>
                    <div class="col-md-8">
                        <div class="checkout-page">
                            <ol class="checkout-steps">
                                <li class="steps active">
                                    <a href="#" class="step-title">Đăng ký</a>
                                    <div class="step-description">
                                        <div class="row">
                                            <div class="col-md-6 col-sm-6">
                                                <div class="new-customer">
                                                    <h5> Nếu đã có tài khoản?  </h5>                                                     
                                                     <a href="dangnhap"> <button>Đăng nhập tại đây</button></a>                                                   
                                                </div>
                                            </div>
                                            <div class="col-md-6 col-sm-6">
                                                <div class="your-details">
                                                    <h5>
                                                       Thông tin cá nhân
                                                    </h5>
      <!-------------------------------------------------------- form dk ---------------------------------------->
                                                    
                                                    <form:form action="xulydangky" role="form" enctype="multipart/form-data" modelAttribute="dkkh"  method="POST">
                                                        <!-- hoten -->
                                                        
                                                        <div class="form-row">
                                                            <label class="lebel-abs">
                                                                Họ và tên
                                                                <strong class="red">*</strong>
                                                            </label>
                                                            <form:input required="true"  class="input namefild" type="text"  path="hoTenKH"/>
                                                              <form:errors path="hoTenKH" cssClass="error" class="formcontrol"></form:errors>    
                                                        </div>
                                                        <!-- cmnd -->
                                                        <div class="form-row">
                                                            <label class="lebel-abs">
                                                               
                                                            </label>
                                                            <form:input type="hidden" class="input namefild" path="loaiTK" value="0"/>
                                                        </div>
                                                        
                                                 
                                                        <!-- diachi -->
                                                        <div class="form-row">
                                                            <label class="lebel-abs">
                                                               Địa chỉ<strong class="red">*</strong>
                                                            </label>
                                                            <form:input required="true"   type="text" class="input namefild" path="diaChiKH"/>
                                                             <form:errors path="diaChiKH" cssClass="error" class="formcontrol"></form:errors> 
                                                        </div>
                                                       
                                                        <!-- email -->
                                                        <div class="form-row">
                                                            <label class="lebel-abs">
                                                                Email
                                                                <strong class="red">*</strong>
                                                            </label>
                                                            <form:input required="true"   type="email" class="input namefild" path="emailTK"/>
                                                             <strong class="red">${trungEmail }</strong>  
                                                              <form:errors path="emailTK" cssClass="error" class="formcontrol"></form:errors>                                                          
                                                        </div>
                                                        <!-- mk -->
                                                        <div class="form-row">
                                                            <label class="lebel-abs">
                                                               Mật khẩu
                                                                <strong class="red">*</strong>
                                                            </label>
                                                            <form:input required="true" type="password" class="input namefild" path="pwTK"/>
                                                             <form:errors path="pwTK" cssClass="error" class="formcontrol"></form:errors> 
                                                        </div>
                                                         <button>Đăng ký</button>
                                                         
                                                    </form:form>
                                                    <p></p>
                                                     <strong class="red">*</strong> là bắt buộc nhập
                                                    
                                                    
                                                    
                                                </div>                                                
                                            </div>

                                        </div>

                                        
                                    </div>
                                </li>
                            </ol>
                        </div>
                    </div>
                    <div class="col-md-2">
                    </div>

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