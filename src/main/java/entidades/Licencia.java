/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Representa la entidad Licencia en el sistema de Agencia Fiscal.
 *
 * Esta clase extiende de Tramites, lo que refleja la herencia en el modelo
 * entidad-relación, donde cada Licencia es un tipo específico de tramite.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
@Entity
@Table(name = "Licencia")
@PrimaryKeyJoinColumn(name = "id")
public class Licencia extends Tramites {

    /**
     * Duración de la licencia.
     */
    @Column(name = "Vigencia", nullable = false)
    private int vigencia;

    /**
     * Fecha de expedición de la licencia.
     */
    @Column(name = "fechaExpedicion", nullable = false)
    private LocalDate fechaExpedicion;

    /**
     * Tipo de licencia.
     */
    @Column(name = "tipoLicencia", nullable = false)
    private String tipo;

    /**
     * Regresa la vigencia.
     *
     * @return Vigencia.
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia.
     *
     * @param vigencia Vigencia de la licencia.
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Regresa la fecha de expedición.
     *
     * @return Fecha de expedición.
     */
    public LocalDate getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Regresa el tipo de licencia
     *
     * @return Tipo de licencia.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de licencia.
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Establece la fecha de expedición.
     *
     * @param fechaExpedicion Fecha de expedición.
     */
    public void setFechaExpedicion(LocalDate fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
}
