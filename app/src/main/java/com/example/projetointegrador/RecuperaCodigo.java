package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RecuperaCodigo extends AppCompatActivity {

    Button btVoltarTRCD, btAvancTRCD;

    EditText edtCodTRCD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_codigo);
        setTitle("Recupera Código");

        inicializarComponentes();

        btAvancTRCD.setOnClickListener((view -> {
            if (!validaDados()) {
                Intent telaNovaSenha = new Intent(getApplicationContext(), NovaSenha.class);
                startActivity(telaNovaSenha);
            } else {

            }
        }));

        btVoltarTRCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializarComponentes() {

        btVoltarTRCD = findViewById(R.id.btVoltarTRCD);
        btAvancTRCD = findViewById(R.id.btAvancTRCD);

        edtCodTRCD = findViewById(R.id.edtCodTRCD);

    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtCodTRCD.getText().toString().isEmpty()) {

            edtCodTRCD.setError("Campo Obrigatório!");
            edtCodTRCD.requestFocus();
            existeErros = true;

        }
        return existeErros;
    }


}