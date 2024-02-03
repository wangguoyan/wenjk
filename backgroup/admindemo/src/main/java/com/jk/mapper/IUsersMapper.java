package com.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jk.entity.Users;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUsersMapper extends BaseMapper<Users> {
}
