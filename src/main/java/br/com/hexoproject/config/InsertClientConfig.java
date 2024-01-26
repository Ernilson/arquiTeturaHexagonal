package br.com.hexoproject.config;

import br.com.hexoproject.adapters.output.FindAddressByZipCodeAdaper;
import br.com.hexoproject.adapters.output.InsertClientsAdpter;
import br.com.hexoproject.adapters.output.SendCpfValidationAdapter;
import br.com.hexoproject.application.core.usecase.CreateClientsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertClientConfig {
    @Bean
    public CreateClientsUseCase createClientsUseCase(
            FindAddressByZipCodeAdaper findAddressByZipCodeAdaper,
            InsertClientsAdpter insertClientsAdpter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new CreateClientsUseCase(findAddressByZipCodeAdaper, insertClientsAdpter,
                sendCpfValidationAdapter );
    }

}
