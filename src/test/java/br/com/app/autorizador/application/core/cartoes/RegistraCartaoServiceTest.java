package br.com.app.autorizador.application.core.cartoes;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.app.autorizador.application.core.cartoes.validators.CartaoJaExisteValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.in.BuscaCartaoUseCase;
import br.com.app.autorizador.application.port.in.ValidaCartaoUseCase;
import br.com.app.autorizador.application.port.out.RegistraCartaoPort;
import br.com.app.autorizador.testdata.CartaoTestData;

@ExtendWith(SpringExtension.class)
class RegistraCartaoServiceTest {
	
	
	@InjectMocks
	private RegistraCartaoService service;
	
	@Mock
	private RegistraCartaoPort registraCartaoPort;

	@Mock
	private BuscaCartaoUseCase buscaCartaoUseCase;
	
	@Mock
	private ValidaCartaoUseCase validaCartaoUseCase;
	
	@Mock
	private CartaoJaExisteValidator cartaoJaExisteValidator;
	
	@Captor
	private ArgumentCaptor<Transacao> argumentCaptorTransacaoEntity;
	

	@Test
	void testRegistrar() {
		

		Cartao cartao = CartaoTestData.getCartao();
		Optional<Cartao> cartaoBuscado = CartaoTestData.getOptionalCartao();
		when(buscaCartaoUseCase.buscarPorNumero(cartao.getNumero())).thenReturn(cartaoBuscado);
		doNothing().when(validaCartaoUseCase).processarValidacao(cartaoBuscado, argumentCaptorTransacaoEntity.capture(), List.of(cartaoJaExisteValidator));
		when(registraCartaoPort.registrar(cartao)).thenReturn(cartao);
		
		Cartao response = service.registrar(cartao);
		
		verify(buscaCartaoUseCase).buscarPorNumero(cartao.getNumero());
		verify(validaCartaoUseCase).processarValidacao(cartaoBuscado, argumentCaptorTransacaoEntity.getValue(), List.of(cartaoJaExisteValidator));
		verify(registraCartaoPort).registrar(cartao);
		assertNotNull(response);
		
	}
	

}
