ScreenMatch 🎬
Um projeto de aprendizado em Java Orientado a Objetos desenvolvido durante o curso da Alura. O ScreenMatch é um sistema de catalogação e análise de filmes e séries.

📋 Descrição
O ScreenMatch permite:

✅ Cadastrar filmes e séries
✅ Avaliar filmes e calcular média de avaliações
✅ Calcular tempo total para maratonar séries
✅ Filtrar conteúdos por recomendação
✅ Armazenar e exibir informações técnicas
✅ **Buscar filmes e séries diretamente da API OMDb.**
✅ **Salvar os títulos buscados em um arquivo de texto.**

🏗️ Estrutura do Projeto
ScreenMatch/
├── src/
│   ├── Principal.java
│   ├── **PrincipalComBusca.java**
│   └── br/
│       └── com/
│           └── alura/
│               └── screenmatch/
│                   ├── calculos/
│                   │   ├── CalculadoraDeTempo.java
│                   │   ├── Classificavel.java
│                   │   └── FiltroRecomendacao.java
│                   ├── **excecao/**
│                   │   └── **ErroDeConversaoDeAnoException.java**
│                   └── modelos/
│                       ├── Titulo.java
│                       ├── Filme.java
│                       ├── Serie.java
│                       ├── Episodio.java
│                       └── **TituloOmdb.java**
├── ScreenMatch.iml
└── README.md

📚 Classes Principais
**Modelos**
Titulo: Classe base com atributos comuns (nome, ano de lançamento, duração)
Filme: Herda de Titulo, com suporte a avaliações
Serie: Herda de Titulo, com suporte a temporadas e episódios
Episodio: Representa um episódio de série com visualizações
**TituloOmdb: Representa a estrutura de dados de um título retornado pela API OMDb, utilizada para desserialização JSON.**

**Cálculos**
CalculadoraDeTempo: Calcula tempo total para assistir múltiplos títulos
FiltroRecomendacao: Filtra títulos com base em critérios de recomendação
Classificavel: Interface para padronizar avaliações

**Principais**
Principal: Contém exemplos de uso das classes de modelo e cálculo.
**PrincipalComBusca: Ponto de entrada principal para a funcionalidade de busca de filmes e séries via API OMDb, permitindo interação com o usuário e salvamento de dados.**

**Exceções**
**ErroDeConversaoDeAnoException: Exceção personalizada para tratar erros na conversão do ano de lançamento de títulos, garantindo robustez na aplicação.**

🚀 Como Usar
Para compilar e executar o projeto, siga os passos abaixo.

**Pré-requisitos:**
*   Java Development Kit (JDK) 11 ou superior.
*   Biblioteca Gson (para manipulação de JSON). Você pode baixá-la em [Maven Central](https://mvnrepository.com/artifact/com.google.code.gson/gson) e colocar o JAR em uma pasta `lib/` na raiz do projeto.

**Compilar (para a funcionalidade de busca via API - `PrincipalComBusca.java`):**
```bash
javac -d out src/br/com/alura/screenmatch/principal/PrincipalComBusca.java src/br/com/alura/screenmatch/modelos/Titulo.java src/br/com/alura/screenmatch/modelos/TituloOmdb.java src/br/com/alura/screenmatch/excecao/ErroDeConversaoDeAnoException.java -cp "lib/*"
```
*Nota: Certifique-se de que o JAR do Gson esteja no diretório `lib/` e que o caminho para ele esteja correto no classpath (`-cp "lib/*"`).*

**Executar (para a funcionalidade de busca via API - `PrincipalComBusca.java`):**
```bash
java -cp "out:lib/*" br.com.alura.screenmatch.principal.PrincipalComBusca
```
*No Windows, use `;` em vez de `:` para separar os caminhos no classpath: `java -cp "out;lib/*" br.com.alura.screenmatch.principal.PrincipalComBusca`*

**Exemplo de Uso (interativo via console com `PrincipalComBusca`):**
Ao executar `PrincipalComBusca`, o programa solicitará que você digite o nome de um filme ou série.
```
Digite um filme para busca:
The Matrix
```
O programa buscará o título na API OMDb, exibirá suas informações no console e o salvará no arquivo `filmes.txt`. Você pode continuar buscando até digitar "sair".

**Compilar e Executar (para as funcionalidades básicas - `Principal.java`):**
```bash
javac -d out src/Principal.java src/br/com/alura/screenmatch/**/*.java
java -cp out Principal
```

**Exemplo de Uso (funcionalidades básicas - `Principal.java`):**
```java
// Criar um filme
Filme meuFilme = new Filme();
meuFilme.setNome("O Poderoso Chefão");
meuFilme.setAnoDeLancamento(1970);
meuFilme.setDuracaoEmMinutos(180);

// Avaliar
meuFilme.avalia(8);
meuFilme.avalia(10);
System.out.println(meuFilme.pegaMedia()); // Exibe a média

// Criar uma série
Serie lost = new Serie();
lost.setNome("Lost");
lost.setTemporadas(10);
lost.setEpisodiosPorTemporada(10);
lost.setMinutosPorEpisodio(50);
System.out.println(lost.getDuracaoEmMinutos()); // Tempo total
```

🎓 Conceitos Abordados
Programação Orientada a Objetos (POO)
Encapsulamento
Herança
Interfaces
Polimorfismo
Getters e Setters
Tratamento de dados
**Consumo de API REST (OMDb) com `java.net.http.HttpClient`**
**Manipulação de JSON (com a biblioteca Gson)**
**Tratamento de Exceções Personalizadas**
**Escrita de arquivos (java.io.FileWriter)**

👨‍💻 Autor
Desenvolvido como projeto de aprendizado durante o curso de Java POO da Alura.

📝 Licença
Este projeto é de código aberto e foi desenvolvido para fins educacionais.