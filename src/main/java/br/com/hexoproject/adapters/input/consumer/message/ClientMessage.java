package br.com.hexoproject.adapters.input.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientMessage {

    private String id;

    private String name;

    private String zipCode;

    private String cpf;

    private String isValidCpf;
}
