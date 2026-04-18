package br.com.alura.screenmatch.calculos;

/**
 * Classe que implementa a lógica de recomendação
 * Usa a interface Classificavel para operar com qualquer objeto classificável
 * Exemplos: Filme, Episodio
 */
public class FiltroRecomendacao {
    private String recomendacao;

    /**
     * Filtra e recomenda um conteúdo baseado em sua classificação
     * - Classificação >= 4: Altamente recomendado
     * - Classificação >= 2: Bom, recomendado
     * - Classificação < 2: Adicionar à lista para depois
     *
     * @param classificavel Qualquer objeto que implemente Classificavel (Filme, Episodio, etc)
     */
    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Está entre os preferidos do momento");
        } else if (classificavel.getClassificacao() >= 2) {
            System.out.println("Muito bem avaliado no momento!");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
