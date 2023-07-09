package org.zerock.breply.controller.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.zerock.breply.controller.ReplyController.DataNotFoundException;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class CustomRestControllerAdvice {
	
	// 발생한 예외의 종류
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	// 상태코드 전달
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, String> mistype(MethodArgumentTypeMismatchException ex){

		log.info("MethodArgumentTypeMismatchException");

		return Map.of("Error", "전달한 데이터 타입 문제");

	}

	// ReplyController에서 직접 커스텀해서 만든 예외
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> dataNotFound(DataNotFoundException ex){
		return Map.of("Error", ex.getMessage());
	}

}