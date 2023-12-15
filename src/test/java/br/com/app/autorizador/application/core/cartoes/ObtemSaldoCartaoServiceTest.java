package br.com.app.autorizador.application.core.cartoes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.application.port.out.ObtemSaldoCartaoPort;
import br.com.app.autorizador.testdata.CartaoTestData;

@ExtendWith(SpringExtension.class)
class ObtemSaldoCartaoServiceTest {
	
	@InjectMocks
	private ObtemSaldoCartaoService service;
	
	@Mock
	private ObtemSaldoCartaoPort port;

	@Test
	void testBuscarPorNumero() {

		Long numero = 1111222233334444l;
		when(port.buscarPorNumero(numero)).thenReturn(CartaoTestData.getCartao().getSaldo());
		
		BigDecimal response = service.buscarPorNumero(numero);
		
		verify(port).buscarPorNumero(numero);
		assertNotNull(response);
	}

}
