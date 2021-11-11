package com.es21.projetointegrador.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperAuth {
    private final static String urlApi = "https://rest-api-projeto-integrador.herokuapp.com/auth";

    public String gerarToken(String cpfLocal, String email) {
        BufferedReader buffReader = null;
        try {
            URL url = new URL(urlApi + "/token" + "?cpf_usuario=" + cpfLocal + "&email=" + email);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();
            int responseCode = urlConnection.getResponseCode();


            while ((linha = buffReader.readLine()) != null) {
                stringBuilder.append(linha).append("\n");
            }
            return stringBuilder.toString() + responseCode;

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

    public String resetSenha(String cpfLocal, String email, String passwordToken, String senha) {
        BufferedReader buffReader = null;
        try {
            URL url = new URL(urlApi + "/senha" + "?cpf_usuario=" + cpfLocal + "&email=" + email + "&passwordToken=" + passwordToken + "&senha=" + senha);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();
            int responseCode = urlConnection.getResponseCode();
            while ((linha = buffReader.readLine()) != null) {
                stringBuilder.append(linha).append("\n");
            }
            return Integer.toString(responseCode);


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

    public String confereToken(String passwordToken) {
        BufferedReader buffReader = null;
        try {
            URL url = new URL(urlApi + "/token/confere?passwordToken=" + passwordToken);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            buffReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String linha;
            StringBuilder stringBuilder = new StringBuilder();
            int responseCode = urlConnection.getResponseCode();

            while ((linha = buffReader.readLine()) != null) {
                stringBuilder.append(linha).append("\n");
            }
            return Integer.toString(responseCode);

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

