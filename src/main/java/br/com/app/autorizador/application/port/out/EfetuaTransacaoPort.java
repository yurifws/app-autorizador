package br.com.app.autorizador.application.port.out;

import br.com.app.autorizador.application.domain.Transacao;

public interface EfetuaTransacaoPort {
	
	void efetuarTransacao(Transacao transacao, Long numero);

}
