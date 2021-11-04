package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RecuperaSenha extends AppCompatActivity {

    Button btCancelaTRS, btConfirmarTRS;
    EditText edtEmailTRS;

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

        btConfirmarTRS.setOnClickListener((view -> {
            if (!validaDados()) {
                Intent telaRecupera = new Intent(getApplicationContext(), RecuperaCodigo.class);
                startActivity(telaRecupera);
            } else {

            }
        }));

    }

    private void inicializarComponentes() {

        btCancelaTRS = findViewById(R.id.btCancelaTRS);
        btConfirmarTRS = findViewById(R.id.btAvancTRS);

        edtEmailTRS = findViewById(R.id.edtEmailTRS);

    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtEmailTRS.getText().toString().isEmpty()) {

            edtEmailTRS.setError("Campo Obrigatório!");
            edtEmailTRS.requestFocus();
            existeErros = true;

        }
        return existeErros;
    }


}