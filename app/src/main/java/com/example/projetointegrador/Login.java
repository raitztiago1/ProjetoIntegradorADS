package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelper;

public class Login extends AppCompatActivity {

    Autenticacoes autent = new Autenticacoes();

    Button btLoginTL, btRecSenhaTL, btCadTL;
    EditText edtCpfTL, edtPassTL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login");

        HttpHelper controle = new HttpHelper();

        inicializarComponentes();

        btLoginTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validaCpfLocal() == true) {

                    if (edtPassTL.getText().toString().equals("admin")) {

                        Intent telaMaster = new Intent(getApplicationContext(), MenuMaster.class);

                        String local = "{}";
                        controle.get(local);

                        startActivity(telaMaster);

                        limpaCampos();


                    } else if (edtPassTL.getText().toString().isEmpty()) {

                        edtPassTL.requestFocus();
                        edtPassTL.setError("Senha Vazia!");


                    } else {

                        Intent telaComum = new Intent(getApplicationContext(), Menu.class);

                        String local = "{}";
                        controle.get(local);

                        startActivity(telaComum);

                    }

                }

            }
        });

        btRecSenhaTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaRSenha = new Intent(getApplicationContext(), RecuperaSenha.class);
                startActivity(telaRSenha);

            }
        });

        btCadTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaCadUser = new Intent(getApplicationContext(), CadastraUsuario.class);
                startActivity(telaCadUser);

            }
        });
    }


    private void inicializarComponentes() {

        btLoginTL = findViewById(R.id.btLoginTL);
        btRecSenhaTL = findViewById(R.id.btRecSenhaTL);
        btCadTL = findViewById(R.id.btCadTL);

        edtCpfTL = findViewById(R.id.edtCpfTL);
        edtPassTL = findViewById(R.id.edtPassTL);

    }

    private void limpaCampos() {

        edtCpfTL.setText("");
        edtPassTL.setText("");

    }

    private boolean validaCpfLocal() {

        String cpfAux = edtCpfTL.getText().toString();
        Boolean existemErros = autent.validaDocumento(cpfAux);

        if (existemErros == false) {

            edtCpfTL.setError("Campo Obrigatorio");
            edtCpfTL.requestFocus();
            return existemErros;

        }

        return existemErros;
    }

}