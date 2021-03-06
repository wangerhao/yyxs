package com.yyxs.order.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import com.yyxs.order.constant.GoodsConstant;
import com.yyxs.order.db.GoodsOrderDB;
import com.yyxs.order.services.GoodsOrderServices;
import com.yyxs.order.util.GoodsOrderUtil;
import com.yyxs.order.util.StringUtil;

/**
 * 倍耐力（PEINEILI）商品订单action
 * @author power
 */
@IocBean
@InjectName
public class OrderAction {
	private static Logger log = Logger.getLogger(OrderAction.class);
	private GoodsOrderServices service = new GoodsOrderServices();
	
	/**
	 * 倍耐力（PEINEILI）商品展示
	 */
	@At("/goodOrder")
	@Ok("jsp:/jsp/order.jsp")
	public void showGood(HttpServletRequest request, HttpResponse response) {
		String goodId = request.getParameter("goodId");

		if (StringUtil.isNullOrBlank(goodId) || !StringUtil.isNumber(goodId)) {
			goodId = "2";
		}

		GoodsConstant good = service.getGoodById(Integer.parseInt(goodId));
		
		request.setAttribute("good", good);
	}
	/**
	 * 跳转到订单成功页面
	 */
	@At("/success")
	@Ok("jsp:/jsp/succes.jsp")
	public void success() {}
	/**
	 * 跳转到订单失败页面
	 */
	@At("/error")
	@Ok("jsp:/jsp/error.jsp")
	public void error() {}
	
	/**
	 * 商品添加
	 * @param mobilePhoneNumber		-->手机号码
	 * @param consignee				-->收货人
	 * @param detailedAddress		-->收货地址
	 */
	@At
	@Ok("raw")
	public String orderAdd(@Param("goodId") String goodId,@Param("orderPhone") String mobilePhoneNumber,
			@Param("orderConsignee") String consignee, @Param("orderAddres") String detailedAddress,
			@Param("s_province") String s_province, @Param("s_city") String s_city,@Param("s_county") String s_county,
			@Param("goodsTotalPrice")double goodsTotalPrice,
			@Param("orderNum") int goodsStatus,
			@Param("goodsType") int goodsType,
			@Param("goodsColor") int goodsColor){
		double money = 0.00;
		String userAddress = s_province+s_city+s_county+detailedAddress;
		try {
			GoodsOrderUtil.log("商品编号:"+goodId+"用户手机:"+mobilePhoneNumber+"用户名称:"+consignee+"用户地址:"+userAddress+"应付金额:"+money+"订单状态:"+goodsStatus+"商品型号:"+goodsType+"商品颜色:"+goodsColor);
//			double money = GoodsOrderServices.getInstace().beiNaiLiMoney(goodsStatus);
			if(goodsTotalPrice > 0){
				java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
				money =Double.parseDouble(df.format(goodsTotalPrice));
			}
			GoodsOrderDB.getInstance().beiNaiLiGoodsOrderAdd(goodId,mobilePhoneNumber, consignee, userAddress, money, goodsStatus,goodsType,goodsColor);
			
			
			return "success";
		} catch (Throwable e) {
			GoodsOrderUtil.log(e.getMessage(), e);
			return "fail";
		}
	}
	
	/**
	 * 英国卫裤订单展示
	 */
	@At("/yingGuoWeiKu")
	@Ok("jsp:/jsp/goodsorder/yingGuoWeiKu.jsp")
	public void yingGuoWeiKuOrderShow(){}
}
