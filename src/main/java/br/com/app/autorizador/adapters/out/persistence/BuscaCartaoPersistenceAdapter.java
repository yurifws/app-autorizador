package br.com.app.autorizador.adapters.out.persistence;

import static br.com.app.autorizador.adapters.out.persistence.mapper.CartaoPersistenceMapper.INSTANCE;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.adapters.out.persistence.service.ICartaoService;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.out.BuscaCartaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BuscaCartaoPersistenceAdapter implements BuscaCartaoPort {

	private final ICartaoService service;
	
	@Override
	public Optional<Cartao> buscarPorNumero(Long numero) {
		return service.buscarPorNumero(numero).map(cartaoEntity -> INSTANCE.toCartao(cartaoEntity));

	}

}
