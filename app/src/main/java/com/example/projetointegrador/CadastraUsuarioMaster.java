package com.example.projetointegrador;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelperUsuario;
import com.example.projetointegrador.model.Usuario;

public class CadastraUsuarioMaster extends AppCompatActivity {

    private final HttpHelperUsuario controleUsuario = new HttpHelperUsuario();
    Button btConfirmaTCUM, btVoltarTCUM;
    Spinner spnEstadoUserTCUM, spnCargoTCUM;
    EditText edtCpfTCUM, edtOrgaoEmissorTCUM, edtCidadeTCUM, edtNomeTCUM, edtCelTCUM, edtTelComTCUM, edtEmailTCUM, edtSenhaTCUM, edtRptSenhaTCUM;
    String[] estadoUsuario = new String[]{"Estado de Usuário", "Ativo", "Inativo"};
    String[] cargoUsusario = new String[]{"Cargo de usuário", "Administrador", "Usuario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastra_usuario_master);
        setTitle("Cadastra Usuarios");
        inicializarComponentes();
        escolhaTipoUser();
        escolhaStatusUser();

        btConfirmaTCUM.setOnClickListener((view -> {
            if (!validaDados()) {
                TarefaUsuarioPost tarefaPost = new TarefaUsuarioPost();
                tarefaPost.execute();
            }
        }));

        btVoltarTCUM.setOnClickListener(view -> finish());

    }

    //tranforma dados da tela em um objeto
    private Usuario criarObjeto() {
        String cpf = edtCpfTCUM.getText().toString();
        String nome = edtNomeTCUM.getText().toString();
        String celular = edtCelTCUM.getText().toString();
        String telefoneComercial = edtTelComTCUM.getText().toString();
        String email = edtEmailTCUM.getText().toString();
        String senha = edtSenhaTCUM.getText().toString();
        String senhaVerficicacao = edtRptSenhaTCUM.getText().toString();
        String estadoUser = spnEstadoUserTCUM.getSelectedItem().toString();
        String cargoUser = spnCargoTCUM.getSelectedItem().toString();
        String orgaoEmissor = edtOrgaoEmissorTCUM.getText().toString();
        String cidadeNatural = edtCidadeTCUM.getText().toString();
        String dataNascimento = null;
        String dataEmissaoDocumento = null;
        String dataValidade = null;
        String tipoDocumento = null;
        String numeroDocumento = null;
        if (verificacoes(senha, senhaVerficicacao, cpf)) {
            return new Usuario(
                    cpf,
                    nome,
                    estadoUser,
                    celular,
                    telefoneComercial,
                    email,
                    senha,
                    dataNascimento,
                    dataEmissaoDocumento,
                    dataValidade,
                    tipoDocumento,
                    numeroDocumento,
                    orgaoEmissor,
                    cidadeNatural,
                    cargoUser
            );
        } else {
            System.out.println("erro na criacao objeto");
            return null;
        }
    }

    //verifica os dados gerados para autenticacoes do objeto
    private Boolean verificacoes(String senha, String senhaRepetida, String cpf) {
        Autenticacoes aut = new Autenticacoes();
        if (aut.validaDocumento(cpf)) {
            if (senha.equals(senhaRepetida)) {
                return true;
            } else {
                return false;
            }
        } else {
            System.out.println("erro nas verificacoes de dados (cpf e senha)");
            return false;
        }
    }

    private void inicializarComponentes() {

        btConfirmaTCUM = findViewById(R.id.btConfirmaTCUM);
        btVoltarTCUM = findViewById(R.id.btVoltarTCUM);

        spnEstadoUserTCUM = findViewById(R.id.spnEstadoUserTCUM);
        spnCargoTCUM = findViewById(R.id.spnCargoTCUM);

        edtCpfTCUM = findViewById(R.id.edtCpfTCUM);
        edtOrgaoEmissorTCUM = findViewById(R.id.edtOrgaoEmissorTCUM);
        edtCidadeTCUM = findViewById(R.id.edtCidadeTCUM);
        edtNomeTCUM = findViewById(R.id.edtNomeTCUM);
        edtCelTCUM = findViewById(R.id.edtCelTCUM);
        edtTelComTCUM = findViewById(R.id.edtTelComTCUM);
        edtEmailTCUM = findViewById(R.id.edtEmailTCUM);
        edtSenhaTCUM = findViewById(R.id.edtSenhaTCUM);
        edtRptSenhaTCUM = findViewById(R.id.edtRptSenhaTCUM);

    }

    private void escolhaTipoUser() {
        spnEstadoUserTCUM.setAdapter(new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.textview_spinner,
                estadoUsuario
        ));
    }

    private void escolhaStatusUser() {
        spnCargoTCUM.setAdapter(new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.textview_spinner,
                cargoUsusario
        ));
    }

    private void limpaCampos() {

        edtCpfTCUM.setText("");
        edtOrgaoEmissorTCUM.setText("");
        edtCidadeTCUM.setText("");
        edtNomeTCUM.setText("");
        edtCelTCUM.setText("");
        edtTelComTCUM.setText("");
        edtEmailTCUM.setText("");
        edtSenhaTCUM.setText("");
        edtRptSenhaTCUM.setText("");

        spnEstadoUserTCUM.setSelection(0);
        spnCargoTCUM.setSelection(0);
    }

    private boolean validaDados() {

        boolean existeErros = false;

        if (edtCpfTCUM.getText().toString().isEmpty()) {

            edtCpfTCUM.setError("Campo Obrigatório");
            edtCpfTCUM.requestFocus();
            existeErros = true;

        } else if (edtOrgaoEmissorTCUM.getText().toString().isEmpty()) {

            edtOrgaoEmissorTCUM.setError("Campo Obrigatório");
            edtOrgaoEmissorTCUM.requestFocus();
            existeErros = true;

        } else if (edtCidadeTCUM.getText().toString().isEmpty()) {

            edtCidadeTCUM.setError("Campo Obrigatório");
            edtCidadeTCUM.requestFocus();
            existeErros = true;

        } else if (edtNomeTCUM.getText().toString().isEmpty()) {

            edtNomeTCUM.setError("Campo Obrigatório");
            edtNomeTCUM.requestFocus();
            existeErros = true;

        } else if (spnEstadoUserTCUM.getSelectedItem().toString().equals(estadoUsuario[0])) {

            ((TextView) spnEstadoUserTCUM.getSelectedView()).setError("Campo Obrigatório");
            spnEstadoUserTCUM.requestFocus();
            existeErros = true;

        } else if (edtCelTCUM.getText().toString().isEmpty()) {

            edtCelTCUM.setError("Campo Obrigatório");
            edtCelTCUM.requestFocus();
            existeErros = true;

        } else if (edtTelComTCUM.getText().toString().isEmpty()) {

            edtTelComTCUM.setError("Campo Obrigatório");
            edtTelComTCUM.requestFocus();
            existeErros = true;

        } else if (edtEmailTCUM.getText().toString().isEmpty()) {

            edtEmailTCUM.setError("Campo Obrigatório");
            edtEmailTCUM.requestFocus();
            existeErros = true;

        } else if (edtSenhaTCUM.getText().toString().isEmpty()) {

            edtSenhaTCUM.setError("Campo Obrigatório");
            edtSenhaTCUM.requestFocus();
            existeErros = true;

        } else if (edtRptSenhaTCUM.getText().toString().isEmpty()) {

            edtRptSenhaTCUM.setError("Campo Obrigatório");
            edtRptSenhaTCUM.requestFocus();
            existeErros = true;

        } else if (spnCargoTCUM.getSelectedItem().toString().equals(cargoUsusario[0])) {

            ((TextView) spnCargoTCUM.getSelectedView()).setError("Campo Obrigatório");
            spnCargoTCUM.requestFocus();
            existeErros = true;

        }
        return existeErros;
    }

    //realiza o processamento dos dados(post)
    private class TarefaUsuarioPost extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            Usuario user = criarObjeto();
            if (user != null) {
                return controleUsuario.postUsuario(user);
            } else {
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            AlertDialog.Builder alerta = new AlertDialog.Builder(CadastraUsuarioMaster.this);
            alerta.setNeutralButton("OK", null);
            if (s != null) {
                limpaCampos();
                alerta.setTitle("Sucesso");
                alerta.setMessage("Cadastro realizado com sucesso!");
                alerta.show();
            } else {
                alerta.setTitle("Cadastro error");
                alerta.setMessage("Erro no cadastro, verifique os dados e tente novamente!");
                alerta.show();
            }
        }
    }
}