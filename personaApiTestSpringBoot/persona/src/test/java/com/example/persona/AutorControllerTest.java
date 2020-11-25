package com.example.persona;

import com.example.persona.controllers.AutorController;
import com.example.persona.entities.Autor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
//Proporciona un Spring ApplicationContext y obtiene beans inyectados en su instancia de prueba.

@SpringBootTest
//Especifica que es una clase de prueba regular que ejecuta pruebas basadas en Spring Boot.

public class AutorControllerTest {

	/*SE DEBERÁ COMENTAR Y DESCOMENTAR CADA TEST PARA LA EJECUCIÓN DE LAS PRUEBAS*/

	@Autowired
	private AutorController autorController;


	@Test
	// Define a JUnit que es el método que se puede ejecutar como un caso de prueba.
	public void contextLoads() {
		// La siguiente prueba comprueba que la instancia del controlador que se crea e inyecta con éxito
		Assertions.assertThat(autorController).isNotNull();
	}

	@Test
	public void whenAutorControllerGetAllThenShouldReturnResponseEntityOk() {

		final ResponseEntity<Autor> autors = (ResponseEntity<Autor>) autorController.getAll();
		assertEquals(autors.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void whenAutorControllerGetOneThenShouldReturnResponseEntityNOTFOUND() {

		final ResponseEntity<Autor> autors = (ResponseEntity<Autor>) autorController.getOne(18L);
		assertEquals(autors.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void whenAutorControllerPostThenShouldReturnResponseEntityOk() {
		Autor autor = new Autor();
		autor.setNombre("Prueba");
		autor.setApellido("Prueba");
		autor.setBiografia("Prueba");

		final ResponseEntity<Autor> autors = (ResponseEntity<Autor>) autorController.save(autor);
		assertEquals(autors.getStatusCode(), HttpStatus.OK);
	}
	@Test
	public void whenAutorControllerUpdateTheShouldReturnEntityOK(){

		Autor autor = new Autor();
		autor.setId(7L);
		autor.setNombre("Modificado");
		autor.setApellido("Modificado");
		autor.setBiografia("Modificado");

		final ResponseEntity<Autor> autors= (ResponseEntity<Autor>) autorController.update(7L,autor);
		assertEquals(autors.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void whenAutorControllerDeleteThenShouldReturnEntityNO_CONTENT(){

		final ResponseEntity<Autor> autors= (ResponseEntity<Autor>) autorController.delete(10L);
		assertEquals(autors.getStatusCode(), HttpStatus.NO_CONTENT);
	}


}
