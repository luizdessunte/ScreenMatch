package br.com.alura.screenmatch.modelos;

/**
 * Record que representa a resposta JSON da API OMDB
 * Records são imutáveis e geram automaticamente getters, equals, hashCode e toString
 * Usado como estrutura auxiliar para desserialização de dados da API
 *
 * Campos mapeados da API OMDB:
 * - title: Nome do filme/série
 * - year: Ano de lançamento
 * - runtime: Duração em formato "XXX min"
 */
public record TituloOmdb(String title, String year, String runtime) {
}
