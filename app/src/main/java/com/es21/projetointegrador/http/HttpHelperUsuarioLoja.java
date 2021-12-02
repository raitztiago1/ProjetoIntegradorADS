package com.es21.projetointegrador.http;

import com.es21.projetointegrador.model.Simulacao;
import com.es21.projetointegrador.model.UsuarioLoja;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperUsuarioLoja {
    private final static String urlApi = "https://rest-api-projeto-integrador.herokuapp.com/usuario/loja";
    private int TIMEOUT_VALUE = 1000;

    public String postUsuarioLoja(UsuarioLoja usuario){
        BufferedReader buffReader = null;
        try {
            Gson g = new Gson();
            String json = g.toJson(usuario);
            URL url = new URL(urlApi);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout(TIMEOUT_VALUE);
            urlConnection.setReadTimeout(TIMEOUT_VALUE);

            DataOutputStream dados = new DataOutputStream(urlConnection.getOutputStream());
            dados.writeBytes(json);
            dados.flush();
            dados.close();

            int responseCode = urlConnection.getResponseCode();
            System.out.println("resposta da requisicao: " + responseCode);

            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = buffReader.readLine()) != null) {
                response.append(inputLine).append("\n");
            }
            return response.toString();

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
