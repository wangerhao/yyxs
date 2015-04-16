package com.yyxs.order.services;

import com.yyxs.order.constant.GoodsConstant;
import com.yyxs.order.constant.GoodsOrderConstant;
import com.yyxs.order.db.GoodsOrderDB;

/**
 * 商品订单services
 * @author power
 */
public class GoodsOrderServices {
	private GoodsOrderDB db = new GoodsOrderDB();
	private static GoodsOrderServices goodsOrderServices = new GoodsOrderServices();
	
	public GoodsOrderServices(){}
	
	public static GoodsOrderServices getInstace(){
		return goodsOrderServices;
	}

	/**
	 * 倍耐力（PEINEILI）商品价钱
	 * @param goodsStatus		-->商品状态（1：单个 、2：买二送一 、3买四送二）
	 **/
	public double beiNaiLiMoney(int goodsStatus) {
		double money = 0;
		if(goodsStatus == GoodsOrderConstant.BUY_A_SINGLE_STATUS){
			money = GoodsOrderConstant.PEINEILI_MONEY;
		}
		if(goodsStatus == GoodsOrderConstant.BUY_TWO_STATUS){
			money = (GoodsOrderConstant.PEINEILI_MONEY * 2);
		}
		if(goodsStatus == GoodsOrderConstant.BUY_FOUR_STATUS){
			money = (GoodsOrderConstant.PEINEILI_MONEY * 4);
		}
		return money;
	}

	public GoodsConstant getGoodById(int id) {
		// TODO Auto-generated method stub
		return db.getGoodById(id);
	}
	
	
	
}
