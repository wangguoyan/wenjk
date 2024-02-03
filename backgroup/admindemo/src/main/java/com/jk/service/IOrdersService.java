package com.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jk.entity.Orders;

import java.util.List;

public interface IOrdersService extends IService<Orders> {
    List<Orders> findAll();
}