package tpaPrueba.control;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import tpaPrueba.ent.Localidad;
import tpaPrueba.ent.Persona;
import tpaPrueba.serv.LocalidadService;
import tpaPrueba.serv.PersonaService;

import javax.inject.Inject;

@Controller("api/v1/localidades")
public class LocalidadController {

    @Inject
    private LocalidadService localidadService;

    @Get
    public HttpResponse<?> findAll(){
        try {
            return HttpResponse.status(HttpStatus.OK).body(localidadService.getAll());
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Get("/{id}")
    public HttpResponse<?> findOne(@Parameter Long id){
        try {
            return HttpResponse.status(HttpStatus.OK).body(localidadService.findOne(id));
        }catch (Exception ex) {
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }

    @Post("/saveLocalidad")
    public HttpResponse<?> saveOrUpdate(@Body Localidad entity) {
        try{
            return HttpResponse.status(HttpStatus.OK).body(localidadService.saveOrUpdate(entity));
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }


    }

    @Delete("delete/{id}")
    public HttpResponse<?> delete(Long id) {
        try {
            localidadService.deleteLocalidad(id);
            return HttpResponse.status(HttpStatus.OK);
        }catch (Exception ex){
            return HttpResponse.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error Por favor intente mas tarde.\"}");
        }
    }
}
