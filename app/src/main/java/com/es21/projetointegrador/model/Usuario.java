package com.es21.projetointegrador.model;

public class Usuario {
    private String cpf_usuario;
    private String nome_contato;
    private String estado_usuario;
    private String telefone_celular;
    private String telefone_comercial;
    private String email;
    private String senha;
    private String data_nascimento;
    private String data_emissao_documento;
    private String data_validade;
    private String tipo_documento;
    private String numero_documento;
    private String orgao_emissor_documento;
    private String natural_cidade;
    private String cargo;

    public Usuario(String cpf_usuario, String nome_contato, String estado_usuario, String telefone_celular, String telefone_comercial, String email, String senha, String data_nascimento, String data_emissao_documento, String data_validade, String tipo_documento, String numero_documento, String orgao_emissor_documento, String natural_cidade, String cargo) {
        this.cpf_usuario = cpf_usuario;
        this.nome_contato = nome_contato;
        this.estado_usuario = estado_usuario;
        this.telefone_celular = telefone_celular;
        this.telefone_comercial = telefone_comercial;
        this.email = email;
        this.senha = senha;
        this.data_nascimento = data_nascimento;
        this.data_emissao_documento = data_emissao_documento;
        this.data_validade = data_validade;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.orgao_emissor_documento = orgao_emissor_documento;
        this.natural_cidade = natural_cidade;
        this.cargo = cargo;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getNome_contato() {
        return nome_contato;
    }

    public void setNome_contato(String nome_contato) {
        this.nome_contato = nome_contato;
    }

    public String getEstado_usuario() {
        return estado_usuario;
    }

    public void setEstado_usuario(String estado_usuario) {
        this.estado_usuario = estado_usuario;
    }

    public String getTelefone_celular() {
        return telefone_celular;
    }

    public void setTelefone_celular(String telefone_celular) {
        this.telefone_celular = telefone_celular;
    }

    public String getTelefone_comercial() {
        return telefone_comercial;
    }

    public void setTelefone_comercial(String telefone_comercial) {
        this.telefone_comercial = telefone_comercial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getData_emissao_documento() {
        return data_emissao_documento;
    }

    public void setData_emissao_documento(String data_emissao_documento) {
        this.data_emissao_documento = data_emissao_documento;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public String getOrgao_emissor_documento() {
        return orgao_emissor_documento;
    }

    public void setOrgao_emissor_documento(String orgao_emissor_documento) {
        this.orgao_emissor_documento = orgao_emissor_documento;
    }

    public String getNatural_cidade() {
        return natural_cidade;
    }

    public void setNatural_cidade(String natural_cidade) {
        this.natural_cidade = natural_cidade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "" +
                " \n CPF Usuario: " + cpf_usuario +
                " \n Nome Contato: " + nome_contato +
                " \n Estado Usuario: " + estado_usuario +
                " \n Telefone Celular: " + telefone_celular +
                " \n Telefone Comercial: " + telefone_comercial +
                " \n Email: " + email +
                " \n Natural Cidade: " + natural_cidade +
                " \n Cargo: " + cargo + "\n";
    }
}
