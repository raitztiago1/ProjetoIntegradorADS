package com.es21.projetointegrador;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.es21.projetointegrador.http.HttpHelperAuth;
import com.example.projetointegrador.R;

public class RecuperaSenha extends AppCompatActivity {

    private final HttpHelperAuth auth = new HttpHelperAuth();
    Button btVoltarTRS, btConfirmarTRS;
    EditText edtEmailTRS, edtCpfTRS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_senha);
        setTitle("Recupera Senha");

        inicializarComponentes();

        btVoltarTRS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btConfirmarTRS.setOnClickListener((view -> {
            if (!validaDados()) {
                TarefaRecuperaSenha tarefaRecuperaSenha = new TarefaRecuperaSenha();
                tarefaRecuperaSenha.execute();
            }
        }));

    }

    private void inicializarComponentes() {

        btVoltarTRS = findViewById(R.id.btVoltarTRS);
        btConfirmarTRS = findViewById(R.id.btConfirmaTRS);

        edtEmailTRS = findViewById(R.id.edtEmailTRS);
        edtCpfTRS = findViewById(R.id.edtCpfTRS);

    }

    private boolean validaDados() {

        boolean existeErros = false;

        if (edtCpfTRS.getText().toString().isEmpty()) {
            edtCpfTRS.setError("Campo Obrigatório!");
            edtCpfTRS.requestFocus();
            existeErros = true;
        } else if (edtEmailTRS.getText().toString().isEmpty()) {
            edtEmailTRS.setError("Campo Obrigatório!");
            edtEmailTRS.requestFocus();
            existeErros = true;
        }
        return existeErros;
    }

    private class TarefaRecuperaSenha extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            try {
                Autenticacoes validar = new Autenticacoes();
                if (validar.validaCpfGlobal(edtCpfTRS.getText().toString())) {
                    String cpf = edtCpfTRS.getText().toString();
                    String email = edtEmailTRS.getText().toString();
                    return auth.gerarToken(cpf, email);
                } else {
                    return "305";
                }
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(RecuperaSenha.this);
            alerta.setNeutralButton("ok", null);
            try {
                if (s.equals("200")) {
                    Intent telaRecupera = new Intent(getApplicationContext(), RecuperaCodigo.class);
                    telaRecupera.putExtra("cpf", edtCpfTRS.getText().toString());
                    telaRecupera.putExtra("email", edtEmailTRS.getText().toString());
                    startActivity(telaRecupera);
                } else if (s.equals("305")) {
                    alerta.setMessage("Cpf invalido, verifique e tente novamente");
                    alerta.show();
                }
            } catch (Exception e) {
                alerta.setMessage("Nenhuma conta localizada, verifique e tente novamente");
                alerta.show();
                edtCpfTRS.requestFocus();
            }
        }
    }


}