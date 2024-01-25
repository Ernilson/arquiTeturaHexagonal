package br.com.hexoproject.config;

import br.com.hexoproject.adapters.output.DeleteClientByIdAdapter;
import br.com.hexoproject.application.core.usecase.DeleteClientByIdUseCase;
import br.com.hexoproject.application.core.usecase.FindClientsByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteClientByIdConfig {

    @Bean
    public DeleteClientByIdUseCase deleteClientByIdUseCase(
            FindClientsByIdUseCase findClientsByIdUseCase,
            DeleteClientByIdAdapter deleteClientByIdAdapter
    ){
        return new DeleteClientByIdUseCase(findClientsByIdUseCase, deleteClientByIdAdapter);
    }
}
