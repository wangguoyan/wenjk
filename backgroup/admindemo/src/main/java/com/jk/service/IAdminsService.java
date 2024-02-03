package com.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jk.entity.Admins;


import java.util.List;

public interface IAdminsService extends IService<Admins> {
    List<Admins> findAll();
}