<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true"%>

<div class="container-fluid" style="margin: 10px">
        <!-- header -->
        <div class="row" style="text-align: center">
            <div class="col-sm-3">
                <!-- Brand -->
                <a class="navbar-brand" href="/controller/home">Trang web sản phẩm</a>
            </div>
            <div class="col-sm-6">
                    <h1>GIAO DIỆN QUẢN LÝ</h1></div>
            <div class="col-sm-3">

 									 <c:choose>                                	
									<c:when test="${userDN != null}">
										<span>ADMIN |</span><span style="color: red"> ${userDN.hoTenKH} </span> |
										<span ><a style="text-decoration:none; border: 1px solid; border-radius: 5px; padding: 2px;" href="dangxuat" class="reg">Đăng xuất</a>	 </span>				
									</c:when>
									
								</c:choose>
                
            </div>
        </div>

        <!-- body -->
        <div class="row">
            <!-- menu -->
            <div class="col-sm-2" style="background-color:lavender;">
                <nav class="navbar  bg-dark navbar-dark">
                    <!-- Links -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="adminquanlysp">Quản lý sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="adminquanlynsx">Quản lý NSX</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="quanlydonhang">Quản lý đơn hàng</a>
                        </li>
                       
                         
                                         
                    </ul>
                </nav>

            </div>
          
     

 