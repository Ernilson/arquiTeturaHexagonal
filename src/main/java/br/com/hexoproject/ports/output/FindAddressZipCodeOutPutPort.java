package br.com.hexoproject.ports.output;

import br.com.hexoproject.core.domian.Address;

public interface FindAddressZipCodeOutPutPort {

    Address find(String zipCode);
}
