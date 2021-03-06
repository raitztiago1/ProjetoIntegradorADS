package com.es21.projetointegrador.http;

import com.es21.projetointegrador.model.Usuario;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperUsuario {
    private static final String urlApi = "https://rest-api-projeto-integrador.herokuapp.com/usuario";

    //busca tudo da tabela usuario e tranforma em uma List do tipo Usuario (Ajustar)
    public String getUsuarioAll() {
        BufferedReader buffReader = null;
        try {
            URL url = new URL(urlApi + "/all");
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

    //busca usuario e tranforma o retorno em um Objeto do tipo Usuario
    public String getUsuario(String cpfLocal) {
        BufferedReader buffReader = null;
        try {
            URL url = new URL(urlApi + "?cpf_usuario=" + cpfLocal);
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

    //Reliza post no usuario
    public String postUsuario(Usuario user) {
        BufferedReader buffReader = null;
        try {
            Gson g = new Gson();
            String json = g.toJson(user);
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
}

