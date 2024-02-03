package com.jk.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jk.entity.Users;
import com.jk.mapper.IUsersMapper;
import com.jk.service.IUsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl extends ServiceImpl<IUsersMapper,Users> implements IUsersService {
    @Override
    public List<Users> findAll(){
        return list();
    }
//@Service
//public class TokensServiceImpl extends ServiceImpl<ITokensMapper, Tokens> implements ITokensService {
//    @Override
//    public List<Tokens> findAll() {
//        return list();
//    }
//}
}
