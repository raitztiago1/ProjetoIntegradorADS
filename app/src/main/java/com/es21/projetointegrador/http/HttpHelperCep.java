package com.es21.projetointegrador.http;

import com.es21.projetointegrador.model.Cep;
import com.es21.projetointegrador.model.LojaEndereco;
import com.es21.projetointegrador.model.UsuarioEndereco;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelperCep {
    private static final String urlApi = "https://viacep.com.br/ws/";
    private static final String urlApiDatabaseUsuario = "https://rest-api-projeto-integrador.herokuapp.com/usuario/endereco";
    private static final String urlApiDatabaseLoja = "https://rest-api-projeto-integrador.herokuapp.com/loja/endereco";


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

    public String postEnderecoUsuario(Cep cep, String cpf){
        BufferedReader buffReader = null;
        try {
            UsuarioEndereco usuarioEndereco = new UsuarioEndereco(
                    cpf,
                    cep.getUf(),
                    cep.getCidade(),
                    cep.getBairro(),
                    cep.getTipo_logradouro(),
                    cep.getLogradouro(),
                    cep.getNumero(),
                    cep.getComplemento(),
                    cep.getCep()
            );

            Gson g = new Gson();
            String json = g.toJson(usuarioEndereco);
            URL url = new URL(urlApiDatabaseUsuario);

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

    public String postEnderecoLoja(Cep cep, String cnpj){
        BufferedReader buffReader = null;
        try {
            LojaEndereco lojaEndereco = new LojaEndereco(
                    cnpj,
                    cep.getUf(),
                    cep.getCidade(),
                    cep.getBairro(),
                    cep.getTipo_logradouro(),
                    cep.getLogradouro(),
                    cep.getNumero(),
                    cep.getComplemento(),
                    cep.getCep()
            );

            Gson g = new Gson();
            String json = g.toJson(lojaEndereco);
            URL url = new URL(urlApiDatabaseLoja);

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

