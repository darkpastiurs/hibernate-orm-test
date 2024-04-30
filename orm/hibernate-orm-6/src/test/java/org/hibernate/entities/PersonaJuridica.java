package org.hibernate.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
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

    public PersonaJuridica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSociedad() {
        return nombreSociedad;
    }

    public void setNombreSociedad(String nombreSociedad) {
        this.nombreSociedad = nombreSociedad;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
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
        if (!(o instanceof PersonaJuridica)) return false;

        PersonaJuridica that = (PersonaJuridica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PersonaJuridica{");
        sb.append("id=").append(id);
        sb.append(", nombreSociedad='").append(nombreSociedad).append('\'');
        sb.append(", nombreComercial='").append(nombreComercial).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
