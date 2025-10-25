/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Persona;
import java.util.List;

/**
 * Interfaz iPersonasDAO que proporciona métodos para realizar conexión en una
 * base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public interface iPersonasDAO {

    /**
     * Agrega una persona en la base de datos.
     *
     * @param p Persona.
     * @return True si fue posible agregar, false en caso contrario.
     */
    public boolean Agregar(Persona p);

    /**
     * Consulta todas las personas.
     *
     * @return Lista de todas las personas.
     */
    public List<Persona> ConsultarTodos();

    /**
     * Consulta una persona por ID.
     *
     * @param ID ID de la persona.
     * @return Persona con el ID correspondiente.
     */
    public Persona ConsultarID(Long ID);

    public List<Persona> buscarPersonas(String RFC, String nombre, Integer anioNacimiento);
}
