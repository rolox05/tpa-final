package tpaPrueba.repos;

import java.util.Optional;

import io.micronaut.data.annotation.Repository;
import tpaPrueba.ent.Localidad;


@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{

    @Override
    Optional<Localidad> findById( Long aLong);


    @Override
    boolean existsById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
