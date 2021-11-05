package com.example.projetointegrador.http;

import com.example.projetointegrador.model.Cep;
import com.example.projetointegrador.model.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParse {
    public static Usuario JsonToObject(String conteudo){
        try{
            JSONObject jsonObject = null;
            jsonObject = new JSONObject(conteudo);

            Usuario  usuario = new Usuario(
                    jsonObject.getString("cpf_usuario"),
                    jsonObject.getString("nome_contato"),
                    jsonObject.getString("estado_usuario"),
                    jsonObject.getString("telefone_celular"),
                    jsonObject.getString("telefone_comercial"),
                    jsonObject.getString("email"),
                    jsonObject.getString("senha"),
                    jsonObject.getString("data_nascimento"),
                    jsonObject.getString("data_emissao_documento"),
                    jsonObject.getString("data_validade"),
                    jsonObject.getString("tipo_documento"),
                    jsonObject.getString("numero_documento"),
                    jsonObject.getString("orgao_emissor_documento"),
                    jsonObject.getString("natural_cidade"),
                    jsonObject.getString("cargo")
            );

            return usuario;
        }catch (Exception e){
            return null;
        }
    }

    public static List<Usuario> JsonToList(String conteudo){
        try{
            List<Usuario> usuarioList= new ArrayList<>();
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;

            jsonArray = new JSONArray(conteudo);

            for(int x=0; x<jsonArray.length(); x++){
                jsonObject = jsonArray.getJSONObject(x);
                Usuario  usuario = new Usuario(
                        jsonObject.getString("cpf_usuario"),
                        jsonObject.getString("nome_contato"),
                        jsonObject.getString("estado_usuario"),
                        jsonObject.getString("telefone_celular"),
                        jsonObject.getString("telefone_comercial"),
                        jsonObject.getString("email"),
                        jsonObject.getString("senha"),
                        jsonObject.getString("data_nascimento"),
                        jsonObject.getString("data_emissao_documento"),
                        jsonObject.getString("data_validade"),
                        jsonObject.getString("tipo_documento"),
                        jsonObject.getString("numero_documento"),
                        jsonObject.getString("orgao_emissor_documento"),
                        jsonObject.getString("natural_cidade"),
                        jsonObject.getString("cargo")
                );
                usuarioList.add(usuario);
            }

            return usuarioList;
        }catch (Exception e){
            return null;
        }
    }

    public static Cep JsonToObjectCep(String conteudo){
        try{
            JSONObject jsonObject = null;
            jsonObject = new JSONObject(conteudo);
            return new Cep(
                    jsonObject.getString("cep"),
                    jsonObject.getString("logradouro"),
                    jsonObject.getString("complemento"),
                    jsonObject.getString("bairro"),
                    jsonObject.getString("localidade"),
                    jsonObject.getString("uf")
            );
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
