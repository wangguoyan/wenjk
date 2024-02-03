package com.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jk.entity.Goods;

import java.util.List;

public interface IGoodsService extends IService<Goods> {
    List<Goods> findAll();

}
