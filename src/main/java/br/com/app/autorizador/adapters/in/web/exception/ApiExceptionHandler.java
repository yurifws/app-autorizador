package br.com.app.autorizador.adapters.in.web.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.app.autorizador.common.exception.NumeroCartaoNaoEncontradoException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NumeroCartaoNaoEncontradoException.class)
	public ResponseEntity<Object> numeroCartaoNaoEncontradoException(NumeroCartaoNaoEncontradoException ex, WebRequest request) {
		return super.handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);

	}
	

}
