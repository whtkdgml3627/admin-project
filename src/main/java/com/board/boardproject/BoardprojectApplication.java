package com.board.boardproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.board.boardproject.**.mappers")
public class BoardprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardprojectApplication.class, args);
	}

}
