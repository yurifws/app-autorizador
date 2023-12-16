package br.com.app.autorizador.adapters.in.web.transacoes;

import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_TRANSACOES;
import static br.com.app.autorizador.adapters.in.web.transacoes.mapper.TransacaoControllerMapper.INSTANCE;
import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.OK;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.autorizador.adapters.in.web.transacoes.dto.TransacaoRequestDto;
import br.com.app.autorizador.application.port.in.EfetuaTransacaoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(ROTA_TRANSACOES)
public class EfetuaTransacaoController {

	private final EfetuaTransacaoUseCase efetuaTransacaoUseCase;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> efetuarTransacao(@RequestBody TransacaoRequestDto transacaoRequestDto) {

		efetuaTransacaoUseCase.efetuarTransacao(INSTANCE.toTransacao(transacaoRequestDto));
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(OK.name());

	}
}
