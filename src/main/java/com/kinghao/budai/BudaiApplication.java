package com.kinghao.budai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.kinghao.budai.mapper")
public class BudaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BudaiApplication.class, args);
    }

}
