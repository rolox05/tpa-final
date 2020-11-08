package tpaPrueba.ent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name = "localidad")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Localidad extends Base{

    @Column(name = "denominacion")
    private String denominacion;
}