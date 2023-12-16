package br.com.app.autorizador.adapters.out.persistence;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.service.ICartaoService;
import br.com.app.autorizador.application.port.out.ObtemSaldoCartaoPort;
import br.com.app.autorizador.common.exception.NumeroCartaoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ObtemSaldoCartaoPersistenceAdapter implements ObtemSaldoCartaoPort {

	private final ICartaoService service;
	
	@Override
	public BigDecimal buscarPorNumero(Long numero) {
		return service.buscarPorNumero(numero).map(CartaoEntity::getSaldo).orElseThrow(() -> new NumeroCartaoNaoEncontradoException(null));
	}

}
