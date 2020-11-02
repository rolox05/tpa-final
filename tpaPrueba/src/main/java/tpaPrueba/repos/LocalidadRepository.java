package tpaPrueba.repos;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import tpaPrueba.ent.Localidad;

@Repository
public interface LocalidadRepository extends CrudRepository<Localidad,Long> {
}
