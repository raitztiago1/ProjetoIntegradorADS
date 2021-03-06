package com.es21.projetointegrador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.es21.projetointegrador.http.HttpHelper;
import com.es21.projetointegrador.http.HttpHelperUsuario;
import com.es21.projetointegrador.http.JsonParse;
import com.es21.projetointegrador.model.Usuario;
import com.example.projetointegrador.R;
import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private final HttpHelper httpHelper = new HttpHelper();
    Autenticacoes autent = new Autenticacoes();
    Button btLoginTL, btRecSenhaTL, btCadTL;
    private String edCpf;
    TextInputEditText edtCpfTL, edtSenhaTL;
    private String edSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setTitle("Login");
        inicializarComponentes();
        httpHelper.HttpHelperStart();

        btLoginTL.setOnClickListener(view -> {
            if (validaCpfLocal()) {
                edCpf = edtCpfTL.getText().toString();
                edSenha = edtSenhaTL.getText().toString();
                TarefaUsuarioUnico tarefaUsuario = new TarefaUsuarioUnico();
                tarefaUsuario.execute();
            }

        });

        btRecSenhaTL.setOnClickListener(view -> {

            Intent telaRSenha = new Intent(getApplicationContext(), RecuperaSenha.class);
            startActivity(telaRSenha);

        });

        btCadTL.setOnClickListener(view -> {

            Intent telaCadUser = new Intent(getApplicationContext(), CadastraUsuario.class);
            startActivity(telaCadUser);

        });
    }

    //inicializa componentes da tela para versionamento
    private void inicializarComponentes() {
        btLoginTL = findViewById(R.id.btLoginTL);
        btRecSenhaTL = findViewById(R.id.btRecSenhaTL);
        btCadTL = findViewById(R.id.btCadTL);
        edtCpfTL = findViewById(R.id.edtCpfTL);
        edtSenhaTL = findViewById(R.id.edtSenhaTL);
    }

    //limpa os campos visiveis a usuario
    private void limpaCampos() {
        edtCpfTL.setText("");
        edtSenhaTL.setText("");
    }

    //chama validacao de cpf
    private boolean validaCpfLocal() {
        String cpfAux = edtCpfTL.getText().toString();
        boolean existemErros = autent.validaCpfGlobal(cpfAux);

        if (!existemErros) {
            edtCpfTL.setError("Campo Obrigatorio");
            edtCpfTL.requestFocus();
            return false;
        }
        return true;
    }

    //realiza o processamento dos dados e encaminha para tela
    @SuppressLint("StaticFieldLeak")
    private class TarefaUsuarioUnico extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperUsuario controleUsuario = new HttpHelperUsuario();
            return controleUsuario.getUsuario(edCpf);
        }

        @Override
        protected void onPostExecute(String s) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(Login.this);
            alerta.setNeutralButton("OK", null);
            alerta.setTitle("Login error");

            Usuario user = JsonParse.JsonToObject(s);
            if (user != null) {
                Intent telaMaster = new Intent(getApplicationContext(), MenuMaster.class);
                Intent telaMenu = new Intent(Login.this, Menu.class);
                String cpf = edtCpfTL.getText().toString();
                telaMaster.putExtra("cpf", cpf);
                telaMenu.putExtra("cpf", cpf);

                if (user.getSenha().equals(edSenha)) {
                    if (user.getCargo().equals("Administrador")) {
                        startActivity(telaMaster);
                        limpaCampos();
                    } else {
                        startActivity(telaMenu);
                        limpaCampos();
                    }
                } else {
                    alerta.setMessage("Senha ou usuario invalido verifique e tente novamente");
                    alerta.show();
                }
            } else {
                alerta.setMessage("Usuario nao existe, verifique se digitou corretamente ou realize o cadastro");
                alerta.show();
            }
        }
    }

}