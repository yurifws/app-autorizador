package br.com.app.autorizador.application.port.in;

import java.math.BigDecimal;

public interface ObtemSaldoCartaoUseCase {

	BigDecimal buscarPorNumero(Long numero);

}
