# ScreenMatch

Projeto de aprendizado em Java Orientado a Objetos, desenvolvido durante o curso da Alura.

## Descrição

O ScreenMatch permite:

- Cadastrar filmes e séries
- Avaliar filmes e calcular média de avaliações
- Calcular tempo total para maratonar séries
- Filtrar conteúdos por recomendação
- Buscar filmes e séries pela API OMDb
- Salvar títulos buscados no arquivo `filmes.txt`

## Estrutura do projeto

```text
ScreenMatch/
├── gson-2.13.2.jar
├── filmes.txt
├── src/
│   └── br/com/alura/screenmatch/
│       ├── calculos/
│       │   ├── CalculadoraDeTempo.java
│       │   ├── Classificavel.java
│       │   └── FiltroRecomendacao.java
│       ├── excecao/
│       │   └── ErroDeConversaoDeAnoException.java
│       ├── modelos/
│       │   ├── Episodio.java
│       │   ├── Filme.java
│       │   ├── Serie.java
│       │   ├── Titulo.java
│       │   └── TituloOmdb.java
│       └── principal/
│           ├── Principal.java
│           ├── PrincipalComBusca.java
│           └── PrincipalComListas.java
└── README.md
```

## Classes principais

- `modelos`: entidades de domínio (`Titulo`, `Filme`, `Serie`, `Episodio`, `TituloOmdb`)
- `calculos`: regras de cálculo e recomendação
- `excecao`: exceção personalizada de conversão de ano
- `principal`: classes com `main` para demonstrações e busca na API

## Como executar (Windows PowerShell)

### Pré-requisitos

- JDK 11 ou superior instalado
- Arquivo `gson-2.13.2.jar` na raiz do projeto

### 1) Compilar o projeto

```powershell
$sources = Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName }
javac -cp ".;gson-2.13.2.jar" -d out $sources
```

### 2) Executar os exemplos

```powershell
java -cp "out;gson-2.13.2.jar" br.com.alura.screenmatch.principal.Principal
java -cp "out;gson-2.13.2.jar" br.com.alura.screenmatch.principal.PrincipalComListas
java -cp "out;gson-2.13.2.jar" br.com.alura.screenmatch.principal.PrincipalComBusca
```

> Em `PrincipalComBusca`, configure sua chave da OMDb no código, no trecho `apikey=...`.

## Conceitos praticados

- Programação orientada a objetos (POO)
- Encapsulamento, herança e polimorfismo
- Interfaces
- Consumo de API REST com `java.net.http.HttpClient`
- Desserialização JSON com Gson
- Tratamento de exceções personalizadas
- Escrita de arquivos com `FileWriter`

## Licença

Projeto educacional, de código aberto.
