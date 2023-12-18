package br.com.app.autorizador.application.core.cartoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.core.cartoes.validators.CartaoJaExisteValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.in.BuscaCartaoUseCase;
import br.com.app.autorizador.application.port.in.RegistraCartaoUseCase;
import br.com.app.autorizador.application.port.in.ValidaCartaoUseCase;
import br.com.app.autorizador.application.port.out.RegistraCartaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegistraCartaoService implements RegistraCartaoUseCase {
	
	private final RegistraCartaoPort registraCartaoPort;
	private final BuscaCartaoUseCase buscaCartaoUseCase;
	private final ValidaCartaoUseCase validaCartaoUseCase;
	private final CartaoJaExisteValidator cartaoJaExisteValidator;

	@Override
	public Cartao registrar(Cartao cartao) {
	
		Optional<Cartao> cartaoBuscado = buscaCartaoUseCase.buscarPorNumero(cartao.getNumero());
		
		validaCartaoUseCase.processarValidacao(cartaoBuscado, 
				Transacao.builder().cartao(cartao).build(), 
				List.of(cartaoJaExisteValidator));
		
		return registraCartaoPort.registrar(cartao);
	}

}
