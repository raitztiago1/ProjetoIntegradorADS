package com.example.projetointegrador;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetointegrador.http.HttpHelperUsuario;
import com.example.projetointegrador.http.JsonParse;
import com.example.projetointegrador.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListarUsuario extends AppCompatActivity {

    private static ListView lvUsuarioTLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_usuario);
        setTitle("Lista de Usuario");
        inicializaComponentes();

        TarefaUsuarioAll tarefaUsuarioAll = new TarefaUsuarioAll();
        tarefaUsuarioAll.execute();
    }

    private static class TarefaUsuarioAll extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperUsuario controleUsuario = new HttpHelperUsuario();
            return controleUsuario.getUsuarioAll();
        }

        @Override
        protected void onPostExecute(String s) {
            List<Usuario> listaUsuario = new ArrayList<>();
            listaUsuario = JsonParse.JsonToList(s);
            for (int x=0; x<listaUsuario.size(); x++){
                System.out.println(listaUsuario.get(x).toString());
            }
            //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaUsuario);
            //lvUsuarioTLE.setAdapter(arrayAdapter);
        }
    }

    private void inicializaComponentes() {

        lvUsuarioTLE = findViewById(R.id.lvUsuarioTLE);

    }

}