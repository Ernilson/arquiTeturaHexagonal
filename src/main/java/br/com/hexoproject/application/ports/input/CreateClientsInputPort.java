package br.com.hexoproject.application.ports.input;

import br.com.hexoproject.application.core.domian.Clients;

public interface CreateClientsInputPort {

    void creatClient(Clients clients, String zipCode);
}
