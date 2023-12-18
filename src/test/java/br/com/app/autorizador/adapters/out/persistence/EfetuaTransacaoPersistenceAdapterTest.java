package br.com.app.autorizador.adapters.out.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.testdata.CartaoEntityTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;

@ExtendWith(SpringExtension.class)
class EfetuaTransacaoPersistenceAdapterTest {
	
	@InjectMocks
	private EfetuaTransacaoPersistenceAdapter efetuaTransacaoPersistenceAdapter;

	@Mock
	private ICartaoService service;

	@Test
	void testEfetuarTransacao() {
		Optional<CartaoEntity> optionalCartaoEntity = CartaoEntityTestData.getOptionalCartaoEntity();
		CartaoEntity cartaoEntity = optionalCartaoEntity.get();
		Long numero = cartaoEntity.getNumero();

		Transacao transacao = TransacaoTestData.getTransacao();
		when(service.buscarPorNumero(numero)).thenReturn(optionalCartaoEntity);
		
		efetuaTransacaoPersistenceAdapter.efetuarTransacao(transacao, numero);
		
		verify(service).buscarPorNumero(numero);
		
		assertEquals(BigDecimal.valueOf(450), cartaoEntity.getSaldo());
	}
	
	

}
