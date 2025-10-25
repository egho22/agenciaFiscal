/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Representa un trámite realizado por una persona en el sistema de la Agencia
 * Fiscal.
 *
 * Esta clase es una entidad base en una jerarquía de herencia, utilizada para
 * modelar trámites como Licencia y Placas, según el modelo entidad-relación.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
@Entity
@Table(name = "Tramites")
@Inheritance(strategy = InheritanceType.JOINED)
public class Tramites implements Serializable {

    /**
     * Identificador.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Persona que realizó el tramite.
     */
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    /**
     * Costo del trámite.
     */
    @Column(name = "Costo", nullable = false)
    private int costo;

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
     * Regresa la persona.
     *
     * @return Persona.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona.
     *
     * @param persona Persona que realizó el trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Regresa el costo.
     *
     * @return Costo.
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Establece el costo.
     *
     * @param costo Costo del trámite.
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Representación textual del trámite.
     *
     * @return Cadena con el identificador del trámite.
     */
    @Override
    public String toString() {
        return "entidades.Tramites[ id=" + id + " ]";
    }

}
