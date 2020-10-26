package com.kinghao.budai.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.kinghao.budai.common.serializer.EnumSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
* 统一返回实体
* @author Kinghao on 2020-02-27
*/
//需要对response做注释就单独添加对应的返回类，用 @ApiModelProperty
@Data
public class Result implements Serializable {


   private Integer code;

   private String msg;

   private Object data;

   @JSONField(serializeUsing = EnumSerializer.class)
   private CommonErrorCode commonErrorCode;

   public static Result success(Object data) {
       return success("操作成功", data);
   }

   public static Result success(String mess, Object data) {
           Result m = new Result();
           m.setCode(0);
           m.setData(data);
           m.setMsg(mess);
           return m;
   }

   public static Result fail(String mess) {
       return fail(mess, null);
   }

   public static Result fail(String mess, Object data) {
       Result m = new Result();
       m.setCode(-1);
       m.setData(data);
       m.setMsg(mess);

       return m;
   }

   public static Result result(CommonErrorCode commonErrorCode, Object data) {
       Result m = new Result();
       m.setCode(-1);
       m.setData(data);
       m.setCommonErrorCode(commonErrorCode);

       return m;
   }

   public static Result result(CommonErrorCode commonErrorCode) {
       return result(commonErrorCode,null);
   }
}