package com.kinghao.budai.controller;

import com.github.pagehelper.PageInfo;
import com.kinghao.budai.annotation.Auth;
import com.kinghao.budai.annotation.ReSubmit;
import com.kinghao.budai.dto.request.ExampleRequest;
import com.kinghao.budai.enums.UserType;
import com.kinghao.budai.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author kinghao
 * @version 2020/10/26 13:34
 */
@ApiIgnore
@Api(tags = "示例模块")
@RestController
@Validated
public class ExampleController {

    @Resource(name = "exampleService")
    ExampleService exampleService;

    @Auth(UserType.PERSONAL)
    @ReSubmit(1000)
    @PostMapping("/example")
    @ApiOperation(value = "示例接口")
    public Object list(@Valid @NotNull ExampleRequest exampleRequest) {

        return exampleService.doService(exampleRequest);
    }

}
