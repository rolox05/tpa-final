package tpaPrueba.ent;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Base  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
}
