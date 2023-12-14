package br.com.app.autorizador.application.core.cartoes.validators;

import java.util.Optional;

import br.com.app.autorizador.application.domain.Cartao;

public interface ICartaoValidator {
	
	void validar(Optional<Cartao> cartaoBuscado, Cartao cartao);

}
