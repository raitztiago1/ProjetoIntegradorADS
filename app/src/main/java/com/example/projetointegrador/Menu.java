package com.example.projetointegrador;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    Button btRealizaSimTMU, btConsultaSimTMU, btSairTMU;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        inicializaComponentes();

        btRealizaSimTMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent simulacao = new Intent(getApplicationContext(), SimulacaoEmprestimo.class);
                startActivity(simulacao);

            }
        });


        btSairTMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voltar = new Intent(getApplicationContext(), Login.class);
                voltar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                voltar.putExtra("EXIT", true);
                startActivity(voltar);

            }
        });

    }

    private void inicializaComponentes() {

        btRealizaSimTMU = findViewById(R.id.btRealizaSimTMU);
        btConsultaSimTMU = findViewById(R.id.btConsultaSimTMU);
        btSairTMU = findViewById(R.id.btSairTMU);

    }
}