/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

/**
 * Representa una persona registrada en el sistema de la Agencia Fiscal.
 *
 * Esta clase está mapeada a la tabla Persona del modelo relacional, donde cada
 * persona tiene un identificador único, RFC, nombre, teléfono y fecha de
 * nacimiento.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    /**
     * Identificador de la persona.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * RFC de la persona.
     */
    @Column(name = "RFC", nullable = false, length = 13, unique = true)
    private String RFC;
    /**
     * Nombre de la persona.
     */
    @Column(name = "Nombre", nullable = false)
    private String nombre;
    /**
     * Fecha de nacimiento de la persona.
     */
    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    /**
     * Teléfono de la persona.
     */
    @Column(name = "Telefono", nullable = false)
    private String telefono;
    /**
     * Lista de trámites de la persona.
     */
    @OneToMany(mappedBy = "persona", cascade = CascadeType.PERSIST)
    private List<Tramites> tramites;

    /**
     * Regresa el id.
     *
     * @return ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id.
     *
     * @param id ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Regresa el RFC.
     *
     * @return RFC.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Establece el RFC.
     *
     * @param RFC RFC de la persona.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Regresa el nombre.
     *
     * @return Nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre.
     *
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa la fecha de nacimiento.
     *
     * @return Fecha de nacimiento.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento.
     *
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Regresa el teléfono.
     *
     * @return Teléfono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono.
     *
     * @param telefono Teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Regresa los trámites.
     *
     * @return Trámites.
     */
    public List<Tramites> getTramites() {
        return tramites;
    }

    /**
     * Establece los trámites.
     *
     * @param tramites Trámites de la persona.
     */
    public void setTramites(List<Tramites> tramites) {
        this.tramites = tramites;
    }

    /**
     * Representación textual de la persona.
     *
     * @return Nombre y RFC en formato legible.
     */
    @Override
    public String toString() {
        return nombre + " (" + RFC + ")";
    }
}
