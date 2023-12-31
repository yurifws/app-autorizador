package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.CARTAO_INEXISTENTE;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.common.exception.CartaoInexistenteException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class CartaoInexistenteValidator implements ICartaoValidator {

	@Override
	public void validar(Optional<Cartao> cartaoBuscado, Transacao transacao) {
		cartaoBuscado.orElseThrow(() -> {
			log.info("Cartão de número {} não existe", transacao.getCartao().getNumero());
			return new CartaoInexistenteException(CARTAO_INEXISTENTE.name());
		});
	}

}
