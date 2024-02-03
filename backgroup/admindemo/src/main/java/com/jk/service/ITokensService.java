package com.jk.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.jk.entity.Tokens;

import java.util.List;

public interface ITokensService extends IService<Tokens> {
    List<Tokens> findAll();
}
