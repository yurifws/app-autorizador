package br.com.app.autorizador.common.exception;

public class NegocioException extends RuntimeException  {

	private static final long serialVersionUID = -1102429965366484723L;

	public NegocioException(String message){
		super(message);
	}
}
