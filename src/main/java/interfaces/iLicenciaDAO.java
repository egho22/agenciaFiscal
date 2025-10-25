/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Licencia;
import java.util.List;

/**
 * Interfaz iLicenciaDAO que proporciona métodos para realizar conexión en una
 * base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public interface iLicenciaDAO {

    /**
     * Agrega una licencia en la base de datos.
     *
     * @param l Licencia.
     * @return True si fue posible agregar, false en caso contrario.
     */
    public boolean Agregar(Licencia l);

    /**
     * Consulta todas las licencias.
     *
     * @return Lista de todas las licencias.
     */
    public List<Licencia> ConsultarTodos();
}
