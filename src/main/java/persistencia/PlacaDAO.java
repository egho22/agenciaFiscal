/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Placa;
import interfaces.iPlacaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 * La clase PlacaDAO implementa la interfaz iPlacaDAO y proporciona métodos para
 * realizar operaciones en una base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public class PlacaDAO implements iPlacaDAO {

    /**
     * Generar conexión con la base de datos.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");

    /**
     * Agrega una placa en la base de datos.
     *
     * @param p Placa.
     * @return True si fue posible agregar, false en caso contrario.
     */
    @Override
    public boolean Agregar(Placa p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
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
     * Actualiza una placa en la base de datos.
     *
     * @param placa2 Placa.
     * @param ID Id de placa a actualizar.
     */
    @Override
    public void Actualizar(Long ID, Placa placa2) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Placa placa = em.find(Placa.class, ID);
        if (placa != null) {
            placa.setEstado(placa2.getEstado());
            placa.setFechaRecepcion(placa2.getFechaRecepcion());
            em.persist(placa);
            em.getTransaction().commit();
        }
    }

    /**
     * Consulta todas las placas.
     * @return Todas las placas.
     */
    @Override
    public List<Placa> ConsultarTodos() {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Placa.class)).distinct(true);
        Query query = em.createQuery(criteria);
        List<Placa> p = query.getResultList();
        em.getTransaction().commit();
        return p;
    }

    /**
     * Consulta placa por número correspondiente.
     * @param numeroPlaca Número de placa.
     * @return Placa con el número correspondiente.
     */
    @Override
    public Placa ConsultarPorNumPlaca(String numeroPlaca) {
        EntityManager em = emf.createEntityManager();
        Placa placa = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Placa> query = em.createQuery("SELECT p FROM Placa p WHERE p.numeroPlaca = :numeroPlaca", Placa.class);
            query.setParameter("numeroPlaca", numeroPlaca);
            placa = query.getSingleResult();
            em.getTransaction().commit();
        } catch (NoResultException e) {
            placa = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return placa;
    }
}
