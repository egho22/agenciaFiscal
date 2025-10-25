/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Tramites;
import java.util.List;

/**
 * Interfaz iTramiteDAO que proporciona métodos para realizar conexión en una
 * base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public interface iTramiteDAO {

    /**
     * Consulta todos los trámites.
     * @return Trámites.
     */
    public List<Tramites> ConsultarTodos();
}
