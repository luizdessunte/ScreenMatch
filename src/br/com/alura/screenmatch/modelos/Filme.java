package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

/**
 * Classe que representa um Filme
 * Herda de Titulo e implementa Classificavel para permitir recomendações
 * Adiciona atributo específico de filme: diretor
 */
public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    /**
     * Implementação do método getClassificacao da interface Classificavel
     * Converte a média de avaliações (0-10) em uma classificação de 0-5
     * @return Classificação baseada na média de avaliações
     */
    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
