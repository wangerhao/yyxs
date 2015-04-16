package com.yyxs.order.constant;

public class GoodsConstant {
	/**
	 * 商品编号
	 */
	private Integer goodId;
	/**
	 * 商品名称
	 */
	private String goodName;
	/**
	 * 商品价格
	 */
	private Double goodOutPrice;
	/**
	 * 商品进货价
	 */
	private Double goodInPrice;
	
	/**
	 * 商品用途: 男用女用
	 */
	private Integer goodSex;
	private String goodImg;
	
	public final static Integer MAN = 1;
	public final static Integer WOMAN = 0;
	
	
	public GoodsConstant() {}
	public GoodsConstant(String goodName, double goodOutPrice,
			double goodInPrice, Integer goodSex) {
		super();
		this.goodName = goodName;
		this.goodOutPrice = goodOutPrice;
		this.goodInPrice = goodInPrice;
		this.goodSex = goodSex;
	}
	
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public Double getGoodOutPrice() {
		return goodOutPrice;
	}
	public void setGoodOutPrice(Double goodOutPrice) {
		this.goodOutPrice = goodOutPrice;
	}
	public Double getGoodInPrice() {
		return goodInPrice;
	}
	public void setGoodInPrice(Double goodInPrice) {
		this.goodInPrice = goodInPrice;
	}
	public Integer getGoodSex() {
		return goodSex;
	}
	public void setGoodSex(Integer goodSex) {
		this.goodSex = goodSex;
	}
	public String getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}
	@Override
	public String toString() {
		return "GoodsConstant [goodId=" + goodId + ", goodInPrice="
				+ goodInPrice + ", goodName=" + goodName + ", goodOutPrice="
				+ goodOutPrice + ", goodSex=" + goodSex + "]";
	}
	
}
