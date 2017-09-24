/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.repositorio;

import com.livrariaonline.entidades.Livro;
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
public class LivroRepositorio {

    private final EntityManagerFactory factory;

    public LivroRepositorio() {

        factory = Persistence.createEntityManagerFactory("livrariaonline");
    }

    public List<Livro> listaLivros() {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Livro> query = builder.createQuery(Livro.class);

            List<Livro> livros = em.createQuery(query.select(query.from(Livro.class))).getResultList();

            transaction.commit();

            return livros;

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

    public void adicionaLivro(Livro livro) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            em.persist(livro);

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

    public void atualizaLivro(Livro livro) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            em.merge(livro);

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

    public void removeLivro(Livro livro) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            Livro recuperaLivro = em.find(Livro.class, livro.getId());

            if (recuperaLivro != null) {

                transaction.begin();
                em.remove(livro);
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

    public Livro getById(Long id) {

        EntityManager em = factory.createEntityManager();
        return em.find(Livro.class, id);
    }

    public void close() {

        factory.close();
    }
}
