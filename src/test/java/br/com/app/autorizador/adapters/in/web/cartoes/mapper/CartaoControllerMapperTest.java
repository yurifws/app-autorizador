package br.com.app.autorizador.adapters.in.web.cartoes.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.app.autorizador.adapters.in.web.cartoes.dto.CartaoDto;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.testdata.CartaoDtoTestData;
import br.com.app.autorizador.testdata.CartaoTestData;

class CartaoControllerMapperTest {

	CartaoControllerMapper mapper = CartaoControllerMapper.INSTANCE;

	@Test
	void testToCartao() {
		
		CartaoDto cartaoDto = CartaoDtoTestData.getCartaoDto();
		Cartao cartao = mapper.toCartao(cartaoDto);
		
		assertNotNull(cartao);
		assertEquals(cartaoDto.numeroCartao(), cartao.getNumero());
		assertEquals(cartaoDto.senha(), cartao.getSenha());
	}
	
	@Test
	void testToCartaoDto() {
		
		Cartao cartao = CartaoTestData.getCartao();
		CartaoDto cartaoDto = mapper.toCartaoDto(cartao);
		
		assertNotNull(cartaoDto);
		assertEquals(cartaoDto.numeroCartao(), cartao.getNumero());
		assertEquals(cartaoDto.senha(), cartao.getSenha());
	}

}
