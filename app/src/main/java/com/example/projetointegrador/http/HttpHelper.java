package com.example.projetointegrador.http;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpHelper {
    private boolean status;

    public void conectar(String json) {
        new HttpHelper().get(json);
        System.out.println("Connection Result :" + status);
    }

    public void get(String json) {

        Thread tc = new Thread(new Runnable() {
            public void run() {
                try {
                    String URL = "https://rest-api-projeto-integrador.herokuapp.com/";

                    MediaType headerHttp = MediaType.parse("application/json; charset=utf-8");

                    RequestBody body = RequestBody.create(headerHttp, json);

                    Request request = new Request.Builder().url(URL).get().build();

                    OkHttpClient client = new OkHttpClient();

                    Response resposta = client.newCall(request).execute();

                    System.out.println("\n\n\t\t"+resposta+"\n\n\t\t");

                } catch (Exception e) {
                    status = false;
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        tc.start();
        try {
            tc.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }
}
