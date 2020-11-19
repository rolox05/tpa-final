package tpaPruebaMicronaut;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.reactivex.Flowable;
import tpaPrueba.ent.Autor;

@MicronautTest
public class AutorControllerTest {

    @Inject
    @Client("/api/v1/autores")
    RxHttpClient client;

    @Test
    void testSaveAutor() {
        Autor testSave = new Autor();
        testSave.setNombre("Pablo");
        testSave.setApellido("Neruda");
        testSave.setBiografia("Pablo Neruda, seudónimo y posterior nombre legal de Ricardo Eliécer Neftalí Reyes Basoalto (Parral, 12 de julio de 1904-Santiago de Chile, 23 de septiembre de 1973), fue un poeta y político chileno.");

        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.POST("/save", testSave), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals("Pablo", autor.getNombre());
        assertEquals("Neruda", autor.getApellido());
        assertEquals("Pablo Neruda, seudónimo y posterior nombre legal de Ricardo Eliécer Neftalí Reyes Basoalto (Parral, 12 de julio de 1904-Santiago de Chile, 23 de septiembre de 1973), fue un poeta y político chileno.", autor.getBiografia());
    }

    @Test
    void testGetAllAutores() {
        Flowable<HttpResponse<Iterable>> result = client.exchange(HttpRequest.GET("/"), Iterable.class);
        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
    }

    @Test
    void testGetOneAutor() {
        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.GET("/1"), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
        assertEquals("Pablo", autor.getNombre());
        assertEquals("Neruda", autor.getApellido());
        assertEquals("Pablo Neruda, seudónimo y posterior nombre legal de Ricardo Eliécer Neftalí Reyes Basoalto (Parral, 12 de julio de 1904-Santiago de Chile, 23 de septiembre de 1973), fue un poeta y político chileno.", autor.getBiografia());
    }

    @Test
    void testUpdateAutor() {
        Autor testUpdate = new Autor();
        testUpdate.setId(1L);
        testUpdate.setNombre("Ricardo");
        testUpdate.setApellido("Reyes");

        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.PUT("/1", testUpdate), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
        assertEquals("Pablo", autor.getNombre());
        assertEquals("Neruda", autor.getApellido());
        assertEquals("Pablo Neruda, seudónimo y posterior nombre legal de Ricardo Eliécer Neftalí Reyes Basoalto (Parral, 12 de julio de 1904-Santiago de Chile, 23 de septiembre de 1973), fue un poeta y político chileno.", autor.getBiografia());
    }

    @Test
    void testDeleteAutor() {
        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.DELETE("delete/1"), Autor.class);

        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
    }
}