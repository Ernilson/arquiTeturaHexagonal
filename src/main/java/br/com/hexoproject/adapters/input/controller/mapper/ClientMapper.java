package br.com.hexoproject.adapters.input.controller.mapper;

import br.com.hexoproject.adapters.input.controller.request.ClientRequest;
import br.com.hexoproject.adapters.input.controller.response.ClientsResponse;
import br.com.hexoproject.application.core.domian.Clients;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    //@Mapping(target = "isValidCpf", ignore = true)
    Clients toClients(ClientRequest request);

    ClientsResponse toClientResponse(Clients clientsDomain);
}
