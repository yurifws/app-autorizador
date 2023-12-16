package br.com.app.autorizador.testdata;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.app.autorizador.application.domain.Transacao;

public class TransacaoTestData {
	
	public static Transacao getTransacao() {
		return Transacao.builder()
				.cartao(CartaoTestData.getCartao())
				.valor(BigDecimal.valueOf(50))
				.build();
	}
	
	public static Optional<Transacao> getOptionalTransacao() {
		return Optional.of(getTransacao());
	}
	
	

}
