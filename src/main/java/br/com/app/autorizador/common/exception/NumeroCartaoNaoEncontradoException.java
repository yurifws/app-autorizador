package br.com.app.autorizador.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NumeroCartaoNaoEncontradoException extends NegocioException {

	private static final long serialVersionUID = 8147278403558715169L;

	public NumeroCartaoNaoEncontradoException(String message){
		super(message);
	}
}
