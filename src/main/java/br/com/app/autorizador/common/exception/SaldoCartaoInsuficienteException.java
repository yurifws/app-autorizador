package br.com.app.autorizador.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class SaldoCartaoInsuficienteException extends NegocioException {

	private static final long serialVersionUID = 9139764440809591735L;

	public SaldoCartaoInsuficienteException(String message){
		super(message);
	}
}
