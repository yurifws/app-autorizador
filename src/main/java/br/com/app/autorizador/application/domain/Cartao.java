package br.com.app.autorizador.application.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Cartao {
	
	private Long numero;
	private String senha;
	private BigDecimal saldo;
	
}
