package br.com.app.autorizador.application.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Cartao {
	
	private Long numero;
	private String senha;
	private BigDecimal saldo;
	
}
