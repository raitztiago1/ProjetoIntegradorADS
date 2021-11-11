package com.es21.projetointegrador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.es21.projetointegrador.http.HttpHelperCep;
import com.es21.projetointegrador.http.JsonParse;
import com.es21.projetointegrador.model.Cep;
import com.example.projetointegrador.R;

public class CadastraEndereco extends AppCompatActivity {

    EditText edtCepTCEn, edtLogradouroTCEn, edtNumeroCasaTCEn, edtComplementoLogradouroTCEn, edtBairroTCEn, edtLocalidadeTCEn, edtUfTCEn;
    Button btCepTCEn, btVoltaTCEn, btConfirmaTCEn;
    private String cep = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_endereco);
        setTitle("Cadastra Endereço");

        inicializaComponentes();

        btCepTCEn.setOnClickListener((view -> {
            cep = edtCepTCEn.getText().toString();
            if (cep.isEmpty()){
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setNeutralButton("ok", null);
                alerta.setTitle("Error");
                alerta.setMessage("Preencha o cep");
                alerta.show();
            }else{
                TarefaBuscaCep tarefaBuscaCep = new TarefaBuscaCep();
                tarefaBuscaCep.execute();
            }
        }));

    }

    private void inicializaComponentes() {

        btCepTCEn = findViewById(R.id.btCepTCEn);
        btVoltaTCEn = findViewById(R.id.btVoltaTCEn);
        btConfirmaTCEn = findViewById(R.id.btConfirmaTCEn);

        edtCepTCEn = findViewById(R.id.edtCepTCEn);
        edtLogradouroTCEn = findViewById(R.id.edtLogradouroTCEn);
        edtNumeroCasaTCEn = findViewById(R.id.edtNumeroCasaTCEn);
        edtComplementoLogradouroTCEn = findViewById(R.id.edtComplementoLogradouroTCEn);
        edtBairroTCEn = findViewById(R.id.edtBairroTCEn);
        edtLocalidadeTCEn = findViewById(R.id.edtLocalidadeTCEn);
        edtUfTCEn = findViewById(R.id.edtUfTCEn);

    }

    @SuppressLint("StaticFieldLeak")
    private class TarefaBuscaCep extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperCep helperCep = new HttpHelperCep();
            return helperCep.getDadosCep(cep);
        }

        @Override
        protected void onPostExecute(String s) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastraEndereco.this);
            alerta.setNeutralButton("ok", null);
            alerta.setTitle("Error");
            alerta.setMessage("CEP INVALIDO!");
            try {
                if(s == null) {
                    alerta.show();
                }else{
                    Cep cepObj = JsonParse.JsonToObjectCep(s);
                    edtLogradouroTCEn.setText(cepObj.getLogradouro());
                    edtComplementoLogradouroTCEn.setText(cepObj.getComplemento());
                    edtBairroTCEn.setText(cepObj.getBairro());
                    edtLocalidadeTCEn.setText(cepObj.getCidade());
                    edtUfTCEn.setText(cepObj.getUf());


                    btConfirmaTCEn.setOnClickListener(view -> {
                        TarefaCadastraEnderecoUsuario tarefaEndereco = new TarefaCadastraEnderecoUsuario();
                        tarefaEndereco.execute();
                    });
                }
            }catch (Exception e){
                alerta.show();
            }

        }
    }

    @SuppressLint("StaticFieldLeak")
    private class TarefaCadastraEnderecoUsuario extends AsyncTask <String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            Cep cepObj = new Cep(
                    edtUfTCEn.getText().toString(),
                    edtLocalidadeTCEn.getText().toString(),
                    edtBairroTCEn.getText().toString(),
                    "Rua",
                    edtLogradouroTCEn.getText().toString(),
                    edtNumeroCasaTCEn.getText().toString(),
                    edtComplementoLogradouroTCEn.getText().toString(),
                    edtCepTCEn.getText().toString()
            );
            String cpf = getIntent().getStringExtra("cpf");
            HttpHelperCep helperCep = new HttpHelperCep();
            String resposta = helperCep.postEnderecoUsuario(cepObj,cpf);
            if(resposta != null){
                return "Conta criado com sucesso!";
            }else{
                return "Error na criação de conta, verifique e tente novamente!";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            Intent chamaTelaInicio = new Intent(CadastraEndereco.this, Login.class);
            chamaTelaInicio.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            chamaTelaInicio.putExtra("EXIT", true);

            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastraEndereco.this);
            alerta.setTitle("Criação de conta");

            if(s.equals("Conta criado com sucesso!")){
                alerta.setMessage(s)
                        .setCancelable(false)
                        .setPositiveButton("ok", (dialogInterface, i) -> startActivity(chamaTelaInicio)).create().show();
            }else{
                alerta.setMessage(s).setNeutralButton("ok", null).show();
            }
        }
    }


}