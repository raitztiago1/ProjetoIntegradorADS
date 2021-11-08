package com.example.projetointegrador;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelperCep;
import com.example.projetointegrador.http.JsonParse;
import com.example.projetointegrador.model.Cep;

public class CadastraEndereco extends AppCompatActivity {

    EditText edtCepTCEn, edtLogradouroTCEn, edtNumeroCasaTCEn, edtComplementoLogradouroTCEn, edtBairroTCEn, edtComplementoBairroTCEn, edtLocalidadeTCEn, edtUfTCEn;
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
        edtComplementoBairroTCEn = findViewById(R.id.edtComplementoBairroTCEn);
        edtLocalidadeTCEn = findViewById(R.id.edtLocalidadeTCEn);
        edtUfTCEn = findViewById(R.id.edtUfTCEn);

    }

    private class TarefaBuscaCep extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperCep helperCep = new HttpHelperCep();
            return helperCep.getDadosCep(cep);

        }

        @Override
        protected void onPostExecute(String s) {
            if(s == null){
                AlertDialog.Builder alerta = new AlertDialog.Builder(CadastraEndereco.this);
                alerta.setNeutralButton("ok", null);
                alerta.setTitle("Error");
                alerta.setMessage("CEP INVALIDO!");
                alerta.show();
            }else{
                Cep cepObj = JsonParse.JsonToObjectCep(s);
                edtLogradouroTCEn.setText(cepObj.getLogradouro());
                edtComplementoBairroTCEn.setText(cepObj.getComplemento());
                edtBairroTCEn.setText(cepObj.getBairro());
                edtLocalidadeTCEn.setText(cepObj.getLocalidade());
                edtUfTCEn.setText(cepObj.getUf());

                btConfirmaTCEn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        cepObj.setNumero(edtNumeroCasaTCEn.getText().toString());
                        cepObj.setComplementoResidencia(edtComplementoLogradouroTCEn.getText().toString());
                        cepObj.setComplemento(edtComplementoBairroTCEn.getText().toString());
                        System.out.println(cepObj.toString());
                    }
                });
            }

        }
    }

}