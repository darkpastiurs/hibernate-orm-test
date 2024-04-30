package org.hibernate.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonaNatural personaNatural;
    @OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonaJuridica personaJuridica;

    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public PersonaNatural getPersonaNatural() {
        return personaNatural;
    }

    public void setPersonaNatural(PersonaNatural personaNatural) {
        if (Objects.isNull(personaNatural)) {
            if (Objects.nonNull(this.personaNatural)) {
                this.personaNatural.setPersona(null);
            }
        } else {
            personaNatural.setPersona(this);
        }
        this.personaNatural = personaNatural;
    }

    public PersonaJuridica getPersonaJuridica() {
        return personaJuridica;
    }

    public void setPersonaJuridica(PersonaJuridica personaJuridica) {
        if (Objects.isNull(personaJuridica)) {
            if (Objects.nonNull(this.personaJuridica)) {
                this.personaJuridica.setPersona(null);
            }
        } else {
            personaJuridica.setPersona(this);
        }
        this.personaJuridica = personaJuridica;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;

        Persona persona = (Persona) o;
        return Objects.equals(id, persona.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persona{");
        sb.append("id=").append(id);
        sb.append(", descripcion='").append(descripcion).append('\'');
        sb.append(", personaNatural=").append(personaNatural);
        sb.append(", personaJuridica=").append(personaJuridica);
        sb.append('}');
        return sb.toString();
    }
}
