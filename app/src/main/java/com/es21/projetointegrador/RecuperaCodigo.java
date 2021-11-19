package com.es21.projetointegrador;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.es21.projetointegrador.http.HttpHelperAuth;
import com.example.projetointegrador.R;
import com.google.android.material.textfield.TextInputEditText;

public class RecuperaCodigo extends AppCompatActivity {

    Button btVoltarTRC, btConfirmaTRC;
    TextInputEditText edtCodigoLiberacaoTRC, edtSenhaTRC, edtSenhaRptTRC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_codigo);
        setTitle("Recupera Código");
        AlertDialog.Builder alerta = new AlertDialog.Builder(RecuperaCodigo.this);
        alerta.setNeutralButton("ok", null);
        alerta.setTitle("Reset Senha");

        inicializarComponentes();

        btConfirmaTRC.setOnClickListener(view -> {
            if (!validaDados()) {
                String token = edtCodigoLiberacaoTRC.getText().toString();
                if (token.isEmpty()) {
                    alerta.setMessage("Digite o token!");
                    alerta.show();
                } else {
                    TarefaAlteraSenha tarefaAlteraSenha = new TarefaAlteraSenha();
                    tarefaAlteraSenha.execute();
                }
            }
        });


        btVoltarTRC.setOnClickListener(view -> finish());

    }

    private class TarefaAlteraSenha extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String cpf = getIntent().getStringExtra("cpf");
            String email = getIntent().getStringExtra("email");

            String token = edtCodigoLiberacaoTRC.getText().toString();
            HttpHelperAuth auth = new HttpHelperAuth();
            String res;
            res = auth.confereToken(token);
            if (res == null) {
                return "Token Invalido";
            } else {
                String resultado = auth.resetSenha(cpf, email, edtCodigoLiberacaoTRC.getText().toString(), edtSenhaTRC.getText().toString());
                if (resultado == null) {
                    return "Error na alteração de senha, verifique os dados e tente novamente!";
                } else {
                    return "Senha alterada com sucesso";
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {

            //CRIA INTENT E PASSA OS PARAMETROS PARA ENCERRAR TELAS ANTERIORES
            Intent chamaTelaInicio = new Intent(RecuperaCodigo.this, Login.class);
            chamaTelaInicio.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            chamaTelaInicio.putExtra("EXIT", true);

            AlertDialog.Builder alerta = new AlertDialog.Builder(RecuperaCodigo.this);
            if (s.equals("Senha alterada com sucesso")) {
                alerta.setTitle("Alteração de Senha")
                        .setMessage(s)
                        .setCancelable(false)
                        .setPositiveButton("ok", (dialogInterface, i) -> startActivity(chamaTelaInicio)).create().show();
            } else {
                alerta.setNeutralButton("ok", null);
                alerta.setTitle("Reset Senha");
                alerta.setMessage(s);
                alerta.show();
            }
        }
    }

    private void inicializarComponentes() {

        btVoltarTRC = findViewById(R.id.btVoltarTRC);
        btConfirmaTRC = findViewById(R.id.btConfirmaTRC);

        edtCodigoLiberacaoTRC = findViewById(R.id.edtCodigoLiberacaoTRC);
        edtSenhaTRC = findViewById(R.id.edtSenhaTRC);
        edtSenhaRptTRC = findViewById(R.id.edtSenhaRptTRC);

    }

    private boolean validaDados() {

        boolean existeErros = false;

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

        } else if (!edtSenhaTRC.getText().toString().equals(edtSenhaRptTRC.getText().toString())) {
            System.out.println(edtSenhaTRC.getText().toString() + edtSenhaRptTRC.getText().toString());
            edtSenhaRptTRC.setError("Senhas digitadas não coincidem");
            edtSenhaRptTRC.requestFocus();
            existeErros = true;
        }
        return existeErros;
    }

}