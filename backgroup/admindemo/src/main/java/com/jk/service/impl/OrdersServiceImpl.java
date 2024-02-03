package com.jk.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.entity.Orders;
import com.jk.mapper.IOrdersMapper;
import com.jk.service.IOrdersService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl extends ServiceImpl<IOrdersMapper, Orders> implements IOrdersService {
    @Override
    public List<Orders> findAll(){
        return list();
    }
}
