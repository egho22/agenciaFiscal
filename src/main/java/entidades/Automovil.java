/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Representa la entidad Automovil en el sistema de Agencia Fiscal.
 *
 * Esta clase extiende de Vehiculo, lo que refleja la herencia en el modelo
 * entidad-relación, donde cada automóvil es un tipo específico de vehículo.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
@Entity
@Table(name = "Automovil")
@PrimaryKeyJoinColumn(name = "id")
public class Automovil extends Vehiculo {

    /**
     * Tipo de motor.
     */
    @Column(name = "tipoMotor", nullable = false)
    private String tipoMotor;

    /**
     * Número de puertas.
     */
    @Column(name = "numeroPuertas", nullable = false)
    private String numeroPuertas;

    /**
     * Regresa el tipo de motor.
     * @return 
     */
    public String getTipoMotor() {
        return tipoMotor;
    }

    /**
     * Establece el tipo de motor.
     * @param tipoMotor Tipo de motor.
     */
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    /**
     * Regresa el número de puertas.
     * @return Número de puertas.
     */
    public String getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
     * Establece el número de puertas.
     * @param numeroPuertas Número de puertas
     */
    public void setNumeroPuertas(String numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * Representación textual del automóvil.
     *
     * @return El número de serie del vehículo.
     */
    @Override
    public String toString() {
        return getNumeroSerie();
    }
}
