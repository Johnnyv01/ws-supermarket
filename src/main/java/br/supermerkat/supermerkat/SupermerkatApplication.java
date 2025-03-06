package br.supermerkat.supermerkat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupermerkatApplication {
	private static Logger logger = LoggerFactory.getLogger(SupermerkatApplication.class);
	public static void main(String[] args) {

		logger.info("Aplicacao sendo inicializada");
		SpringApplication.run(SupermerkatApplication.class, args);
	}

}
