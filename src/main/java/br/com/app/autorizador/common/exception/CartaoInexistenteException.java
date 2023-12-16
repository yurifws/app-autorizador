package br.com.app.autorizador.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class CartaoInexistenteException extends NegocioException {

	private static final long serialVersionUID = -6553656167034584131L;

	public CartaoInexistenteException(String message){
		super(message);
	}
}
