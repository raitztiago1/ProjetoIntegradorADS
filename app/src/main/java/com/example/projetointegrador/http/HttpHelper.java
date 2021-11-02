package com.example.projetointegrador.http;

import android.os.AsyncTask;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpHelper {
    private static String URL = "https://rest-api-projeto-integrador.herokuapp.com/";
    private static String jsonlocal;

    public void HttpHelper(String json) {
        jsonlocal = json;
        TarefaStart tarefaStart = new TarefaStart();
        tarefaStart.execute();
    }

    private class TarefaStart extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelper controleStart = new HttpHelper();
            String retorno = controleStart.getStartApi(jsonlocal);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s) {
            System.out.println(s);
        }
    }

    private String getStartApi(String json){
                try {
                    MediaType headerHttp = MediaType.parse("application/json; charset=utf-8");

                    RequestBody body = RequestBody.create(headerHttp, json);

                    Request request = new Request.Builder().url(URL).get().build();

                    OkHttpClient client = new OkHttpClient();

                    Response resposta = client.newCall(request).execute();

                   return resposta.toString();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    return  null;
                }
        }
    }
