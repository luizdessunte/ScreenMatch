package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

/**
 * Classe principal de demonstração
 * Mostra funcionalidades básicas:
 * - Criação e avaliação de filmes e séries
 * - Cálculo de tempo total de visualização
 * - Sistema de recomendações baseado em classificações
 * - Uso de ArrayList (coleções)
 */
public class Principal {
    public static void main(String[] args) {
        // ===== DEMONSTRAÇÃO 1: Filme e Avaliações =====
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        // Registrando múltiplas avaliações para calcular média
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        // ===== DEMONSTRAÇÃO 2: Série e Duração Total =====
        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.setDuracaoEmMinutos(200);

        // ===== DEMONSTRAÇÃO 3: Calculadora de Tempo (Polimorfismo) =====
        // Nota: A calculadora aceita qualquer Titulo (Filme ou Serie)
        // Cada um calcula sua duração de forma diferente!
        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        // ===== DEMONSTRAÇÃO 4: Sistema de Recomendação =====
        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        // Testando recomendação com episódio
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300); // Classifica como 4 (mais de 100)
        filtro.filtra(episodio);

        // ===== DEMONSTRAÇÃO 5: ArrayList de Filmes =====
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.get(0).toString());


    }
}