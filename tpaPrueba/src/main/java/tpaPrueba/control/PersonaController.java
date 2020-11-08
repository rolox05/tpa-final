package tpaPrueba.control;

import io.micronaut.http.annotation.Controller;
import tpaPrueba.ent.Persona;
import tpaPrueba.serv.PersonaServiceImpl;

@Controller("api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    public PersonaController(PersonaServiceImpl personaService) {
        super(personaService);
    }

}
