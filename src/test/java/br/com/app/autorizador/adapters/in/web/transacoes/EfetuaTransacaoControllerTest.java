package br.com.app.autorizador.adapters.in.web.transacoes;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_TRANSACOES;
import static org.mockito.Mockito.doNothing;

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
import br.com.app.autorizador.testdata.TransacaoTestData;


@WebMvcTest(EfetuaTransacaoController.class)
class EfetuaTransacaoControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EfetuaTransacaoUseCase efetuaTransacaoUseCase;

	@Test
	void testEfetuarTransacao() throws Exception {

		Transacao transacao = TransacaoTestData.getTransacao();
		
		doNothing().when(efetuaTransacaoUseCase).efetuarTransacao(transacao);
		
		mockMvc.perform(MockMvcRequestBuilders.post(ROTA_TRANSACOES)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(getTransacaoJsonMock()))
		.andExpect(MockMvcResultMatchers.status().isCreated());

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

}
