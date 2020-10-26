package com.kinghao.budai.service.impl;

import com.kinghao.budai.common.CommonErrorCode;
import com.kinghao.budai.dto.SessionData;
import com.kinghao.budai.dto.request.LoginRequest;
import com.kinghao.budai.dto.request.RegisterRequest;
import com.kinghao.budai.dto.request.UpdateUserInfoRequest;
import com.kinghao.budai.entity.User;
import com.kinghao.budai.mapper.UserMapper;
import com.kinghao.budai.service.UserService;
import com.kinghao.budai.util.AssertUtil;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.sql.Timestamp;

/**
 * @Author Kinghao
 * @Date 2020/10/21 16:37
 * @Version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource(type = UserMapper.class)
    private UserMapper usermapper;

    @Override
    public void userRegister(RegisterRequest registerRequest) {
        //判断用户名是否已经注册过
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",registerRequest.getUsername());
        User rt=usermapper.selectOneByExample(example);
        AssertUtil.isTrue(rt==null, CommonErrorCode.USERNAME_USED_ERROR);

        //以上检验成功，添加用户
        User user=User
                .builder()
                .tel(registerRequest.getTel())
                .password(registerRequest.getPassword())
                .username(registerRequest.getUsername())
                .signature(registerRequest.getSignature())
                .type(registerRequest.getType())
                .create_time(new Timestamp(System.currentTimeMillis()))
                .age(registerRequest.getAge())
                .build();
        if(registerRequest.getGender()!=null){
            user.setGender(registerRequest.getGender().equals("男")?0:1);
        }
        usermapper.insertSelective(user);//只给传进来的字段赋值
    }

    @Override
    public User userLogin(LoginRequest loginRequest) {
        String username=loginRequest.getUsername();
        String password=loginRequest.getPassword();
        //检验用户名和密码
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        criteria.andEqualTo("password",password);
        User rt=usermapper.selectOneByExample(example);
        AssertUtil.isTrue(rt!=null,CommonErrorCode.LOGIN_FAILED);
        return rt;
    }

    @Override
    public void updateInfo(UpdateUserInfoRequest updateUserInfoRequest, SessionData sessionData) {
        Integer id=sessionData.getId();
        User user=User
                .builder()
                .tel(updateUserInfoRequest.getTel())
                .password(updateUserInfoRequest.getPassword())
                .username(updateUserInfoRequest.getUsername())
                .signature(updateUserInfoRequest.getSignature())
                .type(updateUserInfoRequest.getType())
                .age(updateUserInfoRequest.getAge())
                .build();
        if(updateUserInfoRequest.getGender()!=null){
            user.setGender(updateUserInfoRequest.getGender().equals("男")?0:1);
        }
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        //根据手机号，修改不为null的字段
        usermapper.updateByExampleSelective(user,example);
    }

    @Override
    public User queryInfo(String username) {
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        User rt=usermapper.selectOneByExample(example);
        rt.setPassword("");
        return rt;
    }
}
