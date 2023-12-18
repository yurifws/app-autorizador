package br.com.app.autorizador.application.port.out;

import br.com.app.autorizador.application.domain.Cartao;

public interface RegistraCartaoPort {
	
	Cartao registrar(Cartao cartao);

}
