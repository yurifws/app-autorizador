package br.com.app.autorizador.adapters.in.web.transacoes.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.app.autorizador.adapters.in.web.transacoes.dto.TransacaoRequestDto;
import br.com.app.autorizador.application.domain.Transacao;

@Mapper
public interface TransacaoControllerMapper {
	
	TransacaoControllerMapper INSTANCE = Mappers.getMapper(TransacaoControllerMapper.class);
	
	@Mapping(target = "cartao.numero", source = "numeroCartao")
	@Mapping(target = "cartao.senha", source = "senhaCartao")
	public Transacao toTransacao(TransacaoRequestDto transacaoRequestDto);
	

}
