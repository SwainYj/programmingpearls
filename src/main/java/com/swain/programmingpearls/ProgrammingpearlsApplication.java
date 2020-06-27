package com.swain.programmingpearls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
})
@MapperScan({"com.swain.programmingpearls.dao.mapper"})
public class ProgrammingpearlsApplication {

    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(ProgrammingpearlsApplication.class, args);
    }

}
