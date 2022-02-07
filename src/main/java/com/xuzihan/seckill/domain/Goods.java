package com.xuzihan.seckill.domain;

/**
 * @author ZihanXu
 * @version 1.0
 */
public class Goods {
    private Long id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoods_name(String goodsName) {
        this.goodsName = goodsName;
    }
    public String getGoodsTitle() {
        return goodsTitle;
    }
    public void setGoods_title(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }
    public String getGoodsImg() {
        return goodsImg;
    }
    public void setGoods_img(String goodsImg) {
        this.goodsImg = goodsImg;
    }
    public String getGoodsDetail() {
        return goodsDetail;
    }
    public void setGoods_detail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }
    public Double getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoods_price(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public Integer getGoodsStock() {
        return goodsStock;
    }
    public void setGoods_stock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }
}
