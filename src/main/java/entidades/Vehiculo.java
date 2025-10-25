/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Representa un vehiculo registrado por una persona en el sistema de la Agencia
 * Fiscal.
 *
 * Esta clase es una entidad base en una jerarquía de herencia, utilizada para
 * modelar trámites como Automovil, según el modelo entidad-relación.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    /**
     * Identificador.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * Número de serie.
     */
    @Column(name = "numeroSerie", nullable = false, unique = true)
    private String numeroSerie;
    /**
     * Marca del vehiculo.
     */
    @Column(name = "marca", nullable = false)
    private String marca;
    /**
     * Linea del vehículo.
     */
    @Column(name = "linea", nullable = false)
    private String linea;
    /**
     * Color del vehículo.
     */
    @Column(name = "color", nullable = false)
    private String color;
    /**
     * Modelo del vehículo.
     */
    @Column(name = "modelo", nullable = false)
    private String modelo;
    /**
     * Tipo de vehiculo.
     */
    @Column(name = "tipoVehiculo", nullable = false)
    private String tipoVehiculo;
    /**
     * Placas del vehiculo.
     */
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.PERSIST)
    private List<Placa> placas;

    /**
     * Regresa el número de serie.
     *
     * @return Número de serie.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el número de serie.
     *
     * @param numeroSerie Número de serie.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Regresa la marca.
     *
     * @return Marca.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca.
     *
     * @param marca Marca.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Regresa la linea del vehiculo
     *
     * @return Linea.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la linea del vehiculo.
     *
     * @param linea Linea.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Regresa el color del vehiculo.
     *
     * @return Color.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehiculo.
     *
     * @param color Color del vehiculo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Regresa el modelo.
     *
     * @return Modelo del vehiculo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo.
     *
     * @param modelo Modelo del vehiculo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Regresa las placas.
     *
     * @return Placas.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establece las placas.
     *
     * @param placas Placas del vehiculo.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Regresa el tipo de vehiculo.
     *
     * @return Tipo de vehiculo.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Establece el tipo de vehiculo.
     *
     * @param tipoVehiculo Tipo de Vehiculo.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Representación textual del vehiculo.
     *
     * @return Cadena con el identificador del vehiculo.
     */
    @Override
    public String toString() {
        return "entidades.Vehiculo[ id=" + id + " ]";
    }

}
