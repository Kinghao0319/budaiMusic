package com.kinghao.budai.util;

import com.kinghao.budai.common.CommonConstants;
import com.kinghao.budai.common.CommonErrorCode;
import com.kinghao.budai.dto.SessionData;
import com.kinghao.budai.enums.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @author kinghao
 * @version 2020/8/1 18:38
 */
@Component
public class SessionUtil {

    @Autowired
    HttpSession session;

    public SessionData getSessionData(){
         return (SessionData)session.getAttribute(CommonConstants.SESSION);
    }

    public void putSessionData(SessionData sessionData){
        session.setAttribute(CommonConstants.SESSION,sessionData);
        session.setMaxInactiveInterval(3600);
    }

    public void invalidate(){
        session.invalidate();
    }

}
