package org.hibernate.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Objects;

@Entity
@Data
@ToString(exclude = "persona")
public class PersonaJuridica {

    @Id
    private Long id;
    @Column
    private String nombreSociedad;
    @Column
    private String nombreComercial;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Persona persona;

}
