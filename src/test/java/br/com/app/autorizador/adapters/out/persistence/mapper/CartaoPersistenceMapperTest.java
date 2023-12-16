package br.com.app.autorizador.adapters.out.persistence.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.testdata.CartaoEntityTestData;
import br.com.app.autorizador.testdata.CartaoTestData;

class CartaoPersistenceMapperTest {

	CartaoPersistenceMapper mapper = CartaoPersistenceMapper.INSTANCE;

	@Test
	void testToCartaoEntity() {
		Cartao cartao = CartaoTestData.getCartao();

		CartaoEntity cartaoEntity = mapper.toCartaoEntity(cartao);

		assertNotNull(cartaoEntity);
		assertEquals(cartao.getNumero(), cartaoEntity.getNumero());
		assertEquals(cartao.getSenha(), cartaoEntity.getSenha());
		assertEquals(cartao.getSaldo(), cartaoEntity.getSaldo());

		
	}
	
	@Test
	void testToCartao() {
		CartaoEntity cartaoEntity = CartaoEntityTestData.getCartaoEntity();

		Cartao cartao = mapper.toCartao(cartaoEntity);

		assertNotNull(cartao);
		assertEquals(cartaoEntity.getNumero(), cartao.getNumero());
		assertEquals(cartaoEntity.getSenha(), cartao.getSenha());
		assertEquals(cartaoEntity.getSaldo(), cartao.getSaldo());
		
	}

}
