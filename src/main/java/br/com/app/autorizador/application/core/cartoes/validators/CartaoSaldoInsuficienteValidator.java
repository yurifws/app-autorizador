package br.com.app.autorizador.application.core.cartoes.validators;

import static br.com.app.autorizador.application.domain.enums.AutorizacaoTransacaoEnum.SALDO_INSUFICIENTE;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.common.exception.SaldoCartaoInsuficienteException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class CartaoSaldoInsuficienteValidator implements ICartaoValidator {

	@Override
	public void validar(Optional<Cartao> cartaoBuscado, Transacao transacao) {
		cartaoBuscado.stream()
		.filter(isSaldoSuficientePredicate(transacao))
		.findAny()
		.orElseThrow(() ->  {
			log.info("Saldo insuficiente para o cartão de número {}", transacao.getCartao().getNumero());
			return new SaldoCartaoInsuficienteException(SALDO_INSUFICIENTE.name());
		});
		
	}

	private Predicate<? super Cartao> isSaldoSuficientePredicate(Transacao transacao) {
		return predicate -> predicate.getSaldo().subtract(transacao.getValor()).compareTo(BigDecimal.ZERO) >= 0;
	}
	
}
