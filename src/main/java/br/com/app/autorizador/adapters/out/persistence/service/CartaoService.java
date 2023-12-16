package br.com.app.autorizador.adapters.out.persistence.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartaoService implements ICartaoService {
	
	private final CartaoRepository repository;

	@Override
	@Transactional
	public CartaoEntity salvar(CartaoEntity cartaoEntity) {
		return repository.save(cartaoEntity);
	}

	@Override
	public Optional<CartaoEntity> buscarPorNumero(Long numero) {
		return repository.findByNumero(numero);
	}

}
