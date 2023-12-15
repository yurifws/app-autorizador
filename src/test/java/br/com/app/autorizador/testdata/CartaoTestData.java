package br.com.app.autorizador.testdata;

import java.math.BigDecimal;

import br.com.app.autorizador.application.domain.Cartao;

public class CartaoTestData {
	
	public static Cartao getCartao() {
		return Cartao.builder()
				.numero(1111222233334444l)
				.senha("1234")
				.saldo(BigDecimal.valueOf(500))
				.build();
	}
	
	

}
