package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import com.google.gson.annotations.SerializedName;

/**
 * Classe base que representa um título (Filme ou Série)
 * Implementa Comparable para permitir ordenação por nome
 */
public class Titulo implements Comparable<Titulo> {
    // Anotações @SerializedName mapeiam os nomes dos campos JSON da API OMDB
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes; // Acumulador para caluclar média
    private int totalDeAvaliacoes;    // Contador de avaliações
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    /**
     * Construtor que converte um TituloOmdb (dados da API) em um Titulo
     * Realiza validações importantes como verificação do tamanho do ano
     * @param meuTituloOmdb Objeto com dados vindos da API OMDB
     * @throws ErroDeConversaoDeAnoException Se o ano tem mais de 4 caracteres
     */
    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        // Valida se o ano tem até 4 caracteres (formato esperado: YYYY)
        if(meuTituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano " +
                    "porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer
                .valueOf(meuTituloOmdb.year());
        // Extrai os dois primeiros dígitos do tempo de execução (ex: "180 min" -> 18)
        this.duracaoEmMinutos = Integer
                .valueOf(meuTituloOmdb.runtime()
                .substring(0, 2));
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    /**
     * Registra uma avaliação do usuário para este título
     * Accumula em somaDasAvaliacoes para cálculo posterior da média
     * @param nota Valor da avaliação (normalmente de 0 a 10)
     */
    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    /**
     * Calcula a média aritmética de todas as avaliações registradas
     * @return Média das avaliações
     */
    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    /**
     * Implementa comparação para ordenação alfabética por nome
     * Necessário para usar Collections.sort() em listas de Titulo
     */
    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome = " + nome +
                ", anoDeLancamento= " + anoDeLancamento + "," +
                " duração =  " + duracaoEmMinutos + ")";

    }
}
