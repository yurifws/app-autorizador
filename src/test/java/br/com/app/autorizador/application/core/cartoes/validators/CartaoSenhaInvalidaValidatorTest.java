package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SENHA_INVALIDA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.common.exception.SenhaCartaoInvalidaException;
import br.com.app.autorizador.testdata.CartaoTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;


@ExtendWith(SpringExtension.class)
class CartaoSenhaInvalidaValidatorTest {

	@InjectMocks
	private CartaoSenhaInvalidaValidator cartaoSenhaInvalidaValidator;
	
	@Test
	void testValidar() { 
		cartaoSenhaInvalidaValidator.validar(CartaoTestData.getOptionalCartao(), TransacaoTestData.getTransacao());
	}

	@Test
	void testValidar_SenhaCartaoInvalidaException() { 
		SenhaCartaoInvalidaException exception = assertThrows(SenhaCartaoInvalidaException.class, 
				() -> cartaoSenhaInvalidaValidator.validar(CartaoTestData.getOptionalCartaoSenhaInvalida(), TransacaoTestData.getTransacao()));
		
		assertNotNull(exception);
		assertEquals(SENHA_INVALIDA.name(), exception.getMessage());
	}

}
