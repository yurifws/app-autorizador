package br.com.app.autorizador.application.core.cartoes;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.in.BuscaCartaoUseCase;
import br.com.app.autorizador.application.port.out.BuscaCartaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BuscaCartaoService implements BuscaCartaoUseCase {
	
	private final BuscaCartaoPort buscaCartaoPort;

	@Override
	public Optional<Cartao> buscarPorNumero(Long numero) {
		return buscaCartaoPort.buscarPorNumero(numero);
	}

}
