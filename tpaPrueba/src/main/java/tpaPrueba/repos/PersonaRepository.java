package tpaPrueba.repos;

import io.micronaut.data.annotation.Repository;
import tpaPrueba.ent.Persona;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
}
