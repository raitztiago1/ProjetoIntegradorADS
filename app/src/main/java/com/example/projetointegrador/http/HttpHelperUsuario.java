package com.example.projetointegrador.http;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperUsuario {
    private static final String urlApi = "https://rest-api-projeto-integrador.herokuapp.com/usuario";

    public void getAll(){
        TarefaAll tarefaUsuarioAll = new TarefaAll();
        tarefaUsuarioAll.execute();
    }

    private static class TarefaAll extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelperUsuario controleUsuario = new HttpHelperUsuario();
            return controleUsuario.getUsuarioAll();
        }

        @Override
        protected void onPostExecute(String s) {
            System.out.println(s);
            //super.onPostExecute(s);
        }
    }

//busca tudo da tabela usuario e tranforma em uma List do tipo Usuario (Ajustar)
    private String getUsuarioAll(){
        BufferedReader buffReader = null;
        try{
            URL url = new URL(urlApi+"/all");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();

            while ((linha=buffReader.readLine()) != null){
                stringBuilder.append(linha).append("\n");
            }
            return stringBuilder.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(buffReader!=null){
                try{

                    buffReader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

//busca usuario e tranforma o retorno em um Objeto do tipo Usuario
    public String getUsuario(String cpfLocal){
        BufferedReader buffReader = null;
        try{
            URL url = new URL(urlApi+"?cpf_usuario="+cpfLocal);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();

            while ((linha=buffReader.readLine()) != null){
                stringBuilder.append(linha).append("\n");
            }
            return stringBuilder.toString();

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally {
            if(buffReader!=null){
                try{
                    buffReader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

