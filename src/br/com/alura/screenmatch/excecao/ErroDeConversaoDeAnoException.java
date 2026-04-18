package br.com.alura.screenmatch.excecao;

/**
 * Exceção personalizada lançada quando há falha na conversão do ano
 * Herda de RuntimeException (exceção não verificada)
 * Usada principalmente na constructora de Titulo quando o ano tem formato inválido
 */
public class ErroDeConversaoDeAnoException extends RuntimeException {
    private String mensagem;

    public ErroDeConversaoDeAnoException(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * Retorna a mensagem de erro personalizada
     * @return Mensagem descrevendo o problema na conversão
     */
    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
