package com.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jk.entity.Users;

import java.util.List;
//先有接口，后又实现类
public interface IUsersService extends IService<Users> {
    List<Users> findAll();

}