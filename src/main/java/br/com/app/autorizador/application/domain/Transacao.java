package br.com.app.autorizador.application.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Transacao {
	
	private Cartao cartao;
	private BigDecimal valor;
	

}
