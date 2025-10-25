/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Licencia;
import entidades.Persona;
import entidades.Tramites;
import interfaces.iLicenciaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 * La clase LicenciaDAO implementa la interfaz iLicenciaDAO y proporciona
 * métodos para realizar operaciones en una base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public class LicenciaDAO implements iLicenciaDAO {

    /**
     * Generar conexión con la base de datos.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");

    /**
     * Agrega una licencia en la base de datos.
     *
     * @param l Licencia.
     * @return True si fue posible agregar, false en caso contrario.
     */
    @Override
    public boolean Agregar(Licencia l) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(l);
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
     * Consulta todas las licencias.
     *
     * @return Lista de todas las licencias.
     */
    @Override
    public List<Licencia> ConsultarTodos() {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Licencia.class)).distinct(true);
        Query query = em.createQuery(criteria);
        List<Licencia> licencias = query.getResultList();
        em.getTransaction().commit();
        return licencias;
    }
}
