package uy.edu.ort.obligatorioDA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uy.edu.ort.obligatorioDA.datosPrueba.DatosPrecarga;

@SpringBootApplication
public class ObligatorioDaApplication {

	public static void main(String[] args) {
		// Cargar datos de prueba
		DatosPrecarga.cargar();
		SpringApplication.run(ObligatorioDaApplication.class, args);
	}

}
