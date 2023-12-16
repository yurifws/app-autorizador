package br.com.app.autorizador.application.core.cartoes.validators;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.common.exception.CartaoJaExisteException;
import br.com.app.autorizador.testdata.CartaoTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;

@ExtendWith(SpringExtension.class)
class CartaoJaExisteValidatorTest {
	
	@InjectMocks
	private CartaoJaExisteValidator cartaoJaExisteValidator;
	
	
	@Test
	void testValidar() { 
		cartaoJaExisteValidator.validar(Optional.empty(), TransacaoTestData.getTransacao());
	}

	@Test
	void testValidar_CartaoJaExisteException() { 
		CartaoJaExisteException exception = assertThrows(CartaoJaExisteException.class, 
				() -> cartaoJaExisteValidator.validar(CartaoTestData.getOptionalCartao(), TransacaoTestData.getTransacao()));
		
		assertNotNull(exception);
	}

}
