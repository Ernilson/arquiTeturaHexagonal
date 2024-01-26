package br.com.hexoproject.adapters.input.consumer.mapper;

import br.com.hexoproject.adapters.input.consumer.message.ClientMessage;
import br.com.hexoproject.application.core.domian.Clients;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMessageMapper {

    @Mapping(target = "address", ignore = true)
    Clients toclients(ClientMessage clientMessage);
}
