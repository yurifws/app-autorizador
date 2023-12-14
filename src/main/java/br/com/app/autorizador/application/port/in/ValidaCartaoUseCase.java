package br.com.app.autorizador.application.port.in;

import java.util.List;

import br.com.app.autorizador.application.core.cartoes.validators.ICartaoValidator;
import br.com.app.autorizador.application.domain.Cartao;

public interface ValidaCartaoUseCase {
	
	void processarValidacao(Cartao cartao, List<ICartaoValidator> validacoesCartao);

}
