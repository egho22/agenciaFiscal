/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Placa;
import java.util.List;

/**
 * Interfaz iPlacaDAO que proporciona métodos para realizar conexión en una base
 * de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public interface iPlacaDAO {

    /**
     * Agrega una placa en la base de datos.
     *
     * @param p Placa.
     * @return True si fue posible agregar, false en caso contrario.
     */
    public boolean Agregar(Placa p);

    /**
     * Actualiza una placa en la base de datos.
     *
     * @param placa2 Placa.
     * @param ID Id de placa a actualizar.
     */
    public void Actualizar(Long ID, Placa placa2);

    /**
     * Consulta todas las placas.
     *
     * @return Todas las placas.
     */
    public List<Placa> ConsultarTodos();

    /**
     * Consulta placa por número correspondiente.
     *
     * @param numeroPlaca Número de placa.
     * @return Placa con el número correspondiente.
     */
    public Placa ConsultarPorNumPlaca(String numeroPlaca);
}
