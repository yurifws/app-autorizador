package br.com.app.autorizador.adapters.in.web.cartoes;

import static br.com.app.autorizador.adapters.in.web.cartoes.mapper.CartaoControllerMapper.INSTANCE;
import static br.com.app.autorizador.adapters.in.web.constants.RestConstants.ROTA_CARTOES;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.autorizador.adapters.in.web.cartoes.dto.CartaoDto;
import br.com.app.autorizador.application.port.in.RegistraCartaoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(ROTA_CARTOES)
public class RegistraCartaoController {
	
	private final RegistraCartaoUseCase registraCartaoUseCase;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<CartaoDto> registrar(@RequestBody CartaoDto carDto) {
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(INSTANCE.toCartaoDto(registraCartaoUseCase.registrar(INSTANCE.toCartao(carDto))));
		
	}

}
