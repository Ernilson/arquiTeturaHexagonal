package br.com.hexoproject.core.domian;

public class Clients {

    private String id;
    private String nome;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

    public Clients() {
        this.isValidCpf = false;
    }

    public Clients(String id, String nome, Address address, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.nome = nome;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
