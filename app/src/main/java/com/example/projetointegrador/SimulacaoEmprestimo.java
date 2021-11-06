package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SimulacaoEmprestimo extends AppCompatActivity {

    Button btSimulTSP, btVoltarTSP, btConfirmaTSP;
    EditText edtCpfTSP, edtCelTSP, edtValorTSP, edtTarifaTSP, edtCetTSP, edtDataTSP, edtIofTSP;
    Spinner spnFinanTSP;

    String[] financeira = new String[]{"Selecione uma opção", "Financeira 1", "Financeira 2", "Financeira 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simulacao_emprestimo);
        setTitle("Simulação Emprestimo");

        inicializaComponentes();
        escolhaFinan();

        btConfirmaTSP.setOnClickListener((view -> {

            if (!validaDados()) {

                String auxFinan = spnFinanTSP.getSelectedItem().toString();
                System.out.println(auxFinan);

                limpaCampos();

                Intent telaConclusao = new Intent(getApplicationContext(), ConclusaoEmprestimo.class);
                startActivity(telaConclusao);

            } else {

            }
        }));

        btVoltarTSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

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

        spnFinanTSP = findViewById(R.id.spnFinanTSP);

    }

    private void escolhaFinan() {

        spnFinanTSP.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.textview_spinner, financeira));

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

    }

    private boolean validaDados() {

        Boolean existeErros = false;

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