package com.kinghao.budai.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 接口文档，生产时关闭
 * @author kinghao on 2020-02-27
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("${dev.enable:true}")//当enable为true时才选择加载该配置类
public class Swagger2Config {

    @Bean
    public Docket createTestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kinghao.budai.controller"))//设定扫描范围
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact=new Contact("Kinghao","","845546765@qq.com");
        return new ApiInfoBuilder()
                .title("Budai API Documentation")
                .description("布袋音乐接口文档")
                .contact(contact)
                .termsOfServiceUrl("https://www.cnblogs.com/Kinghao0319")//联系方式
                .version("1.0")
                .build();
    }
}
