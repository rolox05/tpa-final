package com.example.persona.repositories;

import com.example.persona.entities.Persona;
import com.example.persona.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

}
