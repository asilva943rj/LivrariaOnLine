/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.repositorio;

import com.livrariaonline.entidades.Autor;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander.Silva
 */
@Repository
public class AutorRepositorio {

    private final EntityManagerFactory factory;

    public AutorRepositorio() {

        factory = Persistence.createEntityManagerFactory("livrariaonline");
    }

    public List<Autor> listaAutores() {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Autor> query = builder.createQuery(Autor.class);

            List<Autor> autores = em.createQuery(query.select(query.from(Autor.class))).getResultList();

            transaction.commit();

            return autores;

        } catch (Exception ex) {

            if (transaction != null && transaction.isActive()) {

                transaction.rollback();
            }
            ex.printStackTrace();

            return new LinkedList<>();

        } finally {

            if (em != null && em.isOpen()) {

                em.close();
            }
        }
    }

    public void adicionaAutor(Autor autor) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            em.persist(autor);

            transaction.commit();
        } catch (Exception ex) {

            if (transaction != null && transaction.isActive()) {

                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {

            if (em != null && em.isOpen()) {

                em.close();
            }
        }

    }

    public void atualizaAutor(Autor autor) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            em.merge(autor);

            transaction.commit();
        } catch (Exception ex) {

            if (transaction != null && transaction.isActive()) {

                transaction.rollback();

            }
            ex.printStackTrace();
        } finally {

            if (em != null && em.isOpen()) {

                em.close();
            }
        }
    }

    public void removeAutor(Autor autor) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            Autor recuperaAutor = em.find(Autor.class, autor.getId());

            if (recuperaAutor != null) {

                transaction.begin();
                em.remove(autor);
                transaction.commit();

            }
        } catch (Exception ex) {

            if (transaction != null && transaction.isActive()) {

                transaction.rollback();

            }
            ex.printStackTrace();
        } finally {

            if (em != null && em.isOpen()) {

                em.close();
            }
        }
    }
    
    public Autor getById(Long id){
        
        EntityManager em = factory.createEntityManager();
        return em.find(Autor.class, id);
    }
    
    public void close(){
        
        factory.close();
    }
}
