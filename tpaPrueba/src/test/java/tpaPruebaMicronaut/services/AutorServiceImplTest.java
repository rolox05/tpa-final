package tpaPruebaMicronaut.services;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tpaPrueba.repos.AutorRepository;
import tpaPrueba.serv.AutorService;
import tpaPrueba.serv.AutorServiceImpl;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class AutorServiceImplTest {
    @Inject
    private static AutorService autorService;

    private static AutorRepository autorRepository;

    @BeforeAll
    public static void setUp () {
        autorRepository = mock(AutorRepository.class);

        autorService = new AutorServiceImpl(autorRepository);
    }

    @Test
    public void test() throws Exception {
        final List repositoryResult = new ArrayList();

        when(autorRepository.findAll()).thenReturn(repositoryResult);

        final List result = (List) autorService.getAll();

        assertEquals(result, repositoryResult);
    }

    @Test
    public void test2() {
        final String message = "message error";
        when(autorRepository.findAll()).thenThrow(new RuntimeException(message));

        final Exception exception = assertThrows(Exception.class, () -> {
            autorService.getAll();
        });
        assertEquals(exception.getMessage(), message);
    }
}
