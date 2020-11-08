package tpaPrueba.ent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Domicilio extends Base{

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private int numero;

    @ManyToOne(cascade = CascadeType.REFRESH,optional = false)
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;

}