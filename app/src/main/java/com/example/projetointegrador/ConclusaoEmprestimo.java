package com.example.projetointegrador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ConclusaoEmprestimo extends AppCompatActivity {

    Button btnConfirmaTCE, btnCancelaTCE, btCepTCE;
    EditText edtEstadoCivTCE, edtDataTCE, edtDataAdmTCE, edtRendaTCE, edtCepTCE, edtLogradouroTCE, edtNumeroCasaTCE;
    EditText edtComplementoLogradouroTCE, edtBairroTCE, edtComplementoBairroTCE, edtLocalidadeTCE, edtUfTCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conclusao_emprestimo);
        setTitle("Conclusão Emprestimo");

        inicializaComponentes();

        btnConfirmaTCE.setOnClickListener((view -> {

            if (!validaDados()) {

                limpaCampos();

            } else {

            }
        }));

        btnCancelaTCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });

    }

    private void inicializaComponentes() {

        btnConfirmaTCE = findViewById(R.id.btnConfirmaTCE);
        btnCancelaTCE = findViewById(R.id.btnCancelaTCE);

        edtEstadoCivTCE = findViewById(R.id.edtEstadoCivTCE);
        edtDataTCE = findViewById(R.id.edtDataTCE);
        edtDataAdmTCE = findViewById(R.id.edtDataAdmTCE);
        edtRendaTCE = findViewById(R.id.edtRendaTCE);
        edtCepTCE = findViewById(R.id.edtCepTCE);
        edtLogradouroTCE = findViewById(R.id.edtLogradouroTCE);
        edtNumeroCasaTCE = findViewById(R.id.edtNumeroCasaTCE);
        edtComplementoLogradouroTCE = findViewById(R.id.edtComplementoLogradouroTCE);
        edtBairroTCE = findViewById(R.id.edtBairroTCE);
        edtComplementoBairroTCE = findViewById(R.id.edtComplementoBairroTCE);
        edtLocalidadeTCE = findViewById(R.id.edtLocalidadeTCE);
        edtUfTCE = findViewById(R.id.edtUfTCE);

    }

    private void limpaCampos() {

        edtEstadoCivTCE.setText("");
        edtDataTCE.setText("");
        edtDataAdmTCE.setText("");
        edtRendaTCE.setText("");
        edtCepTCE.setText("");

    }

    private boolean validaDados() {
        Boolean existeErros = false;

        if (edtEstadoCivTCE.getText().toString().isEmpty()) {

            edtEstadoCivTCE.setError("Campo Obrigatório");
            edtEstadoCivTCE.requestFocus();
            existeErros = true;

        } else if (edtDataTCE.getText().toString().isEmpty()) {

            edtDataTCE.setError("Campo Obrigatório");
            edtDataTCE.requestFocus();
            existeErros = true;

        } else if (edtDataAdmTCE.getText().toString().isEmpty()) {

            edtDataAdmTCE.setError("Campo Obrigatório");
            edtDataAdmTCE.requestFocus();
            existeErros = true;

        } else if (edtRendaTCE.getText().toString().isEmpty()) {

            edtRendaTCE.setError("Campo Obrigatório");
            edtRendaTCE.requestFocus();
            existeErros = true;

        } else if (edtCepTCE.getText().toString().isEmpty()) {

            edtCepTCE.setError("Campo Obrigatório");
            edtCepTCE.requestFocus();
            existeErros = true;

        } else if (edtLogradouroTCE.getText().toString().isEmpty()) {

            edtLogradouroTCE.setError("Campo Obrigatório");
            edtLogradouroTCE.requestFocus();
            existeErros = true;

        } else if (edtNumeroCasaTCE.getText().toString().isEmpty()) {

            edtNumeroCasaTCE.setError("Campo Obrigatório");
            edtNumeroCasaTCE.requestFocus();
            existeErros = true;

        } else if (edtComplementoLogradouroTCE.getText().toString().isEmpty()) {

            edtComplementoLogradouroTCE.setError("Campo Obrigatório");
            edtComplementoLogradouroTCE.requestFocus();
            existeErros = true;

        } else if (edtBairroTCE.getText().toString().isEmpty()) {

            edtBairroTCE.setError("Campo Obrigatório");
            edtBairroTCE.requestFocus();
            existeErros = true;

        } else if (edtComplementoBairroTCE.getText().toString().isEmpty()) {

            edtComplementoBairroTCE.setError("Campo Obrigatório");
            edtComplementoBairroTCE.requestFocus();
            existeErros = true;

        } else if (edtLocalidadeTCE.getText().toString().isEmpty()) {

            edtLocalidadeTCE.setError("Campo Obrigatório");
            edtLocalidadeTCE.requestFocus();
            existeErros = true;

        } else if (edtUfTCE.getText().toString().isEmpty()) {

            edtUfTCE.setError("Campo Obrigatório");
            edtUfTCE.requestFocus();
            existeErros = true;

        }

        return existeErros;
    }

}