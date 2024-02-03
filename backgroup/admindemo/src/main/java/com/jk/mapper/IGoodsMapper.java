package com.jk.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jk.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGoodsMapper extends BaseMapper<Goods> {
}
