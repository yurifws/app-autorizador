package br.com.app.autorizador.application.core.cartoes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.out.BuscaCartaoPort;
import br.com.app.autorizador.testdata.CartaoTestData;

@ExtendWith(SpringExtension.class)
class BuscaCartaoServiceTest {
	
	@InjectMocks
	private BuscaCartaoService buscaCartaoService;
	
	@Mock
	private BuscaCartaoPort buscaCartaoPort;

	@Test
	void testBuscarPorNumero() {
		
		Long numero = 1111222233334444l;
		when(buscaCartaoPort.buscarPorNumero(numero)).thenReturn(CartaoTestData.getOptionalCartao());
		
		Optional<Cartao> response = buscaCartaoService.buscarPorNumero(numero);
		
		verify(buscaCartaoPort).buscarPorNumero(numero);
		assertNotNull(response);
	}

}
