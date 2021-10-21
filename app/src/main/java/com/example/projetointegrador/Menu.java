package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    Button btCadUserClinicaTM, btCadFinanTM, btListaEmpresasTM, btListaUserTM, btListaSimulTM, btSairTM;
    TextView txtMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

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
        btCadUserClinicaTM = findViewById(R.id.btCadUserClinicaTM);
        btCadFinanTM = findViewById(R.id.btCadFinanTM);
        btListaEmpresasTM = findViewById(R.id.btListaEmpresasTM);
        btListaUserTM = findViewById(R.id.btListaUserTM);
        btListaSimulTM = findViewById(R.id.btListaSimulTM);
        btSairTM = findViewById(R.id.btSairTM);

        txtMenu = findViewById(R.id.txtMenu);
    }

}