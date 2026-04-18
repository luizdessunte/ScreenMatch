package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe que demonstra operações com coleções de dados
 * Mostra:
 * - ArrayList com polimorfismo (Titulo genérico)
 * - LinkedList para buscas
 * - Ordenação com Collections.sort() e Comparator
 * - Pattern matching: instanceof com casting
 */
public class PrincipalComListas {
    public static void main(String[] args) {
        // ===== DEMONSTRAÇÃO 1: Criação de títulos com avaliações =====
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        Filme f1 = filmeDoPaulo;

        // ===== DEMONSTRAÇÃO 2: ArrayList polimórfico =====
        // Lista que aceita tanto Filmes quanto Séries (ambas são Título)
        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        // Iterando com pattern matching: trata Filmes diferente de Séries
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            // instanceof permite verificar o tipo real do objeto
            if (item instanceof  Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        // ===== DEMONSTRAÇÃO 3: LinkedList para buscas =====
        // Melhor para inserções/remoções; pior para acesso aleatório
        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        // ===== DEMONSTRAÇÃO 4: Ordenação por nome (implementa Comparable) =====
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);

        // Ordenando títulos por nome (usa o compareTo implementado em Titulo)
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        // ===== DEMONSTRAÇÃO 5: Ordenação customizada por ano =====
        // Usa Comparator com method reference (getAnoDeLancamento)
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
