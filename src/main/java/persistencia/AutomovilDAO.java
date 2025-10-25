/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Automovil;
import entidades.Persona;
import interfaces.iAutomovilDAO;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 * La clase AutomovilDAO implementa la interfaz iAutomovilDAO y proporciona
 * métodos para realizar operaciones en una base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public class AutomovilDAO implements iAutomovilDAO {

    /**
     * Generar conexión con la base de datos.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");

    /**
     * Agrega un automovil en la base de datos.
     *
     * @param a Automovil.
     * @return True si fue posible agregar, false en caso contrario.
     */
    @Override
    public boolean Agregar(Automovil a) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        } finally {
            em.close();
        }
    }

    /**
     * Consulta todos los automoviles.
     *
     * @return Lista de todos los automoviles.
     */
    @Override
    public List<Automovil> ConsultarTodos() {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Automovil.class)).distinct(true);
        Query query = em.createQuery(criteria);
        List<Automovil> a = query.getResultList();
        em.getTransaction().commit();
        return a;
    }

    /**
     * Consultar un automovil por número de serie.
     *
     * @param numeroSerie Número de serie.
     * @return Automovil con el número de serie.
     */
    @Override
    public Automovil ConsultarPorNumSerie(String numeroSerie) {
        EntityManager em = emf.createEntityManager();
        Automovil auto = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Automovil> query = em.createQuery("SELECT a FROM Vehiculo a WHERE a.numeroSerie = :numeroSerie", Automovil.class);
            query.setParameter("numeroSerie", numeroSerie);
            auto = query.getSingleResult();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            auto = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return auto;
    }

}
