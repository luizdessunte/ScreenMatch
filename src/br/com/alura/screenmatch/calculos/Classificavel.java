package br.com.alura.screenmatch.calculos;

/**
 * Interface funcional que define o contrato para objetos que podem ser classificados
 * Implementada por: Filme, Episodio
 * Permite uso polimórfico no sistema de recomendações
 */
public interface Classificavel {
    /**
     * Retorna uma classificação numérica do objeto (geralmente de 0 a 5)
     * A implementação específica fica a cargo das classes que implementam a interface
     * @return Valor de classificação
     */
    int getClassificacao();
}
