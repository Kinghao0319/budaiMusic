package com.kinghao.budai.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

/**
 * @Author Kinghao
 * @Date 2020/8/3 20:36
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;

    private String tel;

    private String password;

    private String username;

    private String type;

    private Timestamp create_time;

    private Integer gender;

    private Integer age;

    private String signature;

    /**
     * entity内不做参数校验；
     * entity不放入request；
     * model的字段属性可以与entity不一致，model是用于前端页面数据展示的，而entity则是与数据库进行交互做存储用途。
     */
}
