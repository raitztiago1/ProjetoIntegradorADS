package com.es21.projetointegrador.model;

public class Loja {
    private String cnpj_loja;
    private String status_loja;
    private int tipo_loja;
    private String inscricao_estadual;
    private String inscricao_municipal;
    private String ramo_negocio;
    private String motivo_aprovacao;
    private String percentual_clipse;
    private String razao_social;
    private String site;


    public Loja(String cnpj_loja, String status_loja, int tipo_loja, String inscricao_estadual, String inscricao_municipal, String ramo_negocio, String motivo_aprovacao, String percentual_clipse, String razao_social, String site) {
        this.cnpj_loja = cnpj_loja;
        this.status_loja = status_loja;
        this.tipo_loja = tipo_loja;
        this.inscricao_estadual = inscricao_estadual;
        this.inscricao_municipal = inscricao_municipal;
        this.ramo_negocio = ramo_negocio;
        this.motivo_aprovacao = motivo_aprovacao;
        this.percentual_clipse = percentual_clipse;
        this.razao_social = razao_social;
        this.site = site;
    }

    public String getCnpj_loja() {
        return cnpj_loja;
    }

    public void setCnpj_loja(String cnpj_loja) {
        this.cnpj_loja = cnpj_loja;
    }

    public String getStatus_loja() {
        return status_loja;
    }

    public void setStatus_loja(String status_loja) {
        this.status_loja = status_loja;
    }

    public int getTipo_loja() {
        return tipo_loja;
    }

    public void setTipo_loja(int tipo_loja) {
        this.tipo_loja = tipo_loja;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getInscricao_municipal() {
        return inscricao_municipal;
    }

    public void setInscricao_municipal(String inscricao_municipal) {
        this.inscricao_municipal = inscricao_municipal;
    }

    public String getRamo_negocio() {
        return ramo_negocio;
    }

    public void setRamo_negocio(String ramo_negocio) {
        this.ramo_negocio = ramo_negocio;
    }

    public String getMotivo_aprovacao() {
        return motivo_aprovacao;
    }

    public void setMotivo_aprovacao(String motivo_aprovacao) {
        this.motivo_aprovacao = motivo_aprovacao;
    }

    public String getPercentual_clipse() {
        return percentual_clipse;
    }

    public void setPercentual_clipse(String percentual_clipse) {
        this.percentual_clipse = percentual_clipse;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "\nLoja\n" +
                "CNPJ Loja: " + cnpj_loja + "\n" +
                "Status Loja: " + status_loja + "\n" +
                "Tipo Loja: " + tipo_loja + "\n" +
                "Inscricao Estadual: " + inscricao_estadual + "\n" +
                "Inscricao Municipal: " + inscricao_municipal + "\n" +
                "Ramo do Negocio: " + ramo_negocio + "\n" +
                "Motivo da Aprovacao: " + motivo_aprovacao + "\n" +
                "Percentual Clipse: " + percentual_clipse + "\n" +
                "Razao Social: " + razao_social + "\n" +
                "Site: " + site + "\n";
    }
}
