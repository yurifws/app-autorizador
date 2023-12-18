package br.com.app.autorizador.adapters.out.persistence.service;

import java.util.Optional;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;

public interface ICartaoService {
	
	CartaoEntity salvar(CartaoEntity cartaoEntity);
	Optional<CartaoEntity> buscarPorNumero(Long numero);

}
