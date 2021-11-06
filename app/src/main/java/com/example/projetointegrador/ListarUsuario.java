package com.example.projetointegrador;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelperUsuario;
import com.example.projetointegrador.http.JsonParse;
import com.example.projetointegrador.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListarUsuario extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    private static ListView lvUsuarioTLE;

    Button btSairTLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_usuario);
        setTitle("Lista de Usuario");
        inicializaComponentes();

        TarefaUsuarioAll tarefaUsuarioAll = new TarefaUsuarioAll();
        tarefaUsuarioAll.execute();

        btSairTLE.setOnClickListener(view -> finish());

    }

    private void inicializaComponentes() {

        lvUsuarioTLE = findViewById(R.id.lvUsuarioTLE);

        btSairTLE = findViewById(R.id.btSairTLE);

    }

    @SuppressLint("StaticFieldLeak")
    private class TarefaUsuarioAll extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperUsuario controleUsuario = new HttpHelperUsuario();
            return controleUsuario.getUsuarioAll();
        }

        @Override
        protected void onPostExecute(String s) {

            ArrayList<String> asdf = preencherDados(s);

            ArrayAdapter<String> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(ListarUsuario.this, android.R.layout.simple_list_item_1, asdf);
            lvUsuarioTLE.setAdapter(arrayAdapter);

        }
    }
    private static ArrayList<String> preencherDados(String s){
        ArrayList<String> teste = new ArrayList<>();

        List<Usuario> listaUsuario;
        listaUsuario = JsonParse.JsonToList(s);
        for (int x = 0; x < listaUsuario.size(); x++) {

            teste.add(listaUsuario.get(x).toString());

        }
        return teste;
    }

}