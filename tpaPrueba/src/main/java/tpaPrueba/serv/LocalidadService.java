package tpaPrueba.serv;

import tpaPrueba.ent.Localidad;
import tpaPrueba.repos.LocalidadRepository;
import tpaPrueba.repos.LocalidadRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocalidadService {

    @Inject
    private LocalidadRepository localidadRepository;

    public Iterable<Localidad> getAll(){
        return localidadRepository.findAll();
    }

    public Localidad saveOrUpdate(Localidad entity){
        Localidad localidadSaved = null;

        if (entity.getId() != null && localidadRepository.existsById(entity.getId())) {
            localidadSaved = localidadRepository.update(entity);
        } else {
            localidadSaved = localidadRepository.save(entity);
        }

        return localidadSaved;
    }

    public void deleteLocalidad(Long id){
        localidadRepository.deleteById(id);

    }
}
