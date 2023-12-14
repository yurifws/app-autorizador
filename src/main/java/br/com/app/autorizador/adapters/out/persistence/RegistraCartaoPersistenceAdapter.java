package br.com.app.autorizador.adapters.out.persistence;

import static br.com.app.autorizador.adapters.out.persistence.mapper.CartaoPersistenceMapper.INSTANCE;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.adapters.out.persistence.service.ICartaoService;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.out.RegistraCartaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RegistraCartaoPersistenceAdapter implements RegistraCartaoPort {
	
	private final ICartaoService service;

	@Override
	public Cartao registrar(Cartao cartao) {
		return INSTANCE.toCartao(service.salvar(INSTANCE.toCartaoEntity(cartao)));
	}

}
