package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.adapters.in.web.cartoes.mapper.CartaoControllerMapper.INSTANCE;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.common.exception.CartaoJaExisteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CartaoJaExisteValidator implements ICartaoValidator {

	@Override
	public void validar(Optional<Cartao> cartaoBuscado, Cartao cartao) {
		cartaoBuscado.ifPresent( s -> {
			throw new CartaoJaExisteException(null, INSTANCE.toCartaoDto(cartao));
			});
		
	}
	

}
