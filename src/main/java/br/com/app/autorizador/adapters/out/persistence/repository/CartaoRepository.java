package br.com.app.autorizador.adapters.out.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {

	Optional<CartaoEntity> findByNumero(Long numero);
	boolean existsByNumero(Long numero);
}
