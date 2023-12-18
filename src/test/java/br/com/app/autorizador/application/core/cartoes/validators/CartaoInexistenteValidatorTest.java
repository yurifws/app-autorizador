package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.CARTAO_INEXISTENTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.common.exception.CartaoInexistenteException;
import br.com.app.autorizador.testdata.CartaoTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;

@ExtendWith(SpringExtension.class)
class CartaoInexistenteValidatorTest {

	@InjectMocks
	private CartaoInexistenteValidator cartaoInexistenteValidator;
	
	@Test
	void testValidar() { 
		cartaoInexistenteValidator.validar(CartaoTestData.getOptionalCartao(), TransacaoTestData.getTransacao());
	}

	@Test
	void testValidar_CartaoInexistenteException() { 
		CartaoInexistenteException exception = assertThrows(CartaoInexistenteException.class, 
				() -> cartaoInexistenteValidator.validar(Optional.empty(), TransacaoTestData.getTransacao()));
		
		assertNotNull(exception);
		assertEquals(CARTAO_INEXISTENTE.name(), exception.getMessage());
	}
}
