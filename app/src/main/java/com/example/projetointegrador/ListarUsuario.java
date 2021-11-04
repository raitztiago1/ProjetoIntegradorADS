package com.example.projetointegrador;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListarUsuario extends AppCompatActivity {

    ListView lvUsuarioTLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_usuario);

        setTitle("Lista de Usuario");

        inicializaComponentes();

        ArrayList<String> listaEmpresas = preencherDados();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaEmpresas);
        lvUsuarioTLE.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("teste 1");
        dados.add("teste 2");
        dados.add("teste 3");
        dados.add("teste 4");
        dados.add("teste 5");
        dados.add("teste 6");
        dados.add("teste 7");
        dados.add("teste 8");
        dados.add("teste 9");
        dados.add("teste 10");
        return dados;
    }

    private void inicializaComponentes() {

        lvUsuarioTLE = findViewById(R.id.lvUsuarioTLE);

    }

}