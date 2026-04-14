package br.com.alura.screenmatch.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe para carregar configurações da aplicação a partir de arquivo properties.
 * Responsável por ler a chave de API do OMDB de forma segura.
 */
public class ConfiguradorAPI {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    /**
     * Carrega as propriedades do arquivo config.properties
     */
    static {
        properties = new Properties();
        try (InputStream input = ConfiguradorAPI.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                System.err.println("⚠️  AVISO: Arquivo config.properties não encontrado!");
                System.err.println("   1. Copie o arquivo config.properties.example para config.properties");
                System.err.println("   2. Adicione sua chave de API OMDB no arquivo");
                System.exit(1);
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Erro ao carregar configurações: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Retorna a chave de API do OMDB
     * @return Chave de API configurada
     */
    public static String getOmdbApiKey() {
        String key = properties.getProperty("omdb.api.key");
        if (key == null || key.isEmpty() || key.equals("SUA_CHAVE_API_AQUI")) {
            throw new IllegalArgumentException(
                "Chave de API OMDB não configurada. Configure em config.properties"
            );
        }
        return key;
    }

    /**
     * Retorna a URL base da API OMDB
     * @return URL base da API
     */
    public static String getOmdbApiUrl() {
        return properties.getProperty("omdb.api.url", "https://www.omdbapi.com/");
    }
}

