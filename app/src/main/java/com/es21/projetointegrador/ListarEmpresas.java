package com.es21.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.es21.projetointegrador.http.HttpHelperLoja;
import com.es21.projetointegrador.http.JsonParse;
import com.es21.projetointegrador.model.Loja;
import com.example.projetointegrador.R;

import java.util.ArrayList;
import java.util.List;

public class ListarEmpresas extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    private static ListView lvEmpresasTLE;

    Button btVoltarTLE;

    private static ArrayList<String> preencherDados(String s) {

        ArrayList<String> novaLista = new ArrayList<>();

        List<Loja> listaLoja;
        listaLoja = JsonParse.JsonToListLoja(s);
        for (int x = 0; x < listaLoja.size(); x++) {

            novaLista.add(listaLoja.get(x).toString());

        }
        return novaLista;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_empresas);
        setTitle("Listar Empresas");
        inicializaComponentes();

        TarefaLojaAll tarefaLojaAll = new TarefaLojaAll();
        tarefaLojaAll.execute();

        btVoltarTLE.setOnClickListener(v -> finish());
    }

    private void inicializaComponentes() {

        lvEmpresasTLE = findViewById(R.id.lvEmpresasTLE);

        btVoltarTLE = findViewById(R.id.btVoltarTLE);

    }

    @SuppressLint("StaticFieldLeak")
    private class TarefaLojaAll extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperLoja controleUsuario = new HttpHelperLoja();
            return controleUsuario.getLojaAll();
        }

        @Override
        protected void onPostExecute(String s) {

            ArrayList<String> preenche = preencherDados(s);

            ArrayAdapter<String> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(ListarEmpresas.this, android.R.layout.simple_list_item_1, preenche);
            lvEmpresasTLE.setAdapter(arrayAdapter);

        }
    }
}