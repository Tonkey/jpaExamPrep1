package test;

import entities.Project;
import entities.ProjectUser;
import entities.Task;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author nickl
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaE_PU");

    public boolean createUser(ProjectUser user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public ProjectUser findUser(String email) {
        EntityManager em = emf.createEntityManager();
        ProjectUser pu;
        try {
            em.getTransaction().begin();
            
            Query q = em.createQuery("SELECT pu FROM ProjectUser pu WHERE pu.email = :email");
            q.setParameter("email", email);
            
            em.getTransaction().commit();
            
            pu = (ProjectUser) q.getSingleResult();
        } finally {
            em.close();
        }
        return pu;
    }

    public List<ProjectUser> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<ProjectUser> users = new ArrayList();
        try {
            em.getTransaction().begin();
            TypedQuery q = em.createQuery("SELECT p FROM ProjectUser p", ProjectUser.class);
            em.getTransaction().commit();
            users = q.getResultList();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return users;
    }

    public boolean createProject(Project project) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(project);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public Project findProject(String name) {
        EntityManager em = emf.createEntityManager();
        Project p = new Project();
        try {
            em.getTransaction().begin();

            Query q = em.createQuery("SELECT p FROM Project p WHERE p.name=:name", Project.class);
            q.setParameter("name", name);
            
            em.getTransaction().commit();
            
            p = (Project) q.getSingleResult();
        } finally {
            em.close();
        }
        return p;
    }

    public boolean assignUserToProject(ProjectUser user, Project project) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Project temp = em.find(Project.class, 1);
            temp.getUsersAssigned().add(user);
            em.merge(temp);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

    public boolean createTaskAndAssignToProject(Project p, Task t) {
        EntityManager em = emf.createEntityManager();
        Project temp;
        try {
            em.getTransaction().begin();
            temp = em.find(Project.class, p.getId());
            
            t.setProject(temp);
            
            em.persist(t);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }

}
