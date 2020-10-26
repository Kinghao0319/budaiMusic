package com.kinghao.budai.mapper;

import com.kinghao.budai.MyMapper;
import com.kinghao.budai.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author Kinghao
 * @Date 2020/8/3 21:22
 * @Version 1.0
 */
//要在application添加MapperScan才能扫描到
public interface UserMapper extends MyMapper<User> {

}
