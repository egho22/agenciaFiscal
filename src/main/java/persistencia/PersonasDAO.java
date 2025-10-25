/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import entidades.Persona;
import interfaces.iPersonasDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

/**
 * La clase PersonasDAO implementa la interfaz iPersonasDAO y proporciona
 * métodos para realizar operaciones en una base de datos.
 *
 * @author Jesus Rodrigo Villegas Arguelles 261186
 * @author Alejandro Rodríguez Lugo 251622
 * @author Héctor Javier Alonso Zaragoza 252039
 */
public class PersonasDAO implements iPersonasDAO {

    /**
     * Generar conexión con la base de datos.
     */
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("connectionPU");

    /**
     * Agrega una persona en la base de datos.
     *
     * @param p Persona.
     * @return True si fue posible agregar, false en caso contrario.
     */
    @Override
    public boolean Agregar(Persona p) {
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
     * Consulta todas las personas.
     *
     * @return Lista de todas las personas.
     */
    @Override
    public List<Persona> ConsultarTodos() {
        EntityManager em = emf.createEntityManager();
        em.getEntityManagerFactory().getCache().evictAll();
        em.getTransaction().begin();
        CriteriaQuery criteria = em.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Persona.class)).distinct(true);
        Query query = em.createQuery(criteria);
        List<Persona> usuarios = query.getResultList();
        em.getTransaction().commit();
        return usuarios;
    }

    /**
     * Consulta una persona por ID.
     *
     * @param ID ID de la persona.
     * @return Persona con el ID correspondiente.
     */
    @Override
    public Persona ConsultarID(Long ID) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Persona p = em.find(Persona.class, ID);
        em.getTransaction().commit();
        if (p == null) {
            return null;
        } else {
            return p;
        }
    }

    /**
     * Busca una persona acorde ciertos elementos.
     *
     * @param RFC RFC como parámetro.
     * @param nombre Nombre como parámetro.
     * @param anioNacimiento Año de nacimiento como parámetro.
     * @return Resultado de personas con esos elementos.
     */
    @Override
    public List<Persona> buscarPersonas(String RFC, String nombre, Integer anioNacimiento) {
        EntityManager em = emf.createEntityManager();
        List<Persona> resultados = new ArrayList<>();
        try {
            String jpql = "SELECT p FROM Persona p WHERE 1=1";
            if (RFC != null && !RFC.isEmpty()) {
                jpql += " AND p.RFC LIKE :rfc";
            }
            if (nombre != null && !nombre.isEmpty()) {
                jpql += " AND LOWER(p.nombre) LIKE :nombre";
            }
            if (anioNacimiento != null) {
                jpql += " AND p.fechaNacimiento BETWEEN :inicioAnio AND :finAnio";
            }
            TypedQuery<Persona> query = em.createQuery(jpql, Persona.class);
            if (RFC != null && !RFC.isEmpty()) {
                query.setParameter("rfc", "%" + RFC + "%");
            }
            if (nombre != null && !nombre.isEmpty()) {
                query.setParameter("nombre", "%" + nombre.toLowerCase() + "%");
            }
            if (anioNacimiento != null) {
                LocalDate inicio = LocalDate.of(anioNacimiento, 1, 1);
                LocalDate fin = LocalDate.of(anioNacimiento, 12, 31);
                query.setParameter("inicioAnio", inicio);
                query.setParameter("finAnio", fin);
            }
            resultados = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultados;
    }

}
