package br.com.app.autorizador.adapters.in.web.cartoes.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.app.autorizador.adapters.in.web.cartoes.dto.CartaoDto;
import br.com.app.autorizador.application.domain.Cartao;

@Mapper
public interface CartaoControllerMapper {

	CartaoControllerMapper INSTANCE = Mappers.getMapper(CartaoControllerMapper.class);
	
	@Mapping(target = "numero", source = "numeroCartao")
	public Cartao toCartao(CartaoDto cartaoDto);
	
	@Mapping(target = "numeroCartao", source = "numero")
	public CartaoDto toCartaoDto(Cartao cartao);

}
