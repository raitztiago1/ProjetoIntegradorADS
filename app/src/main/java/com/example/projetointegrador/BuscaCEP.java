package com.example.projetointegrador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BuscaCEP {

    public static String getDadosCep(String uri) {
        BufferedReader bufferedReader = null;

        try {

            URL url = new URL(uri);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            String linha;
            while((linha = bufferedReader.readLine()) != null){

                sb.append(linha+"\n");

            }

            return sb.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

