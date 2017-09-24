/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livrariaonline.repositorio;

import com.livrariaonline.entidades.Usuario;
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
public class UsuarioRepositorio {

    private final EntityManagerFactory factory;

    public UsuarioRepositorio() {

        factory = Persistence.createEntityManagerFactory("livrariaonline");
    }

    public List<Usuario> listaUsuarios() {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);

            List<Usuario> usuarios = em.createQuery(query.select(query.from(Usuario.class))).getResultList();

            transaction.commit();

            return usuarios;

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

    public void adicionaUsuario(Usuario usuario) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            em.persist(usuario);

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

    public void atualizaUsuario(Usuario usuario) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            transaction.begin();

            em.merge(usuario);

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

    public void removeAutor(Usuario usuario) {

        EntityManager em = null;
        EntityTransaction transaction = null;

        try {

            em = factory.createEntityManager();
            transaction = em.getTransaction();

            Usuario recuperaUsuario = em.find(Usuario.class, usuario.getId());

            if (recuperaUsuario != null) {

                transaction.begin();
                em.remove(usuario);
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

    public Usuario getById(Long id) {

        EntityManager em = factory.createEntityManager();
        return em.find(Usuario.class, id);
    }

    public void close() {

        factory.close();
    }
}
