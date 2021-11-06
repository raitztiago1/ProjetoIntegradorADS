package com.example.projetointegrador;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroFinanceira extends AppCompatActivity {

    Button btVoltarTCF, btConfirmaTCF;
    TextView edtCnpjTCF, edtRazSocTCF, edtAgenciaTCF, edtCcTCF, edtCepTCF;
    Spinner spnBancoTCF, spnCttTCF;

    String[] banco = new String[]{"Selecione uma Opção",
            "001 - Banco do Brasil S.A.",
            "004 – Banco do Nordeste do Brasil S.A.",
            "007 – Banco Nacional de Desenvolvimento Econômico e Social – BNDES",
            "033 – Banco Santander (Brasil) S.A.",
            "037 – Banco do Estado do Pará S.A.",
            "041 – Banco do Estado do Rio Grande do Sul S.A.",
            "044 – Banco BVA S.A.",
            "047 – Banco do Estado de Sergipe S.A.",
            "077 – Banco Inter S.A.",
            "062 – Hipercard Banco Múltiplo S.A.",
            "102 – Xp Investimentos S.A",
            "104 – Caixa Econômica Federal",
            "197 – Stone Pagamentos S.A",
            "208 – Banco BTG Pactual S.A.",
            "212 – Banco Original S.A.",
            "237 – Banco Bradesco S.A.",
            "260 – Nu Pagamentos S.A.(NuBank)",
            "290 – Pagseguro Internet S.A",
            "318 – Banco BMG S.A.",
            "336 – Banco C6 S.A. – C6 Bank",
            "341 – Itaú Unibanco S.A.",
            "399 – HSBC Bank Brasil S.A. – Banco Múltiplo",
            "422 – Banco Safra S.A.",
            "453 – Banco Rural S.A.",
            "477 – Citibank N.A.",
            "623 – Banco Panamericano S.A.",
            "633 – Banco Rendimento S.A.",
            "634 – Banco Triângulo S.A.",
            "745 – Banco Citibank S.A.",
            "746 – Banco Modal S.A.",
            "748 – Banco Cooperativo Sicredi S.A.",
            "756 – Banco Cooperativo do Brasil S.A. – BANCOOB"};
    String[] contatoMaster = new String[]{"Selecione uma Opção", "Administrador", "Usuário"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_financeira);
        setTitle("Cadastro Financeira");

        inicializarComponentes();
        escolhaTipoUser();
        escolhaContato();

        btConfirmaTCF.setOnClickListener((view -> {

            if (!validaDados()) {

                String auxBanco = spnBancoTCF.getSelectedItem().toString();
                String auxContato = spnCttTCF.getSelectedItem().toString();
                System.out.println(auxBanco + " " + auxContato);
                limpaCampos();

            } else {

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
        edtRazSocTCF = findViewById(R.id.edtRazSocTCF);
        edtAgenciaTCF = findViewById(R.id.edtAgenciaTCF);
        edtCcTCF = findViewById(R.id.edtCcTCF);
        edtCepTCF = findViewById(R.id.edtCepTCF);

        spnBancoTCF = findViewById(R.id.spnBancoTCF);
        spnCttTCF = findViewById(R.id.spnCttTCF);

    }

    private void escolhaTipoUser() {

        spnBancoTCF.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.textview_spinner, banco));

    }

    private void escolhaContato() {

        spnCttTCF.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(), R.layout.textview_spinner, contatoMaster));

    }

    private void limpaCampos() {

        edtCnpjTCF.setText("");
        edtRazSocTCF.setText("");
        edtAgenciaTCF.setText("");
        edtCcTCF.setText("");
        edtCepTCF.setText("");

        spnBancoTCF.setSelection(0);
        spnCttTCF.setSelection(0);

    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtCnpjTCF.getText().toString().isEmpty()) {

            edtCnpjTCF.setError("Campo Obrigatório");
            edtCnpjTCF.requestFocus();
            existeErros = true;

        } else if (edtRazSocTCF.getText().toString().isEmpty()) {

            edtRazSocTCF.setError("Campo Obrigatório");
            edtRazSocTCF.requestFocus();
            existeErros = true;

        } else if (spnBancoTCF.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnBancoTCF.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        } else if (edtAgenciaTCF.getText().toString().isEmpty()) {

            edtAgenciaTCF.setError("Campo Obrigatório");
            edtAgenciaTCF.requestFocus();
            existeErros = true;

        } else if (edtCcTCF.getText().toString().isEmpty()) {

            edtCcTCF.setError("Campo Obrigatório");
            edtCcTCF.requestFocus();
            existeErros = true;

        } else if (edtCepTCF.getText().toString().isEmpty()) {

            edtCepTCF.setError("Campo Obrigatório");
            edtCepTCF.requestFocus();
            existeErros = true;

        } else if (spnCttTCF.getSelectedItem().toString().equals("Selecione uma Opção")) {

            ((TextView) spnCttTCF.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;

        }

        return existeErros;
    }

}