package br.com.awebmeu.crud_no_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * O Spring Boot procura por esta classe para inicializar o contexto
 * da aplicação e configurar componentes automaticamente.
 */
@SpringBootApplication
public class CrudNoDbApplication {

	/**
	 * Ponto de entrada da aplicação.
	 *
	 * @param args argumentos de linha de comando (geralmente não utilizados)
	 *
	 * O método abaixo inicia o contexto Spring e sobe o servidor embutido
	 * (por exemplo, Tomcat) para servir a aplicação web.
	 */
	public static void main(String[] args) {
		// Inicializa e executa a aplicação Spring Boot
		SpringApplication.run(CrudNoDbApplication.class, args);
	}

}
