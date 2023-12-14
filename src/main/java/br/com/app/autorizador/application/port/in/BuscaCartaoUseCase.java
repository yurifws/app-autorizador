package br.com.app.autorizador.application.port.in;

import java.util.Optional;

import br.com.app.autorizador.application.domain.Cartao;

public interface BuscaCartaoUseCase {

	Optional<Cartao> buscarPorNumero(Long numero);

}
