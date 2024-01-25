package br.com.hexoproject.application.ports.output;

import br.com.hexoproject.application.core.domian.Address;

public interface FindAddressZipCodeOutPutPort {

    Address find(String zipCode);
}
