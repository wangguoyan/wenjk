package com.jk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
//商品表
public class Goods {
    @TableId(type = IdType.AUTO)
    private int id;
    private String goodsid;
    private String goodsname;
    private String production;
    private String origin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goodsid='" + goodsid + '\'' +
                ", goodsname='" + goodsname + '\'' +
                ", production='" + production + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
