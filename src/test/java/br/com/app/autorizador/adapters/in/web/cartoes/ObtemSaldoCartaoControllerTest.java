package br.com.app.autorizador.adapters.in.web.cartoes;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.CARTOES_POR_NUMERO_CARTAO;
import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_CARTOES;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.app.autorizador.application.port.in.ObtemSaldoCartaoUseCase;
import br.com.app.autorizador.common.exception.NumeroCartaoNaoEncontradoException;
import br.com.app.autorizador.testdata.CartaoTestData;


@WebMvcTest(ObtemSaldoCartaoController.class)
class ObtemSaldoCartaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ObtemSaldoCartaoUseCase obtemSaldoCartaoUseCase;

	@Test
	void testBuscarPorNumero() throws Exception {

		Long numero = 1111222233334444l;
		BigDecimal saldoCartao = CartaoTestData.getCartao().getSaldo();
		
		when(obtemSaldoCartaoUseCase.buscarPorNumero(numero)).thenReturn(saldoCartao);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get(ROTA_CARTOES + CARTOES_POR_NUMERO_CARTAO, numero)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isOk());
		
		verify(obtemSaldoCartaoUseCase).buscarPorNumero(numero);
	}

	@Test
	void testBuscarPorNumero_NumeroCartaoNaoEncontradoException() throws Exception {

		Long numero = 1111222233334444l;
		
		when(obtemSaldoCartaoUseCase.buscarPorNumero(numero)).thenThrow(NumeroCartaoNaoEncontradoException.class);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get(ROTA_CARTOES + CARTOES_POR_NUMERO_CARTAO, numero)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(MockMvcResultMatchers.status().isNotFound());
		
		verify(obtemSaldoCartaoUseCase).buscarPorNumero(numero);
	}
}
