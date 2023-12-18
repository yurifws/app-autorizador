package br.com.app.autorizador.adapters.in.web.transacoes.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import br.com.app.autorizador.adapters.in.web.transacoes.dto.TransacaoRequestDto;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.testdata.TransacaoRequestDtoTestData;

class TransacaoControllerMapperTest {

	TransacaoControllerMapper mapper = TransacaoControllerMapper.INSTANCE;

	@Test
	void testToTransacao() {
		
		TransacaoRequestDto transacaoDto = TransacaoRequestDtoTestData.getTransacaoRequestDto();
		Transacao transacao = mapper.toTransacao(transacaoDto);
		
		assertNotNull(transacao);
		assertEquals(transacaoDto.numeroCartao(), transacao.getCartao().getNumero());
		assertEquals(transacaoDto.senhaCartao(), transacao.getCartao().getSenha());
		assertEquals(transacaoDto.valor(), transacao.getValor());
	}

}
