package com.es21.projetointegrador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.es21.projetointegrador.http.HttpHelperSimulacao;
import com.es21.projetointegrador.http.JsonParse;
import com.es21.projetointegrador.model.Simulacao;
import com.example.projetointegrador.R;

import java.util.ArrayList;
import java.util.List;

public class ListarSimulacoes extends AppCompatActivity {
    private static ListView lvSimulacoesTLS;
    private Button btVoltarTLS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_simulacoes);
        inicializaComponentes();
        TarefaSimulacoesAll tarefa = new TarefaSimulacoesAll();
        tarefa.execute();

        btVoltarTLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void inicializaComponentes() {

        lvSimulacoesTLS = findViewById(R.id.lvSimulacoesTLS);

        btVoltarTLS = findViewById(R.id.btVoltarTLS);

    }

    private class TarefaSimulacoesAll extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperSimulacao simulacao = new HttpHelperSimulacao();
            return simulacao.getSimulacao(getIntent().getStringExtra("cpf"));
        }

        @Override
        protected void onPostExecute(String s) {
            ArrayList<String> asdf = preencherDados(s);

            ArrayAdapter<String> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(ListarSimulacoes.this, android.R.layout.simple_list_item_1, asdf);
            lvSimulacoesTLS.setAdapter(arrayAdapter);

        }
    }

    private static ArrayList<String> preencherDados(String s) {
        ArrayList<String> teste = new ArrayList<>();

        List<Simulacao> listaSimulacao;
        listaSimulacao = JsonParse.JsonToListSimulacao(s);
        for (int x = 0; x < listaSimulacao.size(); x++) {
            teste.add(listaSimulacao.get(x).toString());
        }
        return teste;
    }
}

