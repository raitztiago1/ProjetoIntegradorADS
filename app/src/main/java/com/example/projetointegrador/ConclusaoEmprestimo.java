package com.example.projetointegrador;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelperCep;
import com.example.projetointegrador.http.JsonParse;
import com.example.projetointegrador.model.Cep;

public class ConclusaoEmprestimo extends AppCompatActivity {

    Button btnConfirmaTCE, btnCancelaTCE, btCepTCE;
    EditText edtEstadoCivTCE, edtDataTCE, edtDataAdmTCE, edtRendaTCE, edtCepTCE, edtLogradouroTCE, edtNumeroCasaTCE;
    EditText edtComplementoLogradouroTCE, edtBairroTCE, edtComplementoBairroTCE, edtLocalidadeTCE, edtUfTCE;
    private String cep = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conclusao_emprestimo);
        setTitle("Conclusão Emprestimo");

        inicializaComponentes();

//        btnConfirmaTCE.setOnClickListener((view -> {
//            if (!validaDados()) {
//
//                limpaCampos();
//
//            }
//        }));

        btnCancelaTCE.setOnClickListener(view -> finish());

    }

    private void inicializaComponentes() {

        btnConfirmaTCE = findViewById(R.id.btnConfirmaTCE);
        btnCancelaTCE = findViewById(R.id.btnCancelaTCE);

        edtEstadoCivTCE = findViewById(R.id.edtEstadoCivTCE);
        edtDataTCE = findViewById(R.id.edtDataTCE);
        edtDataAdmTCE = findViewById(R.id.edtDataAdmTCE);
        edtRendaTCE = findViewById(R.id.edtRendaTCE);

    }

    private void limpaCampos() {

        edtEstadoCivTCE.setText("");
        edtDataTCE.setText("");
        edtDataAdmTCE.setText("");
        edtRendaTCE.setText("");

    }

    private boolean validaDados() {
        boolean existeErros = false;

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

        }

        return existeErros;
    }

}