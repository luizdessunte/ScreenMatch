# ScreenMatch 🎬

Um projeto de aprendizado em **Java Orientado a Objetos** desenvolvido durante o curso da Alura. O ScreenMatch é um sistema de catalogação e análise de filmes e séries.

## 📋 Descrição

O ScreenMatch permite:
- ✅ Cadastrar filmes e séries
- ✅ Avaliar filmes e calcular média de avaliações
- ✅ Calcular tempo total para maratonar séries
- ✅ Filtrar conteúdos por recomendação
- ✅ Armazenar e exibir informações técnicas

## 🏗️ Estrutura do Projeto

```
ScreenMatch/
├── src/
│   ├── Principal.java
│   └── br/
│       └── com/
│           └── alura/
│               └── screenmatch/
│                   ├── calculos/
│                   │   ├── CalculadoraDeTempo.java
│                   │   ├── Classificavel.java
│                   │   └── FiltroRecomendacao.java
│                   └── modelos/
│                       ├── Titulo.java
│                       ├── Filme.java
│                       ├── Serie.java
│                       └── Episodio.java
├── ScreenMatch.iml
└── README.md
```

## 📚 Classes Principais

### Modelos
- **Titulo**: Classe base com atributos comuns (nome, ano de lançamento, duração)
- **Filme**: Herda de Titulo, com suporte a avaliações
- **Serie**: Herda de Titulo, com suporte a temporadas e episódios
- **Episodio**: Representa um episódio de série com visualizações

### Cálculos
- **CalculadoraDeTempo**: Calcula tempo total para assistir múltiplos títulos
- **FiltroRecomendacao**: Filtra títulos com base em critérios de recomendação
- **Classificavel**: Interface para padronizar avaliações

## 🚀 Como Usar

### Compilar
```bash
javac -d out src/Principal.java src/br/com/alura/screenmatch/**/*.java
```

### Executar
```bash
java -cp out Principal
```

### Exemplo de Uso

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

## 🎓 Conceitos Abordados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Herança
- Interfaces
- Polimorfismo
- Getters e Setters
- Tratamento de dados

## 👨‍💻 Autor

Desenvolvido como projeto de aprendizado durante o curso de Java POO da Alura.

## 📝 Licença

Este projeto é de código aberto e foi desenvolvido para fins educacionais.

---

**Última atualização**: Abril de 2026

