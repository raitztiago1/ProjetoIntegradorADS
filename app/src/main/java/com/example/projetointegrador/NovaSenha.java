package com.example.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovaSenha extends AppCompatActivity {

    Button btConfirmaTNS, btCancelaTNS;
    EditText edtSenhaTNS, edtNovaSenhaTNS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_senha);
        setTitle("Nova Senha");
        inicializarComponentes();

        btConfirmaTNS.setOnClickListener((view -> {
            if (!validaDados()) {
                System.out.println("deu bom");
            } else {

            }
        }));


        btCancelaTNS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializarComponentes() {

        btConfirmaTNS = findViewById(R.id.btConfirmaTNS);
        btCancelaTNS = findViewById(R.id.btCancelaTNS);

        edtSenhaTNS = findViewById(R.id.edtSenhaTNS);
        edtNovaSenhaTNS = findViewById(R.id.edtNovaSenhaTNS);

    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtSenhaTNS.getText().toString().isEmpty()) {

            edtSenhaTNS.setError("Campo Obrigatório!");
            edtSenhaTNS.requestFocus();
            existeErros = true;

        } else if (edtNovaSenhaTNS.getText().toString().isEmpty()) {

            edtNovaSenhaTNS.setError("Campo Obrigatório!");
            edtNovaSenhaTNS.requestFocus();
            existeErros = true;

        }
        return existeErros;
    }
}