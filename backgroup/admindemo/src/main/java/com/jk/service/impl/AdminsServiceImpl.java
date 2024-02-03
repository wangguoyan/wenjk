package com.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.entity.Admins;
import com.jk.mapper.AdminsMapper;
import com.jk.service.IAdminsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements IAdminsService {
    @Override
    public List<Admins> findAll(){
        return list();
    }
}
