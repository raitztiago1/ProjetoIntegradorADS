package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button btLoginT, btRecSenhaTL, btCadTL;
    EditText edtCpfTL, edtPassTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login");

        inicializarComponentes();

        btLoginT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validaDados();


                if (!validaDados()) {
                    Intent telaMenu = new Intent(getApplicationContext(), Menu.class);
                    startActivity(telaMenu);
                    limpaCampos();
                }
            }
        });

        btRecSenhaTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telarecuperasenha = new Intent(getApplicationContext(), RecuperaSenha.class);
                startActivity(telarecuperasenha);
            }
        });
//        btCadTL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Intent telaCadastraNovoUsuario = new Intent(getApplicationContext(), .class);
////                startActivity(telaCadastraNovoUsuario);
//            }
//        });
    }

    private void inicializarComponentes() {

        btLoginT = findViewById(R.id.btLoginTL);
        btRecSenhaTL = findViewById(R.id.btRecSenhaTL);
        btCadTL = findViewById(R.id.btCadTL);

        edtCpfTL = findViewById(R.id.edtCpfTL);
        edtPassTL = findViewById(R.id.edtPassTL);

    }

    private void limpaCampos(){
        edtCpfTL.setText("");
        edtPassTL.setText("");
    }

    private boolean validaDados() {

        Boolean existemErros = false;

        if (edtCpfTL.getText().toString().isEmpty()) {
            edtCpfTL.setError("Campo Obrigatorio");
            edtCpfTL.requestFocus();
            existemErros = true;
        } else if (edtPassTL.getText().toString().isEmpty()) {
            edtPassTL.setError("Campo Obrigatorio");
            edtPassTL.requestFocus();
            existemErros = true;
        }

        return existemErros;
    }

}