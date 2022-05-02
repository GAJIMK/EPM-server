package com.dartmedia.dmss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dartmedia.dmss")
public class DmssApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmssApplication.class, args);
	}

}
