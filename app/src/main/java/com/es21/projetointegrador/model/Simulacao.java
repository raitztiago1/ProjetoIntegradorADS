package com.es21.projetointegrador.model;

public class Simulacao {
    private String cpf_usuario;
    private String financeira;
    private double renda_mensal;
    private double valor_emprestimo;
    private double tarifa;
    private int parcelas;
    private double cet;
    private double iof;
    private double valor_total;
    private String data_parcela;

    public String getData_parcela() {
        return data_parcela;
    }

    public void setData_parcela(String data_parcela) {
        this.data_parcela = data_parcela;
    }


    public Simulacao(String cpf_usuario, String financeira, double renda_mensal, double valor_emprestimo, double tarifa, int parcelas, double cet, double iof, double valor_total, String data_parcela) {
        this.cpf_usuario = cpf_usuario;
        this.financeira = financeira;
        this.renda_mensal = renda_mensal;
        this.valor_emprestimo = valor_emprestimo;
        this.tarifa = tarifa;
        this.parcelas = parcelas;
        this.cet = cet;
        this.iof = iof;
        this.valor_total = valor_total;
        this.data_parcela = data_parcela;
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getFinanceira() {
        return financeira;
    }

    public void setFinanceira(String financeira) {
        this.financeira = financeira;
    }

    public double getRenda_mensal() {
        return renda_mensal;
    }

    public void setRenda_mensal(double renda_mensal) {
        this.renda_mensal = renda_mensal;
    }

    public double getValor_emprestimo() {
        return valor_emprestimo;
    }

    public void setValor_emprestimo(double valor_emprestimo) {
        this.valor_emprestimo = valor_emprestimo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getCet() {
        return cet;
    }

    public void setCet(double cet) {
        this.cet = cet;
    }

    public double getIof() {
        return iof;
    }

    public void setIof(double iof) {
        this.iof = iof;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    @Override
    public String toString() {
        return
                "\n- Financeira: " + financeira +
                        "\n- Renda Mensal: R$" + renda_mensal +
                        "\n- Valor Emprestimo: R$" + valor_emprestimo +
                        "\n- Tarifa: " + tarifa + "%" +
                        "\n- Parcelas: " + parcelas + "x" +
                        "\n- C.E.T.: " + cet + "%" +
                        "\n- I.O.F.: " + iof + "%" +
                        "\n- Valor total: R$" + valor_total +
                        "\n- Data da Primeira Parcela: " + data_parcela + "\n";
    }

    public String toStringMaster() {
        return
                "\n- CPF do Usuario: " + cpf_usuario +
                        "\n- Financeira: " + financeira +
                        "\n- Renda Mensal: R$" + renda_mensal +
                        "\n- Valor Emprestimo: R$" + valor_emprestimo +
                        "\n- Tarifa: " + tarifa + "%" +
                        "\n- Parcelas: " + parcelas + "x" +
                        "\n- C.E.T.: " + cet + "%" +
                        "\n- I.O.F.: " + iof + "%" +
                        "\n- Valor Total: R$" + valor_total + "\n";
    }
}
