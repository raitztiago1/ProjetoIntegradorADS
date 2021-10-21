package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuMaster extends AppCompatActivity {
    Button btCadUserClinicaTM, btCadFinanTM, btListaEmpresasTM, btListaUserTM, btListaSimulTM, btSairTM;
    TextView txtMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_master);

        inicializarComponentes();

        btSairTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btCadUserClinicaTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCadUser = new Intent(getApplicationContext(), CadastraUsuario.class);
                startActivity(telaCadUser);
            }
        });
    }

    private void inicializarComponentes() {
        btCadUserClinicaTM = findViewById(R.id.btCadUserClinicaTMM);
        btCadFinanTM = findViewById(R.id.btCadFinanTMM);
        btListaEmpresasTM = findViewById(R.id.btListaEmpresasTMM);
        btListaUserTM = findViewById(R.id.btListaUserTMM);
        btListaSimulTM = findViewById(R.id.btListaSimulTMM);
        btSairTM = findViewById(R.id.btSairTMM);

        txtMenu = findViewById(R.id.txtMenu);
    }
}