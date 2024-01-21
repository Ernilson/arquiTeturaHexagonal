package br.com.hexoproject.adapters.output.repository;

import br.com.hexoproject.adapters.output.repository.entity.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<ClientEntity, String> {
}
