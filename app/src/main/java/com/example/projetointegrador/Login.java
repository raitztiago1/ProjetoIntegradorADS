package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelper;

public class Login extends AppCompatActivity {

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

                validaDados();

                if (edtCpfTL.getText().toString().equals("123") && edtPassTL.getText().toString().equals("admin")) {

                    Intent telaMaster = new Intent(getApplicationContext(), MenuMaster.class);

                    String local = "{}";
                    controle.get(local);

                    startActivity(telaMaster);

                    limpaCampos();

                } else if (!validaDados()) {

                    Intent telaComum = new Intent(getApplicationContext(), Menu.class);

                    String local = "{}";
                    controle.get(local);

                    startActivity(telaComum);

                    limpaCampos();

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

                Intent telaCadUser = new Intent(getApplicationContext(),CadastraUsuario.class);
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