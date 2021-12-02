package com.es21.projetointegrador.model;

public class UsuarioLoja {
    private String cpf_usuario;
    private String cnpj_loja;
    private String perfil;
    private String data_hora_cadastro;

    public UsuarioLoja(String cpf_usuario, String cnpj_loja, String perfil, String data_hora_cadastro) {
        this.cpf_usuario = cpf_usuario;
        this.cnpj_loja = cnpj_loja;
        this.perfil = perfil;
        this.data_hora_cadastro = data_hora_cadastro;
    }

    public String getData_hora_cadastro() {
        return data_hora_cadastro;
    }

    public void setData_hora_cadastro(String data_hora_cadastro) {
        this.data_hora_cadastro = data_hora_cadastro;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getCnpj_loja() {
        return cnpj_loja;
    }

    public void setCnpj_loja(String cnpj_loja) {
        this.cnpj_loja = cnpj_loja;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "UsuarioLoja{" +
                "cpf_usuario='" + cpf_usuario + '\'' +
                ", cnpj_loja='" + cnpj_loja + '\'' +
                ", perfil='" + perfil + '\'' +
                ", data_hora_cadastro='" + data_hora_cadastro + '\'' +
                '}';
    }
}
