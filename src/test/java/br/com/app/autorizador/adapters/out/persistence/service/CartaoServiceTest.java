package br.com.app.autorizador.adapters.out.persistence.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.repository.CartaoRepository;
import br.com.app.autorizador.testdata.CartaoEntityTestData;

@ExtendWith(SpringExtension.class)
class CartaoServiceTest {
	
	@InjectMocks
	private CartaoService cartaoService;
	
	@Mock
	private CartaoRepository cartaoRepository;

	@Test
	void testSalvar() {
		CartaoEntity cartaoEntity = CartaoEntityTestData.getCartaoEntity();
		cartaoEntity.setNumero(null);
		when(cartaoRepository.save(cartaoEntity)).thenReturn(CartaoEntityTestData.getCartaoEntity());
		
		CartaoEntity response = cartaoService.salvar(cartaoEntity);
		
		verify(cartaoRepository).save(cartaoEntity);
		assertNotNull(response);
	}

	@Test
	void testBuscarPorNumero() {
		Long numero = 1234l;
		when(cartaoRepository.findByNumero(numero)).thenReturn(CartaoEntityTestData.getOptionalCartaoEntity());
		
		Optional<CartaoEntity> response = cartaoService.buscarPorNumero(numero);
		
		verify(cartaoRepository).findByNumero(numero);
		assertNotNull(response.get());
	}

}
