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
    <title>${good.goodName}商品订单</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  	<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css" type="text/css"></link>
  	<link rel="stylesheet" href="<%=basePath%>css/beinaili.css" type="text/css"></link>
  	<link rel="stylesheet" href="<%=basePath%>css/jquery.mobile-1.4.0.css" type="text/css"></link>
  	<!--[if lt IE 9]>
   		<script src="/js/html5shiv.js"></script>
   		<script src="/js/respond.min.js"></script>
   	<![endif]-->
  </head>
  <body>
  	<!--  <c:set var="peineili_money" value="<%=GoodsOrderConstant.PEINEILI_MONEY %>"></c:set>
  	 <c:set var="buy_a_single_status" value="<%=GoodsOrderConstant.BUY_A_SINGLE_STATUS %>"></c:set>
 	 <c:set var="buy_two_status" value="<%=GoodsOrderConstant.BUY_TWO_STATUS %>"></c:set>
 	 <c:set var="buy_four_status" value="<%=GoodsOrderConstant.BUY_FOUR_STATUS %>"></c:set>  -->
 	 <div class="container">
	 	<center><h2>${good.goodName}</h2></center>
	 	<center><img width="300px" height="300px" alt="${good.goodName}" src="<%=basePath%>images/${good.goodImg}"> </center>
	 	<br/>
	 	<form id="orderSubmitForm" aciton="###" >
	 		<c:if test="${good.goodColor == 1}">
				<p class="text-danger">请根据需求选择合适的卫裤颜色!</p>
		  		<div class="row">
			 		<div class="col-md-12">
			 			<nav>
						  <ul class="pager">
						    <li class="previous"><a href="javascript:void(0)" name="buyColor" id="buyColor1" style="background-color: #00BFFF;">黑色</a></li>
						    <!-- <li class="previous"><a href="javascript:void(0)" name="buyColor" id="buyColor2" style="">红色</a></li>
						    <li class="previous"><a href="javascript:void(0)" name="buyColor" id="buyColor3" style="">白色</a></li> -->
						  </ul>
						</nav>
						<input type="hidden" id="goodsColor" name="goodsColor" value="0"/>
			 		</div>
			 	</div>
		 	</c:if>
		 	<c:if test="${good.goodType == 1}">
		 	<p class="text-danger">请根据需求选择合适的卫裤尺寸!</p>
		  		<div class="row">
			 		<div class="col-md-12">
			 			<nav>
						  <ul class="pager">
						    <li class="previous"><a href="javascript:void(0)" name="buyType" id="buyType1" style="background-color: #00BFFF;">L号</a></li>
						    <li class="previous"><a href="javascript:void(0)" name="buyType" id="buyType2" style="">XL号</a></li>
						    <li class="previous"><a href="javascript:void(0)" name="buyType" id="buyType3" style="">XXL号</a></li>
						  </ul>
						</nav>
						<input type="hidden" id="goodsType" name="goodsType" value="0"/>
			 		</div>
			 	</div>
		 	</c:if>
		 	<p class="text-danger">请根据需求选择合适的套餐!</p>
		 	<div class="row">
		 		<div class="col-md-12">
		 			<nav>
					  <ul class="pager">
					    <li class="previous"><a href="javascript:void(0)" id="buyASingle" style="background-color: #00BFFF;">买单个</a></li>
					    <li class="previous"><a href="javascript:void(0)" id="buyTwo" style="">买二送一</a></li>
					    <li class="previous"><a href="javascript:void(0)" id="buyFour" style="">买四送二</a></li>
					  </ul>
					</nav>
					<input type="hidden" id="goodsStatus" name="orderNum" value="${buy_a_single_status}"/>
					<input type="hidden" id="goodsStatus" name="goodId" value="${good.goodId}"/>
					<input type="hidden" id="goodsTotalPrice" name="goodsTotalPrice" value="${good.goodOutPrice}"/>
		 		</div>
		 	</div>
		 	<p class="text-danger">请填写手机号,收货人,收货地址!</p>
		 	<div class="row" >
				<div class="col-md-12">
					<div class="input-group">
				  <span class="input-group-addon" id="basic-addon1">手机号　</span>
				  <input type="text" class="form-control" aria-describedby="basic-addon1" placeholder="请输入手机号"
				   id="mobilePhoneNumber" name="orderPhone"/>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 ">
					<div class="input-group">
				  <span class="input-group-addon" id="basic-addon1">收货人　</span>
				  <input type="text" class="form-control " aria-describedby="basic-addon1" placeholder="请输入收货人姓名"
				  id="consignee" name="orderConsignee"/>
				</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="input-group">
				  <span class="input-group-addon" id="basic-addon1">收货地址</span>
				  		<select id="s_province" name="s_province"></select>  
					    <select id="s_city" name="s_city" ></select>  
					    <select id="s_county" name="s_county"></select>
					    <script type="text/javascript" src="<%=basePath%>js/area.js"></script>
					    
					    <script type="text/javascript">_init_area();</script>
				  <textarea class="form-control" aria-describedby="basic-addon1" placeholder="请继续输入详细收货地址"
				   id="detailedAddress" name="orderAddres"></textarea>
				</div>
				</div>
			</div>
			<br/>
		 	
		 	<div class="row">
				<div class="col-md-12">
					最终支付<span id="money">￥${good.goodOutPrice}</span>元
				</div>
			</div>
			<br/>
	 	</form>
	 	 <button class="c_txt orange_bg" id="orderSubmitBtn">提交订单</button></br></br>
	 </div>
	
	 <input type="hidden" value="${good.goodOutPrice}" id="peineiliMoney"/>
	 <input type="hidden" value="${good}" id="good"/>
	 <input type="hidden" value="${buy_a_single_status}" id="buyASingleStatus"/>
	 <input type="hidden" value="${buy_two_status}" id="buyTwoStatus"/>
	 <input type="hidden" value="${buy_four_status}" id="buyFourStatus"/>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/layer/layer.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/beinaili.js"></script>
  </body>
</html>
