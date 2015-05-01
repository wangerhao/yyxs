package com.yyxs.order.db;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.ht.db.DBOperate;
import com.yyxs.order.constant.GoodsConstant;
import com.yyxs.order.constant.GoodsOrderConstant;
import com.yyxs.order.util.GoodsOrderUtil;

/**
 * 商品订单DB
 * @author power
 */
public class GoodsOrderDB {
	
	private DBOperate dbo = new DBOperate();
	
	public GoodsOrderDB(){}
	
	private static GoodsOrderDB goodsOrderDB = new GoodsOrderDB();
	
	public static GoodsOrderDB getInstance(){
		return goodsOrderDB;
	}

	/**
	 * 倍耐力（PEINEILI）商品订单添加
	 * @param mobilePhoneNumber		-->手机号码
	 * @param consignee				-->收货人
	 * @param detailedAddress		-->详细地址
	 * @param goodsStatus			-->商品状态
	 * @throws Throwable 
	 */
	public void beiNaiLiGoodsOrderAdd(String mobilePhoneNumber, String consignee, String detailedAddress, double money, int goodsStatus) throws Throwable {
		String sql = "insert into yyxs_goods_order(mobile_phone_number,consignee,detailed_address,goods_status,money,systime) values(?,?,?,?,?,?)";
		List<Object> paramList = Arrays.asList((Object)mobilePhoneNumber, consignee, detailedAddress, goodsStatus, money, GoodsOrderUtil.currentTime());
		dbo.insertData(sql, paramList);
	}
	public static void main(String[] args) {
		System.out.println(getInstance());
	}

	public GoodsConstant getGoodById(int id) {
		GoodsConstant good = null;
		String sql = "select id,good_inprice,good_name,good_outprice,good_sex,good_color,good_type,good_img from yyxs_goods where id = ?";
		List<Object> paramList = Arrays.asList((Object)id);
		 try {
			List<Map<Object, Object>> list = dbo.retrieveSQL(sql, paramList);
			for (Map<Object, Object> map : list) {
				good = new GoodsConstant();
				good.setGoodId( Integer.valueOf((map.get("id").toString())));
				good.setGoodInPrice(Double.valueOf(map.get("good_inprice").toString()));
				good.setGoodOutPrice(Double.valueOf(map.get("good_outprice").toString()));
				good.setGoodName(map.get("good_name").toString());
				good.setGoodImg(map.get("good_img").toString());
				good.setGoodSex(Integer.valueOf(map.get("good_sex").toString()));
				if(map.get("good_color") != null){
					good.setGoodColor(Integer.valueOf(map.get("good_color").toString()));
				}
				if(map.get("good_type") != null){
					good.setGoodType(Integer.valueOf(map.get("good_type").toString()));
				}
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}finally{
		}
		
		return good;
	}

	public void beiNaiLiGoodsOrderAdd(String goodId, String mobilePhoneNumber,
			String consignee, String detailedAddress, double money,
			int goodsStatus, int goodsType, int goodsColor) {
		String sql = "insert into yyxs_goods_order(mobile_phone_number,consignee,detailed_address,goods_number,money,systime,good_id,order_status,order_type,order_color) values(?,?,?,?,?,?,?,?,?,?)";
		List<Object> paramList = Arrays.asList((Object)mobilePhoneNumber, consignee, detailedAddress, goodsStatus, money, GoodsOrderUtil.currentTime(),goodId,GoodsOrderConstant.DAICHULI,goodsType,goodsColor);
		try {
			dbo.insertData(sql, paramList);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
