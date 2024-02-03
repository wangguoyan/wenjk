package com.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jk.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrdersMapper extends BaseMapper<Orders> {
}
