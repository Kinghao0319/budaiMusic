package com.kinghao.budai.service;

import com.kinghao.budai.common.Page;
import com.kinghao.budai.dto.ExampleDo;
import com.kinghao.budai.dto.request.ExampleRequest;

/**
 * @author kinghao
 * @version 2020/7/26 13:42
 */
public interface ExampleService {

    Page<ExampleDo> doService(ExampleRequest exampleRequest);

}
