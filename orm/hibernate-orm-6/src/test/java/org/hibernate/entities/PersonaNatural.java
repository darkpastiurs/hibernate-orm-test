package org.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.util.Objects;

@Entity
public class PersonaNatural {

    @Id
    private Long id;
    private String nombreCompleto;

    @OneToOne
    @MapsId
    private Persona persona;

    public PersonaNatural() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonaNatural)) return false;

        PersonaNatural that = (PersonaNatural) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PersonaNatural{");
        sb.append("id=").append(id);
        sb.append(", nombreCompleto='").append(nombreCompleto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
