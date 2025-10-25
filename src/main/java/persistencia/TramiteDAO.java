/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Tramites;
import interfaces.iTramiteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 * La clase TramiteDAO implementa la interfaz iTramiteDAO y proporciona métodos
 * para realizar operaciones en una base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public class TramiteDAO implements iTramiteDAO {

    /**
     * Generar conexión con la base de datos.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");

    /**
     * Consulta todos los trámites.
     *
     * @return Trámites.
     */
    @Override
    public List<Tramites> ConsultarTodos() {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Tramites.class)).distinct(true);
        Query query = em.createQuery(criteria);
        List<Tramites> tramites = query.getResultList();
        em.getTransaction().commit();
        return tramites;
    }
}
