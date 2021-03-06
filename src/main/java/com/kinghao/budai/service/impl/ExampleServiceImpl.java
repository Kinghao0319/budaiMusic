package com.kinghao.budai.service.impl;

import com.github.pagehelper.PageInfo;
import com.kinghao.budai.common.CommonErrorCode;
import com.kinghao.budai.common.Page;
import com.kinghao.budai.dto.ExampleDo;
import com.kinghao.budai.dto.request.ExampleRequest;
import com.kinghao.budai.service.ExampleService;
import com.kinghao.budai.util.AssertUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author kinghao
 * @version 2020/7/26 14:20
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
    @Override
    public Page<ExampleDo> doService(ExampleRequest exampleRequest) {
        String arg = exampleRequest.getArg();
        AssertUtil.notNull(arg, CommonErrorCode.ILLEGAL_PARAMETER,"arg cannot be null");
//        Example example=new Example(ExampleClass.class);
//        example.createCriteria()
//                .andEqualTo("propertyName1",propertyValue1)
//                .andEqualTo("propertyName2",propertyValue2);
//        example.setOrderByClause("name asc,id asc");
//        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
//        List<ExampleClass> featureList= exampleMapper.selectByExample(ExampleClass);
        return new Page(new PageInfo(new ArrayList()));

    }
}
