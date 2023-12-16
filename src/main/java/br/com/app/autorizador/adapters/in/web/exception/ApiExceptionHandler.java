package br.com.app.autorizador.adapters.in.web.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.app.autorizador.common.exception.CartaoInexistenteException;
import br.com.app.autorizador.common.exception.CartaoJaExisteException;
import br.com.app.autorizador.common.exception.NumeroCartaoNaoEncontradoException;
import br.com.app.autorizador.common.exception.SaldoCartaoInsuficienteException;
import br.com.app.autorizador.common.exception.SenhaCartaoInvalidaException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NumeroCartaoNaoEncontradoException.class)
	public ResponseEntity<Object> numeroCartaoNaoEncontradoException(NumeroCartaoNaoEncontradoException ex, WebRequest request) {
		return super.handleExceptionInternal(ex, null, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(CartaoJaExisteException.class)
	public ResponseEntity<Object> cartaoJaExisteException(CartaoJaExisteException ex, WebRequest request) {
		return super.handleExceptionInternal(ex, ex.getCartaoDto(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
	
	@ExceptionHandler(CartaoInexistenteException.class)
	public ResponseEntity<Object> cartaoInexistenteException(CartaoInexistenteException ex, WebRequest request) {
		return super.handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
	
	@ExceptionHandler(SenhaCartaoInvalidaException.class)
	public ResponseEntity<Object> senhaCartaoInvalidaException(SenhaCartaoInvalidaException ex, WebRequest request) {
		return super.handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
	
	@ExceptionHandler(SaldoCartaoInsuficienteException.class)
	public ResponseEntity<Object> saldoCartaoInsuficienteException(SaldoCartaoInsuficienteException ex, WebRequest request) {
		return super.handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
	}
	

}
