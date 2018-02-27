package com.dto;

public class CartDTO {
   private int num;
   private String userid;
   private	String gImage;
   private String gCode;
   private String gName;
   private int gPrice;
   private String goodsSize;
   private String goodsColor;
   private int goodsAmount;
   
public CartDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getgImage() {
	return gImage;
}
public void setgImage(String gImage) {
	this.gImage = gImage;
}
public String getgCode() {
	return gCode;
}
public void setgCode(String gCode) {
	this.gCode = gCode;
}
public String getgName() {
	return gName;
}
public void setgName(String gName) {
	this.gName = gName;
}
public int getgPrice() {
	return gPrice;
}
public void setgPrice(int gPrice) {
	this.gPrice = gPrice;
}
public String getGoodsSize() {
	return goodsSize;
}
public void setGoodsSize(String goodsSize) {
	this.goodsSize = goodsSize;
}
public String getGoodsColor() {
	return goodsColor;
}
public void setGoodsColor(String goodsColor) {
	this.goodsColor = goodsColor;
}
public int getGoodsAmount() {
	return goodsAmount;
}
public void setGoodsAmount(int goodsAmount) {
	this.goodsAmount = goodsAmount;
}
@Override
public String toString() {
	return "CartDTO [gImage=" + gImage + ", gCode=" + gCode + ", gName=" + gName + ", gPrice=" + gPrice + ", goodsSize="
			+ goodsSize + ", goodsColor=" + goodsColor + ", goodsAmount=" + goodsAmount + "]";
}
   
   
   
   
   
   
}
