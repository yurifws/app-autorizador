package br.com.app.autorizador.application.core.transacoes;

import static org.mockito.ArgumentMatchers.eq;
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

import br.com.app.autorizador.application.core.cartoes.validators.CartaoInexistenteValidator;
import br.com.app.autorizador.application.core.cartoes.validators.CartaoSaldoInsuficienteValidator;
import br.com.app.autorizador.application.core.cartoes.validators.CartaoSenhaInvalidaValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.in.BuscaCartaoUseCase;
import br.com.app.autorizador.application.port.in.ValidaCartaoUseCase;
import br.com.app.autorizador.application.port.out.EfetuaTransacaoPort;
import br.com.app.autorizador.testdata.CartaoTestData;
import br.com.app.autorizador.testdata.TransacaoTestData;

@ExtendWith(SpringExtension.class)
class EfetuaTransacaoServiceTest {
	
	@InjectMocks
	private EfetuaTransacaoService efetuaTransacaoService;
	
	@Mock
	private BuscaCartaoUseCase buscaCartaoUseCase;

	@Mock
	private ValidaCartaoUseCase validaCartaoUseCase;
	
	@Mock
	private CartaoInexistenteValidator cartaoInexistenteValidator;
	
	@Mock
	private CartaoSenhaInvalidaValidator cartaoSenhaInvalidaValidator;
	
	@Mock
	private CartaoSaldoInsuficienteValidator cartaoSaldoInsuficienteValidator;
	
	@Mock
	private EfetuaTransacaoPort efetuaTransacaoPort;
	
	@Captor
	private ArgumentCaptor<Transacao> argumentCaptorTransacaoEntity;

	@Test
	void testEfetuarTransacao() {
		Transacao transacao = TransacaoTestData.getTransacao();
		Long numero = transacao.getCartao().getNumero();
		Optional<Cartao> cartaoBuscado = CartaoTestData.getOptionalCartao();
		when(buscaCartaoUseCase.buscarPorNumero(numero)).thenReturn(cartaoBuscado);
		doNothing().when(validaCartaoUseCase).processarValidacao(eq(cartaoBuscado), argumentCaptorTransacaoEntity.capture(),
				eq(List.of(cartaoInexistenteValidator, cartaoSenhaInvalidaValidator, cartaoSaldoInsuficienteValidator)));

		doNothing().when(efetuaTransacaoPort).efetuarTransacao(transacao, numero);
		
		efetuaTransacaoService.efetuarTransacao(transacao);
		
		verify(buscaCartaoUseCase).buscarPorNumero(numero);
		verify(validaCartaoUseCase).processarValidacao(cartaoBuscado, argumentCaptorTransacaoEntity.getValue(),
				List.of(cartaoInexistenteValidator, cartaoSenhaInvalidaValidator, cartaoSaldoInsuficienteValidator));
		verify(efetuaTransacaoPort).efetuarTransacao(transacao, numero);
		
	}

}
