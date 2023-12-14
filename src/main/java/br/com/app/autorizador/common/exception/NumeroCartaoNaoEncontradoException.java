package br.com.app.autorizador.common.exception;

public class NumeroCartaoNaoEncontradoException extends NegocioException {

	private static final long serialVersionUID = 8147278403558715169L;

	public NumeroCartaoNaoEncontradoException(String message){
		super(message);
	}
}
