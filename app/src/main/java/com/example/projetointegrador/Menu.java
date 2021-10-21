package com.example.projetointegrador;

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



        btSairTMU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializaComponentes() {

        btRealizaSimTMU = findViewById(R.id.btRealizaSimTMU);
        btConsultaSimTMU = findViewById(R.id.btConsultaSimTMU);
        btSairTMU = findViewById(R.id.btSairTMU);

    }
}