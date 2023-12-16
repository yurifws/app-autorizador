package br.com.app.autorizador.adapters.out.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.service.ICartaoService;
import br.com.app.autorizador.common.exception.NumeroCartaoNaoEncontradoException;
import br.com.app.autorizador.testdata.CartaoEntityTestData;

@ExtendWith(SpringExtension.class)
class ObtemSaldoCartaoPersistenceAdapterTest {


	@InjectMocks
	private ObtemSaldoCartaoPersistenceAdapter obtemSaldoCartaoPersistenceAdapter;

	@Mock
	private ICartaoService service;

	@Test
	void testBuscarPorNumero() {
		Optional<CartaoEntity> optionalCartaoEntity = CartaoEntityTestData.getOptionalCartaoEntity();
		Long numero = optionalCartaoEntity.get().getNumero();
		when(service.buscarPorNumero(numero)).thenReturn(optionalCartaoEntity);
		
		BigDecimal response = obtemSaldoCartaoPersistenceAdapter.buscarPorNumero(numero);
		
		verify(service).buscarPorNumero(numero);
		assertNotNull(response);
		
	}
	
	@Test
	void testBuscarPorNumero_NumeroCartaoNaoEncontradoException() {
		Optional<CartaoEntity> optionalCartaoEntity = Optional.empty();
		Long numero = 9999999999999999l;
		when(service.buscarPorNumero(numero)).thenReturn(optionalCartaoEntity);
		NumeroCartaoNaoEncontradoException exception = assertThrows(NumeroCartaoNaoEncontradoException.class, 
				() -> obtemSaldoCartaoPersistenceAdapter.buscarPorNumero(numero));
		
		assertNotNull(exception);
		
		verify(service).buscarPorNumero(numero);
		
	}

}
