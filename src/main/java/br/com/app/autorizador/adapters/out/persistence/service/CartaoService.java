package br.com.app.autorizador.adapters.out.persistence.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.adapters.out.persistence.repository.CartaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CartaoService implements ICartaoService {
	
	private final CartaoRepository repository;

	@Override
	@Transactional
	public CartaoEntity salvar(CartaoEntity cartaoEntity) {
		log.info("Registrando cartão de número {}", cartaoEntity.getNumero());
		return repository.save(cartaoEntity);
	}

	@Override
	public Optional<CartaoEntity> buscarPorNumero(Long numero) {
		log.info("Buscando cartão de número {}", numero);
		return repository.findByNumero(numero);
	}

}
