package br.com.hexoproject.adapters.output.client.mapper;

import br.com.hexoproject.adapters.output.client.response.AddressResponse;
import br.com.hexoproject.core.domian.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
