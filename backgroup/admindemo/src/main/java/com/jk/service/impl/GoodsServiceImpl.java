package com.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.entity.Goods;
import com.jk.mapper.IGoodsMapper;
import com.jk.service.IGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<IGoodsMapper, Goods> implements IGoodsService {
    @Override
    public List<Goods> findAll() {
        return list();
    }
}
