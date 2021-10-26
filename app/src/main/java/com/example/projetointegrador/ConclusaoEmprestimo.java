package com.example.projetointegrador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ConclusaoEmprestimo extends AppCompatActivity {

    Button btnConfirmaTCE, btnCancelaTCE;
    EditText edtEstadoCivTCE, edtDataTCE, edtDataAdmTCE, edtRendaTCE, edtCepTCE;

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

        }

        return existeErros;
    }

}