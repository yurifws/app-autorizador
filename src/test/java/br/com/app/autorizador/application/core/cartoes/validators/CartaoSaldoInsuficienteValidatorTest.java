package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SALDO_INSUFICIENTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.common.exception.SaldoCartaoInsuficienteException;
import br.com.app.autorizador.testdata.CartaoTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;

@ExtendWith(SpringExtension.class)
class CartaoSaldoInsuficienteValidatorTest {

	@InjectMocks
	private CartaoSaldoInsuficienteValidator cartaoSaldoInsuficienteValidator;
	
	@Test
	void testValidar() { 
		cartaoSaldoInsuficienteValidator.validar(CartaoTestData.getOptionalCartao(), TransacaoTestData.getTransacao());
	}

	@Test
	void testValidar_SaldoCartaoInsuficienteException() { 
		SaldoCartaoInsuficienteException exception = assertThrows(SaldoCartaoInsuficienteException.class, 
				() -> cartaoSaldoInsuficienteValidator.validar(CartaoTestData.getOptionalCartao(), TransacaoTestData.getTransacaoMaiorQueSaldo()));
		
		assertNotNull(exception);
		assertEquals(SALDO_INSUFICIENTE.name(), exception.getMessage());
	}

}
