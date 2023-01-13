/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinalExam.finaexam;

import static FinalExam.finaexam.Masyarakat_.id;
import FinalExam.finaexam.exceptions.NonexistentEntityException;
import FinalExam.finaexam.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 047
 */
public class MasyarakatJpaController implements Serializable {

    public MasyarakatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Masyarakat masyarakat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(masyarakat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMasyarakat(masyarakat.getId()) != null) {
                throw new PreexistingEntityException("Masyarakat " + masyarakat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Masyarakat masyarakat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            masyarakat = em.merge(masyarakat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = masyarakat.getId();
                if (findMasyarakat(id) == null) {
                    throw new NonexistentEntityException("The masyarakat with id " + id + " no longer exists.");
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
            Masyarakat masyarakat;
            try {
                masyarakat = em.getReference(Masyarakat.class, id);
                masyarakat.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The masyarakat with id " + id + " no longer exists.", enfe);
            }
            em.remove(masyarakat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Masyarakat> findMasyarakatEntities() {
        return findMasyarakatEntities(true, -1, -1);
    }

    public List<Masyarakat> findMasyarakatEntities(int maxResults, int firstResult) {
        return findMasyarakatEntities(false, maxResults, firstResult);
    }

    private List<Masyarakat> findMasyarakatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Masyarakat.class));
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

    public Masyarakat findMasyarakat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Masyarakat.class, id);
        } finally {
            em.close();
        }
    }

    public int getMasyarakatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Masyarakat> rt = cq.from(Masyarakat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    private void load_table(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Nik");
        model.addColumn("Name");
        model.addColumn("TG");
        model.addColumn("photo");
        
     try {
            int no=1;
            String sql = "select * from mhs";
            var conn=(Connection)Masyarakat.MasyarakatDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }
            jTable1.setModel(model);
        } catch (Exception e) {
        }
    }
}
