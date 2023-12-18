package br.com.app.autorizador.application.core.transacoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.core.cartoes.validators.CartaoInexistenteValidator;
import br.com.app.autorizador.application.core.cartoes.validators.CartaoSaldoInsuficienteValidator;
import br.com.app.autorizador.application.core.cartoes.validators.CartaoSenhaInvalidaValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.in.BuscaCartaoUseCase;
import br.com.app.autorizador.application.port.in.EfetuaTransacaoUseCase;
import br.com.app.autorizador.application.port.in.ValidaCartaoUseCase;
import br.com.app.autorizador.application.port.out.EfetuaTransacaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class EfetuaTransacaoService implements EfetuaTransacaoUseCase {

	private final BuscaCartaoUseCase buscaCartaoUseCase;

	private final ValidaCartaoUseCase validaCartaoUseCase;
	private final CartaoInexistenteValidator cartaoInexistenteValidator;
	private final CartaoSenhaInvalidaValidator cartaoSenhaInvalidaValidator;
	private final CartaoSaldoInsuficienteValidator cartaoSaldoInsuficienteValidator;
	
	private final EfetuaTransacaoPort efetuaTransacaoPort;

	@Override
	public void efetuarTransacao(Transacao transacao) {

		Long numero = transacao.getCartao().getNumero();
		Optional<Cartao> cartaoBuscado = buscaCartaoUseCase.buscarPorNumero(numero);

		validaCartaoUseCase.processarValidacao(cartaoBuscado, transacao,
				List.of(cartaoInexistenteValidator, cartaoSenhaInvalidaValidator, cartaoSaldoInsuficienteValidator));

		efetuaTransacaoPort.efetuarTransacao(transacao, numero);
	}

}
