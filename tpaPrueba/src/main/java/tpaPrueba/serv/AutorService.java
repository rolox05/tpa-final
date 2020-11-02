package tpaPrueba.serv;

import tpaPrueba.ent.Autor;
import tpaPrueba.repos.AutorRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AutorService {

    @Inject
    private AutorRepository autorRepository;

    public Iterable<Autor> getAll(){
        return autorRepository.findAll();
    }

    public Autor saveOrUpdate(Autor entity){
        Autor autorSaved = null;

        if (entity.getId() != null && autorRepository.existsById(entity.getId())) {
            autorSaved = autorRepository.update(entity);
        } else {
            autorSaved = autorRepository.save(entity);
        }

        return autorSaved;
    }

    public void deleteAutor(Long id){
        autorRepository.deleteById(id);

    }
}
