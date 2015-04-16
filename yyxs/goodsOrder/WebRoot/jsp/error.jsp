<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.yyxs.order.constant.GoodsOrderConstant"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
  <head>
    <title>订单成功</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  	<link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css"></link>
  	<link rel="stylesheet" href="/css/beinaili.css" type="text/css"></link>
  	<link rel="stylesheet" href="/css/jquery.mobile-1.4.0.min.js" type="text/css"></link>

  </head>
  
  <body>
    <div class="container">
	 	<center><img width="200px" height="200px"  src="../images/error.png"> </center>
	 	<center><h2>订单提交失败!</h2></center>
	</div></br></br></br></br></br>
  </body>
</html>
