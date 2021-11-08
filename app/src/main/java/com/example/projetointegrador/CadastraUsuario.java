package com.example.projetointegrador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelperUsuario;
import com.example.projetointegrador.model.Usuario;

public class CadastraUsuario extends AppCompatActivity {

    Button btConfirmaTCU, btVoltarTCU;
    EditText edtCpfTCU, edtUserTCU, edtEmailTCU, edtCelTCU, edtSenhaTCU, edtRptSenhaTCU, edtOrgaoEmissorTCU, edtNaturalCidadeTCU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_usuario);
        setTitle("CadastraUsuario");

        inicializarComponentes();

        btConfirmaTCU.setOnClickListener((view -> {
            if (!validaDados()) {
                TarefaCadastra tarefa = new TarefaCadastra();
                tarefa.execute();
            }
        }));


        btVoltarTCU.setOnClickListener(view -> finish());

    }

    @SuppressLint("StaticFieldLeak")
    private class TarefaCadastra extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperUsuario helperUsuario = new HttpHelperUsuario();
            return helperUsuario.postUsuario(
                    new Usuario(
                            edtCpfTCU.getText().toString(),
                            edtUserTCU.getText().toString().toUpperCase(),
                            "ATIVO",
                            edtCelTCU.getText().toString(),
                            null,
                            edtEmailTCU.getText().toString(),
                            edtSenhaTCU.getText().toString(),
                            null,
                            null,
                            null,
                            null,
                            null,
                            edtOrgaoEmissorTCU.getText().toString(),
                            edtNaturalCidadeTCU.getText().toString().toUpperCase(),
                            "Usuario"
                    ));

        }

        @Override
        protected void onPostExecute(String s) {
            Intent chamaTela = new Intent(CadastraUsuario.this, CadastraEndereco.class);
            chamaTela.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            chamaTela.putExtra("EXIT", true);
            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastraUsuario.this);

            if (s != null) {
                chamaTela.putExtra("cpf", edtCpfTCU.getText().toString());
                limpaCampos();
                startActivity(chamaTela);
            } else {
                alerta.setTitle("Cadastro Error");
                alerta.setNeutralButton("OK", null);
                alerta.setMessage("Erro no cadastro, verifique os dados e tente novamente!");
                alerta.show();
            }

        }
    }

    private void inicializarComponentes() {

        btConfirmaTCU = findViewById(R.id.btConfirmaTCU);
        btVoltarTCU = findViewById(R.id.btVoltarTCU);

        edtCpfTCU = findViewById(R.id.edtCpfTCU);
        edtUserTCU = findViewById(R.id.edtUserTCU);
        edtEmailTCU = findViewById(R.id.edtEmailTCU);
        edtCelTCU = findViewById(R.id.edtCelTCU);
        edtSenhaTCU = findViewById(R.id.edtSenhaTCU);
        edtRptSenhaTCU = findViewById(R.id.edtRptSenhaTCU);
        edtNaturalCidadeTCU = findViewById(R.id.edtNaturalCidadeTCU);
        edtOrgaoEmissorTCU = findViewById(R.id.edtOrgaoEmissorTCU);

    }

    private void limpaCampos() {

        edtCpfTCU.setText("");
        edtUserTCU.setText("");
        edtEmailTCU.setText("");
        edtCelTCU.setText("");
        edtSenhaTCU.setText("");
        edtRptSenhaTCU.setText("");
        edtOrgaoEmissorTCU.setText("");
        edtNaturalCidadeTCU.setText("");

    }

    private boolean validaDados() {

        boolean existeErros = false;

        if (edtCpfTCU.getText().toString().isEmpty()) {

            edtCpfTCU.setError("Campo Obrigatorio");
            edtCpfTCU.requestFocus();
            existeErros = true;

        } else if (edtUserTCU.getText().toString().isEmpty()) {

            edtUserTCU.setError("Campo Obrigatorio");
            edtUserTCU.requestFocus();
            existeErros = true;

        } else if (edtEmailTCU.getText().toString().isEmpty()) {

            edtEmailTCU.setError("Campo Obrigatorio");
            edtEmailTCU.requestFocus();
            existeErros = true;

        } else if (edtCelTCU.getText().toString().isEmpty()) {

            edtCelTCU.setError("Campo Obrigatorio");
            edtCelTCU.requestFocus();
            existeErros = true;

        } else if (edtSenhaTCU.getText().toString().isEmpty()) {

            edtSenhaTCU.setError("Campo Obrigatorio");
            edtSenhaTCU.requestFocus();
            existeErros = true;

        } else if (edtRptSenhaTCU.getText().toString().isEmpty()) {

            edtRptSenhaTCU.setError("Campo Obrigatorio");
            edtRptSenhaTCU.requestFocus();
            existeErros = true;

        } else if (!edtSenhaTCU.getText().toString().equals(edtRptSenhaTCU.getText().toString())) {
            edtRptSenhaTCU.setError("Senhas não coincidem");
            edtRptSenhaTCU.requestFocus();
            existeErros = true;
        }

        return existeErros;

    }

}