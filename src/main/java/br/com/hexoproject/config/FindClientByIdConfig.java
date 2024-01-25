package br.com.hexoproject.config;

import br.com.hexoproject.adapters.output.FindByIdClientsAdapter;
import br.com.hexoproject.application.core.usecase.CreateClientsUseCase;
import br.com.hexoproject.application.core.usecase.FindClientsByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindClientByIdConfig {

    @Bean
    public FindClientsByIdUseCase findClientsByIdUseCase(
            FindByIdClientsAdapter findByIdClientsAdapter
    ){
        return new FindClientsByIdUseCase(findByIdClientsAdapter);
    }
}
