package com.yyxs.order.action;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

@IocBean
@InjectName
public class GoodsAction {
	
	@At("/showAllGoods")
	@Ok("jsp:/jsp/goods/goodList.jsp")
	public void showAllGoods(){}
}
