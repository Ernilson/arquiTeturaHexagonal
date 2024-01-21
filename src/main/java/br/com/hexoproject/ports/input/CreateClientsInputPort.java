package br.com.hexoproject.ports.input;

import br.com.hexoproject.core.domian.Clients;

public interface CreateClientsInputPort {

    void creatClient(Clients clients, String zipCode);
}
