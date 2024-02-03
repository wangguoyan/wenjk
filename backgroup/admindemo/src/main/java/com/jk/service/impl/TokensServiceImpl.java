package com.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.entity.Tokens;
import com.jk.mapper.ITokensMapper;
import com.jk.service.ITokensService;
import org.springframework.stereotype.Service;

import java.util.List;
//此类写数据库相关语句
@Service
public class TokensServiceImpl extends ServiceImpl<ITokensMapper, Tokens> implements ITokensService {
    @Override
    public List<Tokens> findAll() {
        return list();
    }
}
