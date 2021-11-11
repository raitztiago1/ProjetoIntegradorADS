package com.es21.projetointegrador.model;

public class UsuarioEndereco {
    private String id_cpf;
    private String uf;
    private String cidade;
    private String bairro;
    private String tipo_logradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String cep;

    public UsuarioEndereco(String id_cpf, String uf, String cidade, String bairro, String tipo_logradouro, String logradouro, String numero, String complemento, String cep) {
        this.id_cpf = id_cpf;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.tipo_logradouro = tipo_logradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public String getId_cpf() {
        return id_cpf;
    }

    public void setId_cpf(String id_cpf) {
        this.id_cpf = id_cpf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTipo_logradouro() {
        return tipo_logradouro;
    }

    public void setTipo_logradouro(String tipo_logradouro) {
        this.tipo_logradouro = tipo_logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
