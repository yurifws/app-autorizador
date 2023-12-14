package br.com.app.autorizador.adapters.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import br.com.app.autorizador.adapters.out.persistence.entity.CartaoEntity;
import br.com.app.autorizador.application.domain.Cartao;

@Mapper
public interface CartaoPersistenceMapper {

	CartaoPersistenceMapper INSTANCE = Mappers.getMapper(CartaoPersistenceMapper.class);
	
	CartaoEntity toCartaoEntity(Cartao cartao);
	
	Cartao toCartao(CartaoEntity cartaoEntity);
	
	@Mapping(target = "numero", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void update(@MappingTarget CartaoEntity cartaoEntity, Cartao cartao);
}
