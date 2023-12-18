package br.com.app.autorizador.testdata;

import java.math.BigDecimal;
import java.util.Optional;

import br.com.app.autorizador.adapters.in.web.transacoes.dto.TransacaoRequestDto;

public class TransacaoRequestDtoTestData {
	
	public static TransacaoRequestDto getTransacaoRequestDto() {
		return new TransacaoRequestDto(1111222233334444l, "1234", BigDecimal.valueOf(50));
	}
	
	public static Optional<TransacaoRequestDto> getOptionalTransacaoRequestDto() {
		return Optional.of(getTransacaoRequestDto());
	}
	
	

}
