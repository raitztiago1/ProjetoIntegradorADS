package com.es21.projetointegrador;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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

        btVoltarTLS.setOnClickListener(view -> {
            String acesso = getIntent().getStringExtra("acesso");
            if(acesso != null){
                String cpf = getIntent().getStringExtra("cpf");
                Intent menuMaster = new Intent(ListarSimulacoes.this,MenuMaster.class);
                menuMaster.putExtra("cpf", cpf);
                startActivity(menuMaster);
                finish();
            }else{
                String cpf = getIntent().getStringExtra("cpf");
                Intent menu = new Intent(ListarSimulacoes.this,Menu.class);
                menu.putExtra("cpf", cpf);
                startActivity(menu);
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
            String acesso = getIntent().getStringExtra("acesso");
            if(acesso != null){
                return simulacao.getSimulcaoAll();
            }else{
                return simulacao.getSimulacao(getIntent().getStringExtra("cpf"));
            }
        }

        @Override
        protected void onPostExecute(String s) {
            ArrayList<String> asdf = preencherDados(s);

            ArrayAdapter<String> arrayAdapter;
            arrayAdapter = new ArrayAdapter<>(ListarSimulacoes.this, android.R.layout.simple_list_item_1, asdf);
            lvSimulacoesTLS.setAdapter(arrayAdapter);

        }
    }

    private ArrayList<String> preencherDados(String s) {
        ArrayList<String> teste = new ArrayList<>();

        List<Simulacao> listaSimulacao;
        listaSimulacao = JsonParse.JsonToListSimulacao(s);
        String acesso = getIntent().getStringExtra("acesso");
        if(acesso != null){
            for (int x = 0; x < listaSimulacao.size(); x++) {
                teste.add(listaSimulacao.get(x).toStringMaster());
            }
        }else{
            for (int x = 0; x < listaSimulacao.size(); x++) {
                teste.add(listaSimulacao.get(x).toString());
            }
        }

        return teste;
    }
}

