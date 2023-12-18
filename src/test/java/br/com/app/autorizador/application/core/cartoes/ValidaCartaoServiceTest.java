package br.com.app.autorizador.application.core.cartoes;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.application.core.cartoes.validators.CartaoJaExisteValidator;
import br.com.app.autorizador.testdata.CartaoTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;

@ExtendWith(SpringExtension.class)
class ValidaCartaoServiceTest {
	
	@InjectMocks
	private ValidaCartaoService validaCartaoService;
	
	@Mock
	private CartaoJaExisteValidator cartaoJaExisteValidator;

	@Test
	void testProcessarValidacao() {
		validaCartaoService.processarValidacao(CartaoTestData.getOptionalCartao(), TransacaoTestData.getTransacao(), List.of(cartaoJaExisteValidator));
	}

}
