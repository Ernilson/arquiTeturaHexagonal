package br.com.hexoproject.adapters.output;

import br.com.hexoproject.adapters.output.client.FindAddressByZipCodeClient;
import br.com.hexoproject.adapters.output.client.mapper.AddressResponseMapper;
import br.com.hexoproject.core.domian.Address;
import br.com.hexoproject.ports.output.FindAddressZipCodeOutPutPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdaper implements FindAddressZipCodeOutPutPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    private AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdaper(FindAddressByZipCodeClient findAddressByZipCodeClient,
                                      AddressResponseMapper addressResponseMapper){
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }
    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
