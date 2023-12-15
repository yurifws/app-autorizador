package br.com.app.autorizador.application.core.cartoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.core.cartoes.validators.ICartaoValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.domain.Transacao;
import br.com.app.autorizador.application.port.in.ValidaCartaoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ValidaCartaoService implements ValidaCartaoUseCase {

	@Override
	public void processarValidacao(Optional<Cartao> cartaoBuscado, Transacao transacao, List<ICartaoValidator> validacoesCartao) {
		validacoesCartao.forEach(validacaoCartao -> validacaoCartao.validar(cartaoBuscado, transacao));
	}
	
}
