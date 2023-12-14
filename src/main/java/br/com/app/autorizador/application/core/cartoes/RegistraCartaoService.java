package br.com.app.autorizador.application.core.cartoes;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.core.cartoes.validators.CartaoJaExisteValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.in.RegistraCartaoUseCase;
import br.com.app.autorizador.application.port.out.RegistraCartaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegistraCartaoService implements RegistraCartaoUseCase {
	
	private final RegistraCartaoPort registraCartaoPort;
	private final ValidaCartaoService validaCartaoService;
	private final CartaoJaExisteValidator cartaoJaExisteValidator;

	@Override
	public Cartao registrar(Cartao cartao) {
	
		validaCartaoService.processarValidacao(cartao, List.of(cartaoJaExisteValidator));
		return registraCartaoPort.registrar(cartao);
	}

}
