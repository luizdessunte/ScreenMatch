package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

/**
 * Classe que representa um episódio de uma série
 * Implementa Classificavel para permitir recomendações baseadas em visualizações
 */
public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes; // Métrica importante para recomendação

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    /**
     * Implementação do método getClassificacao da interface Classificavel
     * Classifica o episódio baseado no número de visualizações
     * - Mais de 100 visualizações: classificação 4 (excelente)
     * - 100 ou menos: classificação 2 (bom)
     * @return Classificação do episódio (2 ou 4)
     */
    @Override
    public int getClassificacao() {
        if (totalVisualizacoes > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
