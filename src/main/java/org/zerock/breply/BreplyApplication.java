package org.zerock.breply;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.zerock.breply.**.mappers")
public class BreplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreplyApplication.class, args);
	}

}
