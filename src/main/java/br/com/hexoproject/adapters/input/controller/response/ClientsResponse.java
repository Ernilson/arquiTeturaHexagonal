package br.com.hexoproject.adapters.input.controller.response;

import br.com.hexoproject.application.core.domian.Address;
import lombok.Data;

@Data
public class ClientsResponse {

    private String nome;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;
}
