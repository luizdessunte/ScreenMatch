package br.com.alura.screenmatch.modelos;

/**
 * Classe que representa uma Série de TV
 * Herda de Titulo e adiciona atributos específicos de série
 */
public class Serie extends Titulo {
    private int temporadas;
    private boolean ativa; // Indica se a série ainda está em produção
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public Serie(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    /**
     * Sobrescreve getDuracaoEmMinutos da classe pai
     * Calcula a duração total multiplicando temporadas * episódios * minutos por episódio
     * Útil para saber quanto tempo levaria para maratonar a série toda
     * @return Duração total em minutos de todas as temporadas
     */
    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }

    @Override
    public String toString() {
        return "Série: " + this.getNome() + "(" + this.getAnoDeLancamento() + ")";
    }
}
