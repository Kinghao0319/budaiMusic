package com.kinghao.budai.service;

import com.kinghao.budai.dto.SessionData;
import com.kinghao.budai.dto.request.LoginRequest;
import com.kinghao.budai.dto.request.RegisterRequest;
import com.kinghao.budai.dto.request.UpdateUserInfoRequest;
import com.kinghao.budai.entity.User;

/**
 * @Author Kinghao
 * @Date 2020/10/21 16:37
 * @Version 1.0
 */
public interface UserService {
    void userRegister(RegisterRequest registerRequest);

    User userLogin(LoginRequest loginRequest);

    void updateInfo(UpdateUserInfoRequest updateUserInfoRequest, SessionData sessionData);

    User queryInfo(String username);
}
