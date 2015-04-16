(function($){
	
	if(typeof $.yyxs == "undefined"){
		$.yyxs = {};
	}
	
	if(typeof $.yyxs.order == "undefined"){
		$.yyxs.order = {};
	}
	
	/** 手机号验证 */
	$.yyxs.order.mobilePhoneNumberVail = function(){
		if($.trim($("#mobilePhoneNumber").val()).length <= 0){
			return "请填写收货人的手机号!";
		}
		var regex = /^(13|15|18)[0-9]{9}/;
		if(regex.test($("#mobilePhoneNumber").val()) == false){
			return "请填写正确的手机号!";
		}
		return true;
	}
	
	/** 收货人验证 */
	$.yyxs.order.consigneeVail = function(){
		if($.trim($("#consignee").val()).length <= 0){
			return "请填写收货人的姓名!";
		}
		return true;
	}
	
	/** 收货的详细地址 */
	$.yyxs.order.detailedAddressVail = function(){
		if($.trim($("#detailedAddress").val()).length <= 0){
			return "请填写收货的详细地址!";
		}
		return true;
	}
})(jQuery);
$(function(){
	
	/** 买单个按钮 */
	$("#buyASingle").click(function(){
		$(this).attr("style","background-color: #00BFFF;");
		$("#buyTwo").attr("style","");
		$("#buyFour").attr("style","");
		$("#money").html("￥" + $("#peineiliMoney").val());
		$("#goodsStatus").val(1);
		$("#goodsTotalPrice").val($("#peineiliMoney").val());
	});
	
	/** 买二送一按钮 */
	$("#buyTwo").click(function(){
		$(this).attr("style","background-color: #00BFFF;");
		$("#buyASingle").attr("style","");
		$("#buyFour").attr("style","");
		$("#money").html("￥" + ($("#peineiliMoney").val() * 2));
		$("#goodsStatus").val(2);
		$("#goodsTotalPrice").val($("#peineiliMoney").val() * 2);
	});
	
	/** 买四送二按钮 */
	$("#buyFour").click(function(){
		$(this).attr("style","background-color: #00BFFF;");
		$("#buyASingle").attr("style","");
		$("#buyTwo").attr("style","");
		$("#money").html("￥" + ($("#peineiliMoney").val() * 4));
		$("#goodsStatus").val(4);
		$("#goodsTotalPrice").val($("#peineiliMoney").val() * 4);
	});
	$("#mobilePhoneNumber").blur(function(){
		var mobilePhoneNumber = $.yyxs.order.mobilePhoneNumberVail();
		if(mobilePhoneNumber != true){
			$("#mobilePhoneNumber").parent().attr("class","input-group has-error");
			$("#mobilePhoneNumber").focus();
		}else{
			$("#mobilePhoneNumber").parent().attr("class","input-group has-success");
		}
	});
	$("#consignee").blur(function(){
		var consignee = $.yyxs.order.consigneeVail();
		if(consignee != true){
			$("#consignee").parent().attr("class","input-group has-error");
			$("#consignee").focus();
		}else{
			$("#consignee").parent().attr("class","input-group has-success");
		}
	});
	$("#detailedAddress").blur(function(){
		var detailedAddress = $.yyxs.order.detailedAddressVail();
		if(detailedAddress != true){
			$("#detailedAddress").parent().attr("class","input-group has-error");
			$("#detailedAddress").focus();
		}else{
			$("#detailedAddress").parent().attr("class","input-group has-success");
		}
	});
	
	
	/** 表单验证 */
	$("#orderSubmitBtn").click(function(){
		var mobilePhoneNumber = $.yyxs.order.mobilePhoneNumberVail();
		if(mobilePhoneNumber != true){
			$("#mobilePhoneNumber").parent().attr("class","input-group has-error");
			$("#mobilePhoneNumber").focus();
			return false;
		}
		var consignee = $.yyxs.order.consigneeVail();
		if(consignee != true){
			$("#consignee").parent().attr("class","input-group has-error");
			$("#consignee").attr("placeholder",consignee);
			$("#consignee").focus();
			return false;
		}
		var detailedAddress = $.yyxs.order.detailedAddressVail();
			if(detailedAddress != true){
			$("#detailedAddress").parent().attr("class","input-group has-error");
			$("#detailedAddress").attr("placeholder",detailedAddress);
			$("#detailedAddress").focus();
			return false;
		}
		$.ajax({
			url:"orderAdd.html",
			type:"post",
			data:$("#orderSubmitForm").serialize(),
			success:function(res){
				if(res == "success"){
//					alert("商品下单成功!");
					location.href = "success.html";
//					layer.alert("商品下单成功!",1);
//					window.setTimeout(show,3000);
					return true;
				} 
				if(res == "fail") {
					alert("商品下单失败,请联系商家!");
					location.href = "error.html";
					return false;
				}
			}
		});
	});
	function show(){
		location.reload();
	}
});