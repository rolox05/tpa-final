package com.example.persona.repositories;

import com.example.persona.entities.Autor;
import org.springframework.stereotype.Repository;
import com.example.persona.repositories.BaseRepository;

@Repository
public interface AutorRepository extends BaseRepository <Autor,Long>  {
}
