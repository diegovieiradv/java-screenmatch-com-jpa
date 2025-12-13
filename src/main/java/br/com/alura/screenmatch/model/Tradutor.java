package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.service.ConsumoApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Tradutor {   // ← AQUI está o nome da classe

    public static String traduzir(String texto) {
        try {
            ConsumoApi consumo = new ConsumoApi();

            String json = consumo.obterDados(
                    "https://libretranslate.de/translate" +
                            "?q=" + URLEncoder.encode(texto, StandardCharsets.UTF_8) +
                            "&source=en&target=pt&format=text"
            );

            return new ObjectMapper()
                    .readTree(json)
                    .get("translatedText")
                    .asText();

        } catch (Exception e) {
            return texto; // falhou? não quebra o sistema
        }
    }
}
