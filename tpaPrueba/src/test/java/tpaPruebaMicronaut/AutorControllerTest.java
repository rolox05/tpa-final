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
        testSave.setNombre("Rodrigo");
        testSave.setApellido("Sobisch");
        testSave.setBiografia("biografía perdida");

        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.POST("/save", testSave), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals("Rodrigo", autor.getNombre());
        assertEquals("Sobisch", autor.getApellido());
        assertEquals("biografía perdida", autor.getBiografia());
    }

    @Test
    void testGetAllAutores() {
        Flowable<HttpResponse<Iterable>> result = client.exchange(HttpRequest.GET("/"), Iterable.class);
        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
    }

    @Test
    void testGetOneAutor() {
        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.GET("/17"), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
        assertEquals("Pablo", autor.getNombre());
        assertEquals("Neruda", autor.getApellido());
        assertEquals("Pablo Neruda, seudónimo y posterior nombre legal de Ricardo Eliécer Neftalí Reyes Basoalto (Parral, 12 de julio de 1904-Santiago de Chile, 23 de septiembre de 1973), fue un poeta y político chileno.", autor.getBiografia());
    }

    @Test
    void testUpdateAutor() {
        Autor testUpdate = new Autor();
        testUpdate.setId(11L);
        testUpdate.setNombre("Alberto");
        testUpdate.setApellido("Cortez");
        testUpdate.setBiografia("Biografía perdida");

        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.PUT("/11", testUpdate), Autor.class);

        Autor autor = result.blockingFirst().getBody().get();

        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
        assertEquals("Alberto", autor.getNombre());
        assertEquals("Cortez", autor.getApellido());
        assertEquals("Biografía perdida", autor.getBiografia());
    }

    @Test
    void testDeleteAutor() {
        Flowable<HttpResponse<Autor>> result = client.exchange(HttpRequest.DELETE("delete/22"), Autor.class);

        assertEquals(HttpStatus.OK, result.blockingFirst().getStatus());
    }
}

