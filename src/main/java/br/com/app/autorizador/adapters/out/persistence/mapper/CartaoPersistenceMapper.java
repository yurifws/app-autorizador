package br.com.app.autorizador.adapters.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.application.domain.Cartao;

@Mapper
public interface CartaoPersistenceMapper {

	CartaoPersistenceMapper INSTANCE = Mappers.getMapper(CartaoPersistenceMapper.class);
	
	CartaoEntity toCartaoEntity(Cartao cartao);
	
	Cartao toCartao(CartaoEntity cartaoEntity);
}
