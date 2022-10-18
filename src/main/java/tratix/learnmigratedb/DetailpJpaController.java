/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tratix.learnmigratedb;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import tratix.learnmigratedb.exceptions.NonexistentEntityException;
import tratix.learnmigratedb.exceptions.PreexistingEntityException;

/**
 *
 * @author iqbal al habib
 */
public class DetailpJpaController implements Serializable {

    public DetailpJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detailp detailp) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detailp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetailp(detailp.getId()) != null) {
                throw new PreexistingEntityException("Detailp " + detailp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detailp detailp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detailp = em.merge(detailp);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = detailp.getId();
                if (findDetailp(id) == null) {
                    throw new NonexistentEntityException("The detailp with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detailp detailp;
            try {
                detailp = em.getReference(Detailp.class, id);
                detailp.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detailp with id " + id + " no longer exists.", enfe);
            }
            em.remove(detailp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detailp> findDetailpEntities() {
        return findDetailpEntities(true, -1, -1);
    }

    public List<Detailp> findDetailpEntities(int maxResults, int firstResult) {
        return findDetailpEntities(false, maxResults, firstResult);
    }

    private List<Detailp> findDetailpEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detailp.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Detailp findDetailp(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detailp.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetailpCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detailp> rt = cq.from(Detailp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
