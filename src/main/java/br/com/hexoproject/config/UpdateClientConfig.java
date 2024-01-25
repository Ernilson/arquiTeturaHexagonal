package br.com.hexoproject.config;

import br.com.hexoproject.adapters.output.FindAddressByZipCodeAdaper;
import br.com.hexoproject.adapters.output.UpdateClientAdapter;
import br.com.hexoproject.application.core.usecase.FindClientsByIdUseCase;
import br.com.hexoproject.application.core.usecase.UpdateClientUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateClientConfig {

    @Bean
    public UpdateClientUseCase updateClientUseCase(
            FindClientsByIdUseCase findClientsByIdUseCase,
            FindAddressByZipCodeAdaper findAddressByZipCodeAdaper,
            UpdateClientAdapter updateClientAdapter

    ){
        return new UpdateClientUseCase(findClientsByIdUseCase, findAddressByZipCodeAdaper, updateClientAdapter);
    }
}
