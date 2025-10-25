/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 * Representa la entidad Placa en el sistema de Agencia Fiscal.
 *
 * Esta clase extiende de Tramites, lo que refleja la herencia en el modelo
 * entidad-relación, donde cada Placa es un tipo específico de tramite.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
@Entity
@Table(name = "Placa")
@PrimaryKeyJoinColumn(name = "id")
public class Placa extends Tramites {

    /**
     * Número de placa.
     */
    @Column(name = "numeroPlaca", nullable = false, unique = true)
    private String numeroPlaca;

    /**
     * Fecha de emisión de la placa.
     */
    @Column(name = "fechaEmision", nullable = false)
    private LocalDate fechaEmision;

    /**
     * Fecha de recepción de la placa.
     */
    @Column(name = "fechaRecepcion")
    private LocalDate fechaRecepcion;

    /**
     * Estado de la placa.
     */
    @Column(name = "Estado")
    private String estado;

    /**
     * Vehiculo con la placa.
     */
    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

    /**
     * Regresa el número de placa.
     *
     * @return Número de placa.
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * Establece el número de placa.
     *
     * @param numeroPlaca Número de placa.
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * Regresa la fecha de emisión.
     *
     * @return Fecha de emisión.
     */
    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión.
     *
     * @param fechaEmision Fecha de emisión de la placa.
     */
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Regresa la fecha de recepción.
     *
     * @return Fecha de recepción.
     */
    public LocalDate getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción.
     *
     * @param fechaRecepcion Fecha de recepción de la placa.
     */
    public void setFechaRecepcion(LocalDate fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Regresa el vehiculo.
     *
     * @return Vehiculo.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo.
     *
     * @param vehiculo Vehiculo.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Regresa el estado de la placa.
     *
     * @return Estado de la placa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     *
     * @param estado Estado de la placa.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Representación textual de la placa.
     *
     * @return Número de la placa.
     */
    @Override
    public String toString() {
        return getNumeroPlaca();
    }

}
