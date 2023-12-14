package br.com.app.autorizador.application.port.in;

import java.util.List;
import java.util.Optional;

import br.com.app.autorizador.application.core.cartoes.validators.ICartaoValidator;
import br.com.app.autorizador.application.domain.Cartao;

public interface ValidaCartaoUseCase {
	
	void processarValidacao(Optional<Cartao> optinalCartao, Cartao cartao, List<ICartaoValidator> validacoesCartao);

}
