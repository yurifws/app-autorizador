package br.com.app.autorizador.application.core.cartoes;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.core.cartoes.validators.ICartaoValidator;
import br.com.app.autorizador.application.domain.Cartao;
import br.com.app.autorizador.application.port.in.ValidaCartaoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ValidaCartaoService implements ValidaCartaoUseCase {
	
	@Override
	public void processarValidacao(Cartao cartao, List<ICartaoValidator> validacoesCartao) {
		validacoesCartao.forEach(validacaoCartao -> validacaoCartao.validar(cartao));
	}
	
}
