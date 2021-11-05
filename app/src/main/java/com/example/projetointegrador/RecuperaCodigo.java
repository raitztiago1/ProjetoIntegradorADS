package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperaCodigo extends AppCompatActivity {

    Button btVoltarTRC, btConfirmaTRC;

    EditText edtCodigoLiberacaoTRC, edtSenhaTRC, edtSenhaRptTRC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_codigo);
        setTitle("Recupera Código");

        inicializarComponentes();

        btConfirmaTRC.setOnClickListener((view -> {
            if (!validaDados()) {
                System.out.println("deu bom");
                Intent voltaInicio = new Intent(getApplicationContext(), Login.class);
                startActivity(voltaInicio);
                finish();
            } else {
                btConfirmaTRC.setError("ALGO DE ERRADO NÃO ESTÁ CERTO");
            }
        }));

        btVoltarTRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializarComponentes() {

        btVoltarTRC = findViewById(R.id.btVoltarTRC);
        btConfirmaTRC = findViewById(R.id.btConfirmaTRC);

        edtCodigoLiberacaoTRC = findViewById(R.id.edtCodigoLiberacaoTRC);
        edtSenhaTRC = findViewById(R.id.edtSenhaTRC);
        edtSenhaRptTRC = findViewById(R.id.edtSenhaRptTRC);

    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtCodigoLiberacaoTRC.getText().toString().isEmpty()) {

            edtCodigoLiberacaoTRC.setError("Campo Obrigatório!");
            edtCodigoLiberacaoTRC.requestFocus();
            existeErros = true;

        } else if (edtSenhaTRC.getText().toString().isEmpty()) {

            edtSenhaTRC.setError("Campo Obrigatório!");
            edtSenhaTRC.requestFocus();
            existeErros = true;

        } else if (edtSenhaRptTRC.getText().toString().isEmpty()) {

            edtSenhaRptTRC.setError("Campo Obrigatório!");
            edtSenhaRptTRC.requestFocus();
            existeErros = true;

        }
        return existeErros;
    }


}