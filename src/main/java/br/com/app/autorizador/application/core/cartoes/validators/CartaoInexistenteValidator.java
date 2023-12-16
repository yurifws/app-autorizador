package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.CARTAO_INEXISTENTE;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.common.exception.CartaoInexistenteException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CartaoInexistenteValidator implements ICartaoValidator {
	
	@Override
	public void validar(Optional<Cartao> cartaoBuscado, Transacao transacao) {
		cartaoBuscado.orElseThrow(() ->  new CartaoInexistenteException(CARTAO_INEXISTENTE.name()));
	}
	

}
