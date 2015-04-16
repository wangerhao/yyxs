package com.yyxs.order.constant;


/**
 * 商品订单常量
 * @author power
 */
public class GoodsOrderConstant {

	/** 倍耐力（PEINEILI）价格标识 */
	public static double PEINEILI_MONEY = 138;
	
	/** 买单个状态标识 */
	public static int BUY_A_SINGLE_STATUS = 1;
	
	/** 买二送一状态标识 */
	public static int BUY_TWO_STATUS = 2;
	
	/** 买四送二状态标识 */
	public static int BUY_FOUR_STATUS = 3;
	
	private int orderId;
	private String orderPhone;
	private String orderConsignee;
	private String orderAddres;
	private int orderNum;
	private double orderPrice;
	private String orderTime;
	private int orderStatus;
	private GoodsConstant goods;
	
	public final static int DAICHULI = 1;
	public final static int DAIFAHUO = 2;
	public final static int YIFAHUO = 3;
	public final static int YIWANCHENG = 4;
	public final static int DINGDANSHIBAI = 5;
	public GoodsOrderConstant(){}
	public GoodsOrderConstant(String orderPhone, String orderConsignee,
			String orderAddres, int orderNum, double orderPrice,
			String orderTime, int orderStatus, GoodsConstant goods) {
		super();
		this.orderPhone = orderPhone;
		this.orderConsignee = orderConsignee;
		this.orderAddres = orderAddres;
		this.orderNum = orderNum;
		this.orderPrice = orderPrice;
		this.orderTime = orderTime;
		this.orderStatus = orderStatus;
		this.goods = goods;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public String getOrderConsignee() {
		return orderConsignee;
	}
	public void setOrderConsignee(String orderConsignee) {
		this.orderConsignee = orderConsignee;
	}
	public String getOrderAddres() {
		return orderAddres;
	}
	public void setOrderAddres(String orderAddres) {
		this.orderAddres = orderAddres;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public GoodsConstant getGoods() {
		return goods;
	}
	public void setGoods(GoodsConstant goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "GoodsOrderConstant [goods=" + goods + ", orderAddres="
				+ orderAddres + ", orderConsignee=" + orderConsignee
				+ ", orderId=" + orderId + ", orderNum=" + orderNum
				+ ", orderPhone=" + orderPhone + ", orderPrice=" + orderPrice
				+ ", orderStatus=" + orderStatus + ", orderTime=" + orderTime
				+ "]";
	}
	
}
