package com.kinghao.budai;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper统一实现MyMapper
 * @author Kinghao
 * @version 2022/10/3 23:43
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
    
}
