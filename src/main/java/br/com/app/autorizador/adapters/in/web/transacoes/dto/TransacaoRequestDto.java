package br.com.app.autorizador.adapters.in.web.transacoes.dto;

import java.math.BigDecimal;

public record TransacaoRequestDto(Long numeroCartao, String senhaCartao, BigDecimal valor) {

}
