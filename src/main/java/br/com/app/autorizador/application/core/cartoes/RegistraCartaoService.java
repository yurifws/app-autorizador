package br.com.app.autorizador.application.core.cartoes;

import java.util.List;
import java.util.Optional;

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
	private final BuscaCartaoService buscaCartaoService;
	private final ValidaCartaoService validaCartaoService;
	private final CartaoJaExisteValidator cartaoJaExisteValidator;

	@Override
	public Cartao registrar(Cartao cartao) {
	
		Optional<Cartao> cartaoBuscado = buscaCartaoService.buscarPorNumero(cartao.getNumero());
		
		validaCartaoService.processarValidacao(cartaoBuscado, cartao, List.of(cartaoJaExisteValidator));
		
		return registraCartaoPort.registrar(cartao);
	}

}
