package tpaPrueba.control;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import tpaPrueba.ent.Persona;
import tpaPrueba.serv.PersonaServiceImpl;

@Controller("api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{
    public PersonaController(PersonaServiceImpl personaService) {
        super(personaService);
    }

    @Get("/search")
    public HttpResponse<?> findPersonaByNombreOrApellido(@QueryValue String filtro){
        try{
            return HttpResponse.status(HttpStatus.OK).body(servicio.getByNombreOrApellido(filtro,filtro));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}
