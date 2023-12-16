package br.com.app.autorizador.application.core.cartoes;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.app.autorizador.application.port.in.ObtemSaldoCartaoUseCase;
import br.com.app.autorizador.application.port.out.ObtemSaldoCartaoPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ObtemSaldoCartaoService implements ObtemSaldoCartaoUseCase {
	
	private final ObtemSaldoCartaoPort obtemSaldoCartaoPort;

	@Override
	public BigDecimal buscarPorNumero(Long numero) {
		return obtemSaldoCartaoPort.buscarPorNumero(numero);
	}

}
