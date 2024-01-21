package br.com.hexoproject.adapters.output.repository.mapper;

import br.com.hexoproject.adapters.output.repository.entity.ClientEntity;
import br.com.hexoproject.core.domian.Clients;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientEntityMapper {

    ClientEntity toClientyEntity(Clients clients);
}
