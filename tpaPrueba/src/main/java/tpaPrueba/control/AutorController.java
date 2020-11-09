package tpaPrueba.control;

import io.micronaut.http.annotation.Controller;
import tpaPrueba.ent.Autor;
import tpaPrueba.serv.AutorServiceImpl;

@Controller("api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{
    public AutorController(AutorServiceImpl autorService) {
        super(autorService);
    }

}
