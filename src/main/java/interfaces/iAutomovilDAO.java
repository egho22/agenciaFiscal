/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Automovil;
import java.util.List;

/**
 * Interfaz iAutomovilDAO que proporciona métodos para realizar conexión en una
 * base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public interface iAutomovilDAO {

    /**
     * Agrega un automovil en la base de datos.
     *
     * @param a Automovil.
     * @return True si fue posible agregar, false en caso contrario.
     */
    public boolean Agregar(Automovil a);

    /**
     * Consulta todos los automoviles.
     *
     * @return Lista de todos los automoviles.
     */
    public List<Automovil> ConsultarTodos();

    /**
     * Consultar un automovil por número de serie.
     *
     * @param numeroSerie Número de serie.
     * @return Automovil con el número de serie.
     */
    public Automovil ConsultarPorNumSerie(String numeroSerie);
}
