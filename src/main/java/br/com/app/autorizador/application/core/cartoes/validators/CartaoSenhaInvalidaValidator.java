package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SENHA_INVALIDA;

import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.common.exception.SenhaCartaoInvalidaException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class CartaoSenhaInvalidaValidator implements ICartaoValidator {
	
	@Override
	public void validar(Optional<Cartao> cartaoBuscado, Transacao transacao) {
		cartaoBuscado.stream()
		.filter(isSenhaValida(transacao.getCartao()))
		.findAny()
		.orElseThrow(() ->  {
			log.info("Senha inválida para o cartão de número {}", transacao.getCartao().getNumero());
			return new SenhaCartaoInvalidaException(SENHA_INVALIDA.name());
		});

	}

	private Predicate<? super Cartao> isSenhaValida(Cartao cartao) {
		return predicate -> predicate.getSenha().equals(cartao.getSenha());
	}


}
