package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuMaster extends AppCompatActivity {

    Button btCadUserMasterTMM, btCadFinanTMM, btListaEmpresasTMM, btListaUserTMM, btListaSimulaTMM, btSairTMM;
    TextView txtTMM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_master);

        inicializarComponentes();

        btCadUserMasterTMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaCadUser = new Intent(getApplicationContext(), CadastraUsuarioMaster.class);
                startActivity(telaCadUser);

            }
        });

        btCadFinanTMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaCadFinan = new Intent(getApplicationContext(), CadastroFinanceira.class);
                startActivity(telaCadFinan);

            }
        });

        btListaUserTMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent telaListaUser = new Intent(getApplicationContext(), ListarUsuario.class);
                startActivity(telaListaUser);

            }
        });

        btListaEmpresasTMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaListarEmpresas = new Intent(getApplicationContext(), ListarEmpresas.class);
                startActivity(telaListarEmpresas);

            }
        });

        btListaSimulaTMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaListarSimulacoes = new Intent(getApplicationContext(), ListarSimulacoes.class);
                startActivity(telaListarSimulacoes);

            }
        });

        btSairTMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voltar = new Intent(getApplicationContext(), Login.class);
                voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                voltar.putExtra("EXIT", true);
                startActivity(voltar);

            }
        });
    }

    private void inicializarComponentes() {

        btCadUserMasterTMM = findViewById(R.id.btCadUserMasterTMM);
        btCadFinanTMM = findViewById(R.id.btCadFinanTMM);
        btListaEmpresasTMM = findViewById(R.id.btListaEmpresasTMM);
        btListaUserTMM = findViewById(R.id.btListaUserTMM);
        btListaSimulaTMM = findViewById(R.id.btListaSimulaTMM);
        btSairTMM = findViewById(R.id.btSairTMM);

        txtTMM = findViewById(R.id.txtTMM);

    }
}