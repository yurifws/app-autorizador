package br.com.app.autorizador.application.core.cartoes.validators;

import java.util.Optional;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;

public interface ICartaoValidator {
	
	void validar(Optional<Cartao> cartaoBuscado, Transacao transacao);

}
