package br.com.app.autorizador.adapters.in.web.transacoes;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_TRANSACOES;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.CARTAO_INEXISTENTE;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SALDO_INSUFICIENTE;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SENHA_INVALIDA;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.in.EfetuaTransacaoUseCase;
import br.com.app.autorizador.common.exception.CartaoInexistenteException;
import br.com.app.autorizador.common.exception.SaldoCartaoInsuficienteException;
import br.com.app.autorizador.common.exception.SenhaCartaoInvalidaException;


@WebMvcTest(EfetuaTransacaoController.class)
class EfetuaTransacaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EfetuaTransacaoUseCase efetuaTransacaoUseCase;

	@Test
	void testEfetuarTransacao() throws Exception {
		
		doNothing().when(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_TRANSACOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getTransacaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isCreated());
		
		verify(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));

	}

	private String getTransacaoJsonMock() {
		return """
				{
					"numeroCartao": "1111222233334444",
					"senhaCartao": "1234",
					"valor": 50.00
				}
				""";
	}
	
	@Test
	void testEfetuarTransacao_CartaoInexistenteException() throws Exception {
		
		doThrow(new CartaoInexistenteException(CARTAO_INEXISTENTE.name())).when(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_TRANSACOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getTransacaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

		verify(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));

	}
	
	@Test
	void testEfetuarTransacao_SenhaCartaoInvalidaException() throws Exception {
		
		doThrow(new SenhaCartaoInvalidaException(SENHA_INVALIDA.name())).when(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_TRANSACOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getTransacaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

		verify(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));

	}
	
	@Test
	void testEfetuarTransacao_SaldoCartaoInsuficienteException() throws Exception {
		
		doThrow(new SaldoCartaoInsuficienteException(SALDO_INSUFICIENTE.name())).when(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_TRANSACOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getTransacaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

		verify(efetuaTransacaoUseCase).efetuarTransacao(any(Transacao.class));

	}

}
