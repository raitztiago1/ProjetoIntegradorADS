package com.es21.projetointegrador.http;

import com.es21.projetointegrador.model.Loja;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperLoja {

    private static final String urlApi = "https://rest-api-projeto-integrador.herokuapp.com/loja";
    private static final String urlApiAll = "https://rest-api-projeto-integrador.herokuapp.com/loja/all";
    private static final String urlApiLoja = "https://rest-api-projeto-integrador.herokuapp.com/loja/razao_social?razao_social=";

    public String getLoja(String loja) {
        BufferedReader buffReader = null;

        try {
            URL url = new URL(urlApiLoja + loja);
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

    public String postLoja(Loja loja) {

        BufferedReader buffReader = null;

        try {
            Loja store = new Loja(
                    loja.getCnpj_loja(),
                    loja.getStatus_loja(),
                    loja.getTipo_loja(),
                    loja.getInscricao_estadual(),
                    loja.getInscricao_municipal(),
                    loja.getRamo_negocio(),
                    loja.getMotivo_aprovacao(),
                    loja.getPercentual_clipse(),
                    loja.getRazao_social(),
                    loja.getSite()
            );


            Gson g = new Gson();
            String json = g.toJson(store);
            URL url = new URL(urlApi);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setDoOutput(true);

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

    public String getLojaAll() {
        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlApiAll);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();

            while ((linha = bufferedReader.readLine()) != null) {
                stringBuilder.append(linha).append("\n");
            }
            return stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
