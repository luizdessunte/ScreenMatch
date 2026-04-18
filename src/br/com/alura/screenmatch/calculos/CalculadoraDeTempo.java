package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

/**
 * Classe utilitária que calcula o tempo total de visualização
 * Usa polimorfismo: aceita qualquer tipo de Titulo (Filme ou Serie)
 * Melhor que ter métodos separados para Filme e Serie (padrão DRY)
 */
public class CalculadoraDeTempo {
    private int tempoTotal; // Acumulador de tempo em minutos

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    /**
     * Adiciona a duração de um título ao tempo total
     * Funciona com Filme e Serie graças ao polimorfismo
     * Cada subclass sobrescreve getDuracaoEmMinutos() conforme suas regras
     *
     * @param titulo Qualquer tipo de Titulo (Filme ou Serie)
     */
    public void inclui(Titulo titulo) {
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
