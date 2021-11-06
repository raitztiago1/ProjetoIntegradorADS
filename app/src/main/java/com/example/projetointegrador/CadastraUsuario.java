package com.example.projetointegrador;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CadastraUsuario extends AppCompatActivity {

    Button btConfirmaTCU, btVoltarTCU;
    EditText edtCpfTCU, edtUserTCU, edtEmailTCU, edtCelTCU, edtSenhaTCU, edtRptSenhaTCU;
    Spinner spnStatusTCU;

    String[] statusUser = new String[]{"Status do Usuário", "teste 1", "teste 2"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_usuario);
        setTitle("CadastraUsuario");

        inicializarComponentes();
        escolhaTipoUser();

        btConfirmaTCU.setOnClickListener((view -> {
            if (!validaDados()) {
                String tipoUser = spnStatusTCU.getSelectedItem().toString();
                System.out.println();
                limpaCampos();
            } else {

            }
        }));


        btVoltarTCU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

    }

    private void inicializarComponentes() {

        btConfirmaTCU = findViewById(R.id.btConfirmaTCU);
        btVoltarTCU = findViewById(R.id.btVoltarTCU);

        edtCpfTCU = findViewById(R.id.edtCpfTCU);
        edtUserTCU = findViewById(R.id.edtUserTCU);
        edtEmailTCU = findViewById(R.id.edtEmailTCU);
        edtCelTCU = findViewById(R.id.edtCelTCU);
        edtSenhaTCU = findViewById(R.id.edtSenhaTCU);
        edtRptSenhaTCU = findViewById(R.id.edtRptSenhaTCU);

        spnStatusTCU = findViewById(R.id.spnStausTCU);

    }

    private void escolhaTipoUser() {
        spnStatusTCU.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.textview_spinner,
                statusUser
        ));
    }

    private void limpaCampos() {

        edtCpfTCU.setText("");
        edtUserTCU.setText("");
        edtEmailTCU.setText("");
        edtCelTCU.setText("");
        edtSenhaTCU.setText("");
        edtRptSenhaTCU.setText("");

        spnStatusTCU.setSelection(0);

    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtCpfTCU.getText().toString().isEmpty()) {

            edtCpfTCU.setError("Campo Obrigatorio");
            edtCpfTCU.requestFocus();
            existeErros = true;

        } else if (edtUserTCU.getText().toString().isEmpty()) {

            edtUserTCU.setError("Campo Obrigatorio");
            edtUserTCU.requestFocus();
            existeErros = true;

        } else if (edtEmailTCU.getText().toString().isEmpty()) {

            edtEmailTCU.setError("Campo Obrigatorio");
            edtEmailTCU.requestFocus();
            existeErros = true;

        } else if (edtCelTCU.getText().toString().isEmpty()) {

            edtCelTCU.setError("Campo Obrigatorio");
            edtCelTCU.requestFocus();
            existeErros = true;

        } else if (spnStatusTCU.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnStatusTCU.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        } else if (edtSenhaTCU.getText().toString().isEmpty()) {

            edtSenhaTCU.setError("Campo Obrigatorio");
            edtSenhaTCU.requestFocus();
            existeErros = true;

        } else if (edtRptSenhaTCU.getText().toString().isEmpty()) {

            edtRptSenhaTCU.setError("Campo Obrigatorio");
            edtRptSenhaTCU.requestFocus();
            existeErros = true;

        }

        return existeErros;

    }

}