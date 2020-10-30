package micronautPersonaApp.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Base {
    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_libro",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    private List<Libro> libros = new ArrayList<Libro>();
}