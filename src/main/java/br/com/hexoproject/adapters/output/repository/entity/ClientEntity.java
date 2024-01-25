package br.com.hexoproject.adapters.output.repository.entity;

import br.com.hexoproject.application.core.domian.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "clients")
public class ClientEntity {

    @Id
    private String id;
    private String nome;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;
}
