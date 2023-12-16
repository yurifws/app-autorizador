package br.com.app.autorizador.application.port.in;

import br.com.app.autorizador.application.domain.Transacao;

public interface EfetuaTransacaoUseCase {
	
	void efetuarTransacao(Transacao transacao);

}
