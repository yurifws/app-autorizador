package br.com.app.autorizador.adapters.out.persistence;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.service.ICartaoService;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.out.EfetuaTransacaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EfetuaTransacaoPersistenceAdapter implements EfetuaTransacaoPort {
	
	private final ICartaoService service;
	
	@Override
	public void efetuarTransacao(Transacao transacao, Long numero) {
		
		service.buscarPorNumero(numero).ifPresent( selecionado -> {
			debitaSaldoCartao(transacao, selecionado);
			service.salvar(selecionado);
		});
	}

	private void debitaSaldoCartao(Transacao transacao, CartaoEntity cartaoEntity) {
		cartaoEntity.setSaldo(cartaoEntity.getSaldo().subtract(transacao.getValor()));
	}

}
