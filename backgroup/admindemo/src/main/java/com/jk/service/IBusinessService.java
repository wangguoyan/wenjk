package com.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jk.entity.Business;

import java.util.List;

public interface IBusinessService extends IService<Business> {
    List<Business> findAll();
}