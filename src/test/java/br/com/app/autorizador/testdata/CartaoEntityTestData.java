package br.com.app.autorizador.testdata;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;

public class CartaoEntityTestData {

	public static CartaoEntity getCartaoEntity() {
		return CartaoEntity.builder()
				.numero(1111222233334444l)
				.senha("1234")
				.saldo(BigDecimal.valueOf(500))
				.build();
	}
	
	public static Optional<CartaoEntity> getOptionalCartaoEntity() {
		return Optional.of(getCartaoEntity());
	}

}
