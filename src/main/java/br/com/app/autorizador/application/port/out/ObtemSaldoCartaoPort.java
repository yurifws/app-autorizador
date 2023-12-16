package br.com.app.autorizador.application.port.out;

import java.math.BigDecimal;

public interface ObtemSaldoCartaoPort {
	
	BigDecimal buscarPorNumero(Long numero);

}
