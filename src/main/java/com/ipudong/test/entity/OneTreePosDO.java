package com.ipudong.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


public class OneTreePosDO implements Serializable{


    private static final long serialVersionUID = 5938141450700588816L;
    private Long id;
    private BigDecimal realamt;//销售金额
    private String posCode;//收银机代码
    private String posName;//收银机名称
    private String cardNum;//会员卡号
    private String serialNum;//流水号
    private String goodsCode;//商品代码
    private Integer goodsNum;//销售数量
    private String goodsName;//商品名称
    private String clerkCode;//导购员代码
    private String clerkName;//导购员姓名
    private String cashierCode;//收银员代码
    private String cashierName;//收银员名称
    private String businessType;//单据类型  retail: 零售
    private String companyCode;//公司代码
    private String companyName;//公司名称
    private String shopCode;//门店代码
    private String shopName;//门店名称
    private Date ocrtime;//销售时间
    private String fx4;
    private String fx6;
    private String fx7;
    private String fx8;
    private BigDecimal grossRate;//毛利率
    private BigDecimal costPrice;//销售成本价
    private BigDecimal grossPrice;//毛利金额
    private BigDecimal favamt;//优惠金额
    private String dlcode;
    private String dlname;
    private String zlcode;
    private String zlname;
    private String xlcode;
    private String xlname;
    private Date createdTime;
    private Date updatedTime;
    private Date beginTime;
    private Date endTime;
    private String couponCode;
    private String couponRealamt;
    private String couponUseNum;


    public OneTreePosDO() {
    }

    public BigDecimal getRealamt() {
        return realamt;
    }

    public void setRealamt(BigDecimal realamt) {
        this.realamt = realamt;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getClerkCode() {
        return clerkCode;
    }

    public void setClerkCode(String clerkCode) {
        this.clerkCode = clerkCode;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getCashierCode() {
        return cashierCode;
    }

    public void setCashierCode(String cashierCode) {
        this.cashierCode = cashierCode;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getOcrtime() {
        return ocrtime;
    }

    public void setOcrtime(Date ocrtime) {
        this.ocrtime = ocrtime;
    }

    public String getFx4() {
        return fx4;
    }

    public void setFx4(String fx4) {
        this.fx4 = fx4;
    }

    public String getFx6() {
        return fx6;
    }

    public void setFx6(String fx6) {
        this.fx6 = fx6;
    }

    public String getFx7() {
        return fx7;
    }

    public void setFx7(String fx7) {
        this.fx7 = fx7;
    }

    public String getFx8() {
        return fx8;
    }

    public void setFx8(String fx8) {
        this.fx8 = fx8;
    }

    public BigDecimal getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(BigDecimal grossPrice) {
        this.grossPrice = grossPrice;
    }

    public BigDecimal getFavamt() {
        return favamt;
    }

    public void setFavamt(BigDecimal favamt) {
        this.favamt = favamt;
    }

    public String getDlcode() {
        return dlcode;
    }

    public void setDlcode(String dlcode) {
        this.dlcode = dlcode;
    }

    public String getDlname() {
        return dlname;
    }

    public void setDlname(String dlname) {
        this.dlname = dlname;
    }

    public String getZlcode() {
        return zlcode;
    }

    public void setZlcode(String zlcode) {
        this.zlcode = zlcode;
    }

    public String getZlname() {
        return zlname;
    }

    public void setZlname(String zlname) {
        this.zlname = zlname;
    }

    public String getXlcode() {
        return xlcode;
    }

    public void setXlcode(String xlcode) {
        this.xlcode = xlcode;
    }

    public String getXlname() {
        return xlname;
    }

    public void setXlname(String xlname) {
        this.xlname = xlname;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponRealamt() {
        return couponRealamt;
    }

    public void setCouponRealamt(String couponRealamt) {
        this.couponRealamt = couponRealamt;
    }

    public String getCouponUseNum() {
        return couponUseNum;
    }

    public void setCouponUseNum(String couponUseNum) {
        this.couponUseNum = couponUseNum;
    }

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE); }
}
