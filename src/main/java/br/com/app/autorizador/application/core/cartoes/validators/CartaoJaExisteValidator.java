package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.adapters.in.web.cartoes.mapper.CartaoControllerMapper.INSTANCE;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.in.BuscaCartaoUseCase;
import br.com.app.autorizador.common.exception.CartaoJaExisteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CartaoJaExisteValidator implements ICartaoValidator {
	
	private final BuscaCartaoUseCase buscaCartaoUseCase;
	

	@Override
	public void validar(Cartao cartao) {
		buscaCartaoUseCase.buscarPorNumero(cartao.getNumero())
		.ifPresent( s -> {
			throw new CartaoJaExisteException(null, INSTANCE.toCartaoDto(cartao));
			});
		
	}
	

}
