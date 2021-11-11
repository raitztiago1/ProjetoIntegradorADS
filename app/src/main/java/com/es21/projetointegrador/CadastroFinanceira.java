package com.es21.projetointegrador;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.es21.projetointegrador.http.HttpHelperLoja;
import com.es21.projetointegrador.model.Loja;
import com.example.projetointegrador.R;

public class CadastroFinanceira extends AppCompatActivity {

    Autenticacoes autent = new Autenticacoes();

    Button btVoltarTCF, btConfirmaTCF;
    TextView edtCnpjTCF, edtRazaoSocialTCF, edtInscricaoEstadualTCF, edtInscricaoMunicipalTCF, edtMotivoAprovacaoTCF, edtSiteTCF;
    Spinner spnStatusTCF, spnTipoLojaTCF, spnRamoTCF;
    int auxStauts;
    private String loja = null;

    String[] status = new String[]{"Selecione o Status", "Ativo", "Inativo"};
    String[] tipoLoja = new String[]{"Selecione o Tipo da Loja", "Administrador", "Usuario"};
    String[] ramoNegocio = new String[]{"Selecione o Ramo", "Financeira", "Banco", "Outros"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_financeira);
        setTitle("Cadastro Financeira");

        inicializarComponentes();
        escolhaRamo();
        escolhaStatus();
        escolhaTipoLoja();

        btConfirmaTCF.setOnClickListener((view -> {

            if (!validaCpfLocal()) {

                TarefaCadastraFinan tarefa = new TarefaCadastraFinan();
                tarefa.execute();
                validaCampos();
                limpaCampos();

            }

        }));

        btVoltarTCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void inicializarComponentes() {

        btVoltarTCF = findViewById(R.id.btVoltarTCF);
        btConfirmaTCF = findViewById(R.id.btConfirmaTCF);

        edtCnpjTCF = findViewById(R.id.edtCnpjTCF);
        edtRazaoSocialTCF = findViewById(R.id.edtRazaoSocialTCF);
        edtInscricaoEstadualTCF = findViewById(R.id.edtInscricaoEstadualTCF);
        edtInscricaoMunicipalTCF = findViewById(R.id.edtInscricaoMunicipalTCF);
        edtMotivoAprovacaoTCF = findViewById(R.id.edtMotivoAprovacaoTCF);
        edtSiteTCF = findViewById(R.id.edtSiteTCF);

        spnStatusTCF = findViewById(R.id.spnStatusTCF);
        spnTipoLojaTCF = findViewById(R.id.spnTipoLojaTCF);
        spnRamoTCF = findViewById(R.id.spnRamoTCF);

    }


    private void escolhaStatus() {

        spnStatusTCF.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.textview_spinner, status));

    }


    private void statusParaNumero() {
        if (spnStatusTCF.getSelectedItem().toString().equals("Ativo")) {

            auxStauts = 1;

        } else if (spnStatusTCF.getSelectedItem().toString().equals("Inativo")) {

            auxStauts = 2;

        }
    }

    private void escolhaTipoLoja() {

        spnTipoLojaTCF.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.textview_spinner, tipoLoja));

    }

    private void escolhaRamo() {

        spnRamoTCF.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.textview_spinner, ramoNegocio));

    }

    private void limpaCampos() {

        edtCnpjTCF.setText("");
        edtRazaoSocialTCF.setText("");
        edtInscricaoEstadualTCF.setText("");
        edtInscricaoMunicipalTCF.setText("");
        edtMotivoAprovacaoTCF.setText("");
        edtSiteTCF.setText("");

        spnStatusTCF.setSelection(0);
        spnTipoLojaTCF.setSelection(0);
        spnRamoTCF.setSelection(0);

    }

    private boolean validaCampos() {

        Boolean existeErros = false;

        if (spnStatusTCF.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnStatusTCF.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        } else if (spnTipoLojaTCF.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnTipoLojaTCF.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        } else if (edtInscricaoEstadualTCF.getText().toString().isEmpty()) {

            edtInscricaoEstadualTCF.setError("Campo Obrigatório");
            edtInscricaoEstadualTCF.requestFocus();
            existeErros = true;

        } else if (edtInscricaoMunicipalTCF.getText().toString().isEmpty()) {

            edtInscricaoMunicipalTCF.setError("Campo Obrigatório");
            edtInscricaoMunicipalTCF.requestFocus();
            existeErros = true;

        } else if (spnRamoTCF.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnRamoTCF.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        } else if (edtMotivoAprovacaoTCF.getText().toString().isEmpty()) {

            edtMotivoAprovacaoTCF.setError("Campo Obrigatório");
            edtMotivoAprovacaoTCF.requestFocus();
            existeErros = true;

        } else if (edtRazaoSocialTCF.getText().toString().isEmpty()) {

            edtRazaoSocialTCF.setError("Campo Obrigatório");
            edtRazaoSocialTCF.requestFocus();
            existeErros = true;

        } else if (edtSiteTCF.getText().toString().isEmpty()) {

            edtSiteTCF.setError("Campo Obrigatório");
            edtSiteTCF.requestFocus();
            existeErros = true;

        }

        return existeErros;
    }

    @SuppressLint("StaticFieldLeak")
    private class TarefaCadastraFinan extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            statusParaNumero();

            HttpHelperLoja helperLoja = new HttpHelperLoja();
            return helperLoja.postLoja(
                    new Loja(
                            edtCnpjTCF.getText().toString(),
                            spnStatusTCF.getSelectedItem().toString(),
                            auxStauts,
                            edtInscricaoEstadualTCF.getText().toString(),
                            edtInscricaoMunicipalTCF.getText().toString(),
                            spnRamoTCF.getSelectedItem().toString(),
                            edtMotivoAprovacaoTCF.getText().toString(),
                            null,
                            edtRazaoSocialTCF.getText().toString(),
                            edtSiteTCF.getText().toString()
                    ));

        }

        @Override
        protected void onPostExecute(String s) {

            Intent chamaTelaMenu = new Intent(CadastroFinanceira.this, MenuMaster.class);
            chamaTelaMenu.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            chamaTelaMenu.putExtra("EXIT", true);

            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroFinanceira.this);

            if (s == null) {

                alerta.setTitle("Erro");
                alerta.setNegativeButton("ok", null);

            } else {
                alerta.setTitle("Cadastro Concluido!")
                        .setMessage("Financeira Cadastrada com Sucesso!!")
                        .setCancelable(false)
                        .setPositiveButton("ok", (dialogInterface, i) -> startActivity(chamaTelaMenu)).create().show();
            }

        }
    }

    private boolean validaCpfLocal() {

        String cnpjAux = edtCnpjTCF.getText().toString();
        boolean existemErros = autent.validaCNPJ(cnpjAux);

        if (!existemErros) {

            edtCnpjTCF.setError("CNPJ Errado!");
            edtCnpjTCF.requestFocus();
            return true;

        } else {

            return false;

        }
    }

}