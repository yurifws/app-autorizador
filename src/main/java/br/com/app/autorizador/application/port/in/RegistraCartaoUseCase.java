package br.com.app.autorizador.application.port.in;

import br.com.app.autorizador.application.domain.Cartao;

public interface RegistraCartaoUseCase {
	
	Cartao registrar(Cartao cartao);

}
