package br.com.app.autorizador.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class SenhaCartaoInvalidaException extends NegocioException {

	private static final long serialVersionUID = 3248598556306979871L;

	public SenhaCartaoInvalidaException(String message){
		super(message);
	}
}
