package com.example.projetointegrador;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperaSenha extends AppCompatActivity {

    Autenticacoes autent = new Autenticacoes();

    Button btCancelaTRS, btConfirmarTRS, btPesquisacpfTRS;
    EditText edtCpfTRS, edtSenhaAntTRS, edtNewSenhaTRS, edtReNewSenhaTRS, edtEmailTRS, edtCodTRS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_senha);
        setTitle("Recupera Senha");

        inicializarComponentes();
        btCancelaTRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btConfirmarTRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });

    }

    private void inicializarComponentes() {

        btCancelaTRS = findViewById(R.id.btCancelaTRS);
        btConfirmarTRS = findViewById(R.id.btConfirmarTRS);
        btPesquisacpfTRS = findViewById(R.id.btPesquisacpfTRS);

        edtCpfTRS = findViewById(R.id.edtCpfTRS);
        edtSenhaAntTRS = findViewById(R.id.edtSenhaAntTRS);
        edtNewSenhaTRS = findViewById(R.id.edtNewSenhaTRS);
        edtReNewSenhaTRS = findViewById(R.id.edtReNewSenhaTRS);
        edtEmailTRS = findViewById(R.id.edtEmailTRS);
        edtCodTRS = findViewById(R.id.edtCodTRS);

    }

    private void limpaCampos() {

        if (validaDadosLocal() == false) {

            edtCpfTRS.setText("");
            edtCpfTRS.requestFocus();

        } else {

            edtCpfTRS.setText("");
            edtSenhaAntTRS.setText("");
            edtNewSenhaTRS.setText("");
            edtReNewSenhaTRS.setText("");
            edtEmailTRS.setText("");
            edtCodTRS.setText("");
        }
    }

    private boolean validaDadosLocal() {

        String cpfAux = edtCpfTRS.getText().toString();
        Boolean existemErros = autent.validaDocumento(cpfAux);

        if (existemErros == false) {

            edtCpfTRS.setError("Campo Obrigatório!");
            edtCpfTRS.requestFocus();
            return existemErros;

        }
        return existemErros;
    }


}