package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Inicializa scanner para entrada de dados do usuário
        Scanner leitura = new Scanner(System.in);
        String busca= "";
        List<Titulo> titulos = new ArrayList<>();

        // Configura Gson para desserializar JSON com nomes em UPPER_CAMEL_CASE (ex: imdbRating)
        // e ativa formatação prettficada para melhor legibilidade
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            // Verifica se o usuário quer sair do programa
            if (busca.equalsIgnoreCase("sair"))
            {
                break;
            }

            // Constrói a URL da API OMDB com a busca do usuário
            // Substitui espaços por '+' para compatibilidade com URL
            // IMPORTANTE: Substituir "SUA API AQUI" por sua chave de API válida
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=SUA API AQUI";
            try {
                // Realiza requisição HTTP GET para a API OMDB
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // Extrai o corpo da resposta em formato JSON
                String json = response.body();
                System.out.println(json);

                // Desserializa o JSON recebido para objeto TituloOmdb
                // Esta é a primeira conversão usando a API OMDB
                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                // Converte TituloOmdb para Titulo (modelo local da aplicação)
                // Isso permite validar dados e aplicar regras de negócio (como verificação de ano)
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                // Adiciona o título convertido à lista para posterior salvamento em arquivo
                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                // Trata erro de conversão de número (ex: ano inválido)
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Trata erros de argumento inválido na construção da URL ou objeto
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                // Trata exceção personalizada lançada quando o ano não pode ser convertido
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);

        // Salva todos os títulos coletados em um arquivo JSON para persistência de dados
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("O programa finalizou corretamente!");
    }
}
