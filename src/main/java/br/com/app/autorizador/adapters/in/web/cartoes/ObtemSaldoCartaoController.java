package br.com.app.autorizador.adapters.in.web.cartoes;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.CARTOES_POR_NUMERO_CARTAO;
import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.NUMERO_CARTAO;
import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_CARTOES;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.autorizador.application.port.in.ObtemSaldoCartaoUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@RequestMapping(ROTA_CARTOES)
@Slf4j
public class ObtemSaldoCartaoController {
	
	private final ObtemSaldoCartaoUseCase obtemSaldoCartaoUseCase;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path=CARTOES_POR_NUMERO_CARTAO, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<BigDecimal>  buscarPorNumero(@PathVariable(value = NUMERO_CARTAO) Long numeroCartao) {
		log.info("Obtendo saldo do cartão de número {}", numeroCartao);
		return ResponseEntity.ok(obtemSaldoCartaoUseCase.buscarPorNumero(numeroCartao));
	}
	

}
