package br.com.app.autorizador.application.port.in;

import java.util.List;
import java.util.Optional;

import br.com.app.autorizador.application.core.cartoes.validators.ICartaoValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;

public interface ValidaCartaoUseCase {

	void processarValidacao(Optional<Cartao> optinalCartao, Transacao transacao, List<ICartaoValidator> validacoesCartao);

}
