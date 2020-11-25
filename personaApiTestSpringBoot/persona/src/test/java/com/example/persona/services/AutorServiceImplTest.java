package com.example.persona.services;

import com.example.persona.repositories.BaseRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AutorServiceImplTest {
    // La instancia que vamos a testear (llamar a sus métodos)
    private static AutorService autorService;

    // La instancia que vamos a mockear (ya que es usada por AutorService)
    private static BaseRepository baseRepository;

    // Antes de que se ejecuten todos los tests, hacer esto
    @BeforeAll
    public static void setUp() {
        // Mockeo una instancia de BaseRepository
        baseRepository = mock(BaseRepository.class);

        // Creamos una instancia de la implementación de AutorService, pasandole
        // como parámetro, una instancia MOCKEADA de BaseRepository
        autorService = new AutorServiceImpl(baseRepository);
    }

    @Test
    public void test() throws Exception {
        final List repositoryResult = new ArrayList();

        // Cuando a base repository, le llamen findAll, entonces el mock
        // devuelve la lista repositoryResult
        when(baseRepository.findAll()).thenReturn(repositoryResult);

        // Una vez que configuramos el mock, llamamos al método del servicio
        // y guardamos el resultado
        final List result = autorService.findAll();

        // assert de que el resultado del servicio, es el mismo que le ordenamos al mock
        assertEquals(result, repositoryResult);
    }

    @Test
    public void test2() {
        final String message = "message";
        when(baseRepository.findAll()).thenThrow(new RuntimeException(message));

        final Exception exception = assertThrows(Exception.class, () -> {
           autorService.findAll();
        });
        assertEquals(exception.getMessage(), message);
    }
}