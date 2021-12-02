package com.es21.projetointegrador.http;

import com.es21.projetointegrador.model.Cep;
import com.es21.projetointegrador.model.Loja;
import com.es21.projetointegrador.model.Simulacao;
import com.es21.projetointegrador.model.Usuario;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParse {
    public static Usuario JsonToObject(String conteudo) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(conteudo);

            return new Usuario(
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
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Usuario> JsonToList(String conteudo) {
        try {
            List<Usuario> usuarioList = new ArrayList<>();
            JSONArray jsonArray;
            JSONObject jsonObject;

            jsonArray = new JSONArray(conteudo);

            for (int x = 0; x < jsonArray.length(); x++) {
                jsonObject = jsonArray.getJSONObject(x);
                Usuario usuario = new Usuario(
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
        } catch (Exception e) {
            return null;
        }
    }

    public static Cep JsonToObjectCep(String conteudo) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(conteudo);
            return new Cep(
                    jsonObject.getString("uf"),
                    jsonObject.getString("localidade"),
                    jsonObject.getString("bairro"),
                    "Rua",
                    jsonObject.getString("logradouro"),
                    "000",
                    jsonObject.getString("complemento"),
                    jsonObject.getString("cep")
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Simulacao> JsonToListSimulacao(String conteudo) {
        try {
            List<Simulacao> simulacaoList = new ArrayList<>();
            JSONArray jsonArray;
            JSONObject jsonObject;

            jsonArray = new JSONArray(conteudo);

            for (int x = 0; x < jsonArray.length(); x++) {
                jsonObject = jsonArray.getJSONObject(x);
                Simulacao simulacao = new Simulacao(
                        jsonObject.getString("cpf_usuario"),
                        jsonObject.getString("financeira"),
                        Double.parseDouble(jsonObject.getString("renda_mensal")),
                        Double.parseDouble(jsonObject.getString("valor_emprestimo")),
                        Double.parseDouble(jsonObject.getString("tarifa")),
                        Integer.parseInt(jsonObject.getString("parcelas")),
                        Double.parseDouble(jsonObject.getString("cet")),
                        Double.parseDouble(jsonObject.getString("iof")),
                        Double.parseDouble(jsonObject.getString("valor_total")),
                        jsonObject.getString("data_parcela")
                );
                simulacaoList.add(simulacao);
            }
            return simulacaoList;
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Loja> JsonToListLoja(String conteudo) {
        try {
            List<Loja> listaLoja = new ArrayList<>();
            JSONArray jsonArray;
            JSONObject jsonObject;
            jsonArray = new JSONArray(conteudo);

            for (int x = 0; x < jsonArray.length(); x++) {
                jsonObject = jsonArray.getJSONObject(x);
                Loja loja = new Loja(
                        jsonObject.getString("cnpj_loja"),
                        jsonObject.getString("status_loja"),
                        Integer.parseInt(jsonObject.getString("tipo_loja")),
                        jsonObject.getString("inscricao_estadual"),
                        jsonObject.getString("inscricao_municipal"),
                        jsonObject.getString("ramo_negocio"),
                        jsonObject.getString("motivo_aprovacao"),
                        jsonObject.getString("percentual_clipse"),
                        jsonObject.getString("razao_social"),
                        jsonObject.getString("site")
                );
                listaLoja.add(loja);
            }
            return listaLoja;
        } catch (Exception e) {
            return null;
        }
    }

    public static Loja JsonToLoja(String conteudo) {
        try {
            JSONObject jsonObject;
            jsonObject = new JSONObject(conteudo);

            return new Loja(
                    jsonObject.getString("cnpj_loja"),
                    jsonObject.getString("status_loja"),
                    Integer.parseInt(jsonObject.getString("tipo_loja")),
                    jsonObject.getString("inscricao_estadual"),
                    jsonObject.getString("inscricao_municipal"),
                    jsonObject.getString("ramo_negocio"),
                    jsonObject.getString("motivo_aprovacao"),
                    jsonObject.getString("percentual_clipse"),
                    jsonObject.getString("razao_social"),
                    jsonObject.getString("site")
            );
        } catch (Exception e) {
            return null;
        }
    }
}
