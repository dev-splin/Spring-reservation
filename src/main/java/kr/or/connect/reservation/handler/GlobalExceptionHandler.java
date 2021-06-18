package kr.or.connect.reservation.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		StringBuilder stringBuilder = new StringBuilder();
		bindingResult.getAllErrors()
			.forEach(objectError -> {
				stringBuilder.append("code : " + objectError.getCode()).append('\n');
				stringBuilder.append("message : " + objectError.getDefaultMessage()).append('\n');
				stringBuilder.append("objectName : " + objectError.getObjectName()).append('\n');
			});
		
		return new ResponseEntity<>(stringBuilder.toString(), headers, HttpStatus.BAD_REQUEST);
	}
}
