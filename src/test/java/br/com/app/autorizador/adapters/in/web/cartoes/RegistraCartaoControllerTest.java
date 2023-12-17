package br.com.app.autorizador.adapters.in.web.cartoes;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_CARTOES;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.in.RegistraCartaoUseCase;
import br.com.app.autorizador.common.exception.CartaoJaExisteException;
import br.com.app.autorizador.testdata.CartaoTestData;

@WebMvcTest(RegistraCartaoController.class)
class RegistraCartaoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RegistraCartaoUseCase registraCartaoUseCase;

	@Test
	void testRegistrar() throws Exception {
		
		Cartao cartao = CartaoTestData.getCartaoNovoRegistrar();
		
		when(registraCartaoUseCase.registrar(any(Cartao.class))).thenReturn(cartao);
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_CARTOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getCartaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isCreated());
		
		verify(registraCartaoUseCase).registrar(any(Cartao.class));
	}

	private String getCartaoJsonMock() {
		return """
				{
			      "senha": "1234",
			      "numeroCartao": "1111222233334444"
				} 
				""";
	}
	
	@Test
	void testRegistrar_CartaoJaExisteException() throws Exception {

		when(registraCartaoUseCase.registrar(any(Cartao.class))).thenThrow(CartaoJaExisteException.class);
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_CARTOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getCartaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());

		verify(registraCartaoUseCase).registrar(any(Cartao.class));
	}
	
}
