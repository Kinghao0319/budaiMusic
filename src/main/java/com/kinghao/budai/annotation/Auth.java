package com.kinghao.budai.annotation;

import com.kinghao.budai.enums.UserType;

import java.lang.annotation.*;

/**
 * @Author Kinghao
 * @Date 2020/10/5 12:08
 * @Version 1.0
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
    UserType value() default UserType.PERSONAL;
}
