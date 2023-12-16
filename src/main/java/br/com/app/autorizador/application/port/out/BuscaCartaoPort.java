package br.com.app.autorizador.application.port.out;

import java.util.Optional;

import br.com.app.autorizador.application.domain.Cartao;

public interface BuscaCartaoPort {
	
	Optional<Cartao> buscarPorNumero(Long numero);

}
