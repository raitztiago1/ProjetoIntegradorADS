package com.example.projetointegrador;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CadastraUsuario extends AppCompatActivity {

    Button btPesquisacpfTCU, btCancelaTCU, btConfirmaTCU;
    Spinner spnTipoUsuarioTCU, spnStatusUserTCU;
    EditText edtCpfTCU, edtUserTCU, edtEmailTCU, edtTelCelTCU, pswDigiteSenhaTCU, pswRepetirSenhaTCU;
    TextView txtUserLojaTCU;

    String[] tipoUsuario = new String[]{"Selecione uma Opção", "Tipo 1", "Tipo 2", "Tipo 3", "Tipo 4"};
    String[] statusUsuario = new String[]{"Selecione uma Opção", "Status 1", "Status 2", "Status 3", "Status 4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_usuario);
        setTitle("Cadastra Usuarios");

        inicializarComponentes();
        escolhaTipoUser();
        escolhaStatusUser();

        btConfirmaTCU.setOnClickListener((view -> {
            if (!validaDados()) {
                String tipoUser = spnTipoUsuarioTCU.getSelectedItem().toString();
                String statusUser = spnStatusUserTCU.getSelectedItem().toString();
                txtUserLojaTCU.setText(tipoUser + statusUser);//só pra verificar se está funcionando, por função depois
                limpaCampos();
            } else {

            }
        }));

        btCancelaTCU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializarComponentes() {

        edtCpfTCU = findViewById(R.id.edtCpfTCU);
        edtUserTCU = findViewById(R.id.edtUserTCU);
        edtEmailTCU = findViewById(R.id.edtEmailTCU);
        edtTelCelTCU = findViewById(R.id.edtTelCelTCU);
        pswDigiteSenhaTCU = findViewById(R.id.pswDigiteSenhaTCU);
        pswRepetirSenhaTCU = findViewById(R.id.pswRepetirSenhaTCU);

        btCancelaTCU = findViewById(R.id.btCancelaTCU);
        btConfirmaTCU = findViewById(R.id.btConfirmaTCU);
        btPesquisacpfTCU = findViewById(R.id.btPesquisacpfTCU);

        spnTipoUsuarioTCU = findViewById(R.id.spnTipoUsuarioTCU);
        spnStatusUserTCU = findViewById(R.id.spnStatusUserTCU);

        txtUserLojaTCU = findViewById(R.id.txtUserLojaTCU);

    }

    private void escolhaTipoUser() {
        spnTipoUsuarioTCU.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.textview_spinner,
                tipoUsuario
        ));
    }

    private void escolhaStatusUser() {
        spnStatusUserTCU.setAdapter(new ArrayAdapter<String>(
                getApplicationContext(),
                R.layout.textview_spinner,
                statusUsuario
        ));
    }

    private void limpaCampos() {
        edtCpfTCU.setText("");
        edtUserTCU.setText("");
        edtEmailTCU.setText("");
        edtTelCelTCU.setText("");
        pswDigiteSenhaTCU.setText("");
        pswRepetirSenhaTCU.setText("");
        spnTipoUsuarioTCU.setSelection(0);
        spnStatusUserTCU.setSelection(0);
    }

    private boolean validaDados() {

        Boolean existeErros = false;

        if (edtCpfTCU.getText().toString().isEmpty()) {
            edtCpfTCU.setError("Campo Obrigatório");
            edtCpfTCU.requestFocus();
            existeErros = true;
        } else if (spnTipoUsuarioTCU.getSelectedItem().toString().equals("Selecione uma Opção")) {
            ((TextView) spnTipoUsuarioTCU.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;
        } else if (edtUserTCU.getText().toString().isEmpty()) {
            edtUserTCU.setError("Campo Obrigatório");
            edtUserTCU.requestFocus();
            existeErros = true;
        } else if (edtEmailTCU.getText().toString().isEmpty()) {
            edtEmailTCU.setError("Campo Obrigatório");
            edtEmailTCU.requestFocus();
            existeErros = true;
        } else if (edtTelCelTCU.getText().toString().isEmpty()) {
            edtTelCelTCU.setError("Campo Obrigatório");
            edtTelCelTCU.requestFocus();
            existeErros = true;
        } else if (spnStatusUserTCU.getSelectedItem().toString().equals("Selecione uma Opção")) {
            ((TextView) spnStatusUserTCU.getSelectedView()).setError("Campo Obrigatório");
            existeErros = true;
        } else if (pswDigiteSenhaTCU.getText().toString().isEmpty()) {
            pswDigiteSenhaTCU.setError("Campo Obrigatório");
            pswDigiteSenhaTCU.requestFocus();
            existeErros = true;
        } else if (pswRepetirSenhaTCU.getText().toString().isEmpty()) {
            pswRepetirSenhaTCU.setError("Campo Obrigatório");
            pswRepetirSenhaTCU.requestFocus();
            existeErros = true;
        }
        return existeErros;
    }
}