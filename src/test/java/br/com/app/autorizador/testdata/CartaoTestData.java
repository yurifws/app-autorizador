package br.com.app.autorizador.testdata;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.app.autorizador.application.domain.Cartao;

public class CartaoTestData {
	
	public static Cartao getCartao() {
		return Cartao.builder()
				.numero(1111222233334444l)
				.senha("1234")
				.saldo(BigDecimal.valueOf(500))
				.build();
	}
	
	public static Optional<Cartao> getOptionalCartao() {
		return Optional.of(getCartao());
	}
	
	public static Cartao getCartaoNovoRegistrar() {
		return Cartao.builder()
				.numero(1111222233334444l)
				.senha("1234")
				.build();
	}
	
	public static Cartao getCartaoSenhaInvalida() {
		return Cartao.builder()
				.numero(1111222233335555l)
				.senha("9090")
				.saldo(BigDecimal.valueOf(500))
				.build();
	}
	
	public static Optional<Cartao> getOptionalCartaoSenhaInvalida() {
		return Optional.of(getCartaoSenhaInvalida());
	}
	
	

}
