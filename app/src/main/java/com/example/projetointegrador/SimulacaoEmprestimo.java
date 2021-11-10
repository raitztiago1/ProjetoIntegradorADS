package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SimulacaoEmprestimo extends AppCompatActivity {

    Autenticacoes autent = new Autenticacoes();
    final Double tarifa = 0.017;
    final Double iofFixo = 0.0038;
    final Double iofRotativo = 0.0025;
    Button btSimulTSP, btVoltarTSP, btConfirmaTSP;
    EditText edtCpfTSP, edtCelTSP, edtValorTSP, edtTarifaTSP, edtCetTSP, edtDataTSP, edtIofTSP, edtRendaTSP, edtValorTotalTSP, edtValorParcTSP;
    Spinner spnFinanTSP, spnParcelasTSP;
    Double cet, cetPrint, iofFinal, iofPrint, tarifaPrint, valorParcela, valorFinal, valorInicial;
    int qtdParcelas;

    String[] financeira = new String[]{"Selecione uma opção", "Financeira 1", "Financeira 2", "Financeira 3"};
    String[] parcelas = new String[]{"Selecione as Parcelas", "12 Parcelas", "24 Parcelas", "36 Parcelas", "48 Parcelas", "60 Parcelas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulacao_emprestimo);
        setTitle("Simulação Emprestimo");

        inicializaComponentes();
        escolhaFinan();
        escolhaPar();

        btSimulTSP.setOnClickListener((view -> definirParcela()));

        btConfirmaTSP.setOnClickListener((view -> {

            if (!validaDados() || validaCpfLocal()) {

                String auxFinan = spnFinanTSP.getSelectedItem().toString();
                System.out.println(auxFinan);

                limpaCampos();

            }
        }));

        btVoltarTSP.setOnClickListener(view -> finish());

    }

    private void inicializaComponentes() {

        btSimulTSP = findViewById(R.id.btSimulTSP);
        btVoltarTSP = findViewById(R.id.btVoltarTSP);
        btConfirmaTSP = findViewById(R.id.btConfirmaTSP);

        edtCpfTSP = findViewById(R.id.edtCpfTSP);
        edtCelTSP = findViewById(R.id.edtCelTSP);
        edtValorTSP = findViewById(R.id.edtValorTSP);
        edtTarifaTSP = findViewById(R.id.edtTarifaTSP);
        edtCetTSP = findViewById(R.id.edtCetTSP);
        edtDataTSP = findViewById(R.id.edtDataTSP);
        edtIofTSP = findViewById(R.id.edtIofTSP);
        edtRendaTSP = findViewById(R.id.edtRendaTSP);
        edtValorTotalTSP = findViewById(R.id.edtValorTotalTSP);
        edtValorParcTSP = findViewById(R.id.edtValorParcTSP);

        spnFinanTSP = findViewById(R.id.spnFinanTSP);
        spnParcelasTSP = findViewById(R.id.spnParcelasTSP);

    }

    private void escolhaFinan() {

        spnFinanTSP.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.textview_spinner, financeira));

    }

    private void escolhaPar() {

        spnParcelasTSP.setAdapter(new ArrayAdapter<>(getApplicationContext(), R.layout.textview_spinner, parcelas));

    }

    private void limpaCampos() {

        edtCpfTSP.setText("");
        edtCelTSP.setText("");
        edtValorTSP.setText("");
        edtTarifaTSP.setText("");
        edtCetTSP.setText("");
        edtDataTSP.setText("");
        edtIofTSP.setText("");

        spnFinanTSP.setSelection(0);
        spnParcelasTSP.setSelection(0);

    }

    private void definirParcela() {

        String auxTarifaPrint, auxCetPrint, auxIofPrint, auxValorInicial, auxValorParcela, auxValorFinal;

        auxValorInicial = edtValorTSP.getText().toString();
        valorInicial = Double.parseDouble(auxValorInicial);

        if (spnParcelasTSP.getSelectedItem().toString().equals("12 Parcelas")) {

            qtdParcelas = 12;

            tarifaPrint = tarifa * 100;

            iofFinal = iofFixo + (iofRotativo * qtdParcelas);
            iofPrint = iofFinal * 100;

            cet = iofFinal + tarifa;
            cetPrint = cet * 100;

            valorFinal = valorInicial + (valorInicial * cet);
            valorParcela = valorFinal / qtdParcelas;

            auxTarifaPrint = String.format("%.2f", tarifaPrint);
            auxIofPrint = String.format("%.2f", iofPrint);
            auxCetPrint = String.format("%.2f", cetPrint);
            auxValorParcela = String.format("%,2f", valorParcela);
            auxValorFinal = String.format("%,2f", valorFinal);

            edtTarifaTSP.setText(auxTarifaPrint + "%");
            edtIofTSP.setText(auxIofPrint + "%");
            edtCetTSP.setText(auxCetPrint + "%");
            edtValorParcTSP.setText("R$" + auxValorParcela);
            edtValorTotalTSP.setText("R$" + auxValorFinal);

        } else if (spnParcelasTSP.getSelectedItem().toString().equals("24 Parcelas")) {

            qtdParcelas = 24;

            tarifaPrint = tarifa * 100;

            iofFinal = iofFixo + (iofRotativo * qtdParcelas);
            iofPrint = iofFinal * 100;

            cet = iofFinal + tarifa;
            cetPrint = cet * 100;

            valorFinal = valorInicial + (valorInicial * cet);
            valorParcela = valorFinal / qtdParcelas;

            auxTarifaPrint = String.format("%.2f", tarifaPrint);
            auxIofPrint = String.format("%.2f", iofPrint);
            auxCetPrint = String.format("%.2f", cetPrint);
            auxValorParcela = String.format("%.2f", valorParcela);
            auxValorFinal = String.format("%.2f", valorFinal);

            edtTarifaTSP.setText(auxTarifaPrint + "%");
            edtIofTSP.setText(auxIofPrint + "%");
            edtCetTSP.setText(auxCetPrint + "%");
            edtValorParcTSP.setText("R$" + auxValorParcela);
            edtValorTotalTSP.setText("R$" + auxValorFinal);

        } else if (spnParcelasTSP.getSelectedItem().toString().equals("36 Parcelas")) {

            qtdParcelas = 36;

            tarifaPrint = tarifa * 100;

            iofFinal = iofFixo + (iofRotativo * qtdParcelas);
            iofPrint = iofFinal * 100;

            cet = iofFinal + tarifa;
            cetPrint = cet * 100;

            valorFinal = valorInicial + (valorInicial * cet);
            valorParcela = valorFinal / qtdParcelas;

            auxTarifaPrint = String.format("%.2f", tarifaPrint);
            auxIofPrint = String.format("%.2f", iofPrint);
            auxCetPrint = String.format("%.2f", cetPrint);
            auxValorParcela = String.format("%.2f", valorParcela);
            auxValorFinal = String.format("%.2f", valorFinal);

            edtTarifaTSP.setText(auxTarifaPrint + "%");
            edtIofTSP.setText(auxIofPrint + "%");
            edtCetTSP.setText(auxCetPrint + "%");
            edtValorParcTSP.setText("R$" + auxValorParcela);
            edtValorTotalTSP.setText("R$" + auxValorFinal);

        } else if (spnParcelasTSP.getSelectedItem().toString().equals("48 Parcelas")) {

            qtdParcelas = 48;

            tarifaPrint = tarifa * 100;

            iofFinal = iofFixo + (iofRotativo * qtdParcelas);
            iofPrint = iofFinal * 100;

            cet = iofFinal + tarifa;
            cetPrint = cet * 100;

            valorFinal = valorInicial + (valorInicial * cet);
            valorParcela = valorFinal / qtdParcelas;

            auxTarifaPrint = String.format("%.2f", tarifaPrint);
            auxIofPrint = String.format("%.2f", iofPrint);
            auxCetPrint = String.format("%.2f", cetPrint);
            auxValorParcela = String.format("%.2f", valorParcela);
            auxValorFinal = String.format("%.2f", valorFinal);

            edtTarifaTSP.setText(auxTarifaPrint + "%");
            edtIofTSP.setText(auxIofPrint + "%");
            edtCetTSP.setText(auxCetPrint + "%");
            edtValorParcTSP.setText("R$" + auxValorParcela);
            edtValorTotalTSP.setText("R$" + auxValorFinal);

        } else if (spnParcelasTSP.getSelectedItem().toString().equals("60 Parcelas")) {

            qtdParcelas = 60;

            tarifaPrint = tarifa * 100;

            iofFinal = iofFixo + (iofRotativo * qtdParcelas);
            iofPrint = iofFinal * 100;

            cet = iofFinal + tarifa;
            cetPrint = cet * 100;

            valorFinal = valorInicial + (valorInicial * cet);
            valorParcela = valorFinal / qtdParcelas;

            auxTarifaPrint = String.format("%.2f", tarifaPrint);
            auxIofPrint = String.format("%.2f", iofPrint);
            auxCetPrint = String.format("%.2f", cetPrint);
            auxValorParcela = String.format("%.2f", valorParcela);
            auxValorFinal = String.format("%.2f", valorFinal);

            edtTarifaTSP.setText(auxTarifaPrint + "%");
            edtIofTSP.setText(auxIofPrint + "%");
            edtCetTSP.setText(auxCetPrint + "%");
            edtValorParcTSP.setText("R$" + auxValorParcela);
            edtValorTotalTSP.setText("R$" + auxValorFinal);

        }
    }


    private boolean validaCpfLocal() {

        String cpfAux = edtCpfTSP.getText().toString();
        boolean existemErros = autent.validaDocumento(cpfAux);

        if (!existemErros) {

            edtCpfTSP.setError("Campo Obrigatorio");
            edtCpfTSP.requestFocus();
            return false;

        }

        return true;

    }

    private boolean validaDados() {

        boolean existeErros = false;

        if (edtCpfTSP.getText().toString().isEmpty()) {

            edtCpfTSP.setError("Campo Obrigatório");
            edtCpfTSP.requestFocus();
            existeErros = true;

        } else if (edtCelTSP.getText().toString().isEmpty()) {

            edtCelTSP.setError("Campo Obrigatório");
            edtCelTSP.requestFocus();
            existeErros = true;

        } else if (edtValorTSP.getText().toString().isEmpty()) {

            edtValorTSP.setError("Campo Obrigatório");
            edtValorTSP.requestFocus();
            existeErros = true;

        } else if (edtTarifaTSP.getText().toString().isEmpty()) {

            edtTarifaTSP.setError("Campo Obrigatório");
            edtTarifaTSP.requestFocus();
            existeErros = true;

        } else if (edtCetTSP.getText().toString().isEmpty()) {

            edtCetTSP.setError("Campo Obrigatório");
            edtCetTSP.requestFocus();
            existeErros = true;

        } else if (edtDataTSP.getText().toString().isEmpty()) {

            edtDataTSP.setError("Campo Obrigatório");
            edtDataTSP.requestFocus();
            existeErros = true;

        } else if (edtIofTSP.getText().toString().isEmpty()) {

            edtIofTSP.setError("Campo Obrigatório");
            edtIofTSP.requestFocus();
            existeErros = true;

        } else if (spnFinanTSP.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnFinanTSP.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        }

        return existeErros;
    }


}