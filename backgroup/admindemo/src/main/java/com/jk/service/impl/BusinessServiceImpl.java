package com.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.entity.Business;
import com.jk.mapper.IBusinessMapper;
import com.jk.service.IBusinessService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl extends ServiceImpl<IBusinessMapper, Business> implements IBusinessService {
    @Override
    public List<Business> findAll(){
        return list();
    }
}
