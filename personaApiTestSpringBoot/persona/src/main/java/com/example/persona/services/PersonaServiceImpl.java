package com.example.persona.services;

import com.example.persona.entities.Persona;
import com.example.persona.repositories.BaseRepository;
import com.example.persona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements  PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    // Lo mismo que Autowired
    // public PersonaService(PersonaRepository personaRepository) {
    //    this.personaRepository = personaRepository;
    // }

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }
}
