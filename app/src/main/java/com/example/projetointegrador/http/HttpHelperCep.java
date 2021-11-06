package com.example.projetointegrador.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperCep {
    private static final String urlApi = "https://viacep.com.br/ws/";


    public String getDadosCep(String cep) {
        BufferedReader buffReader = null;

        try {
            URL url = new URL(urlApi + cep + "/json");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();


            while ((linha = buffReader.readLine()) != null) {
                stringBuilder.append(linha).append("\n");
            }
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (buffReader != null) {
                try {
                    buffReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

