package com.es21.projetointegrador.http;

import android.os.AsyncTask;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpHelper {
    private static final String URL = "https://rest-api-projeto-integrador.herokuapp.com/";

    public void HttpHelperStart() {
        TarefaStart tarefaStart = new TarefaStart();
        tarefaStart.execute();
    }

    private static class TarefaStart extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            HttpHelper controleStart = new HttpHelper();
            return controleStart.getStartApi();
        }

        @Override
        protected void onPostExecute(String s) {
            System.out.println(s);
        }
    }

    private String getStartApi() {
        try {
            Request request = new Request.Builder().url(URL).get().build();

            OkHttpClient client = new OkHttpClient();

            Response resposta = client.newCall(request).execute();

            return resposta.toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
