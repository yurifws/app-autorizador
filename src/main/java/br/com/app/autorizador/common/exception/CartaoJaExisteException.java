package br.com.app.autorizador.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.app.autorizador.adapters.in.web.cartoes.dto.CartaoDto;
import lombok.Getter;

@Getter
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class CartaoJaExisteException extends NegocioException {

	private static final long serialVersionUID = -5490870689818423785L;
	
	private final CartaoDto cartaoDto;

	public CartaoJaExisteException(String message, CartaoDto cartaoDto){
		super(message);
		this.cartaoDto = cartaoDto;
	}
}
