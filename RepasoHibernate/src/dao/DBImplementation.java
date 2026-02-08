package dao;

import javax.persistence.EntityManager;
import model.Clase;
import model.Estudiante;

public class DBImplementation
{
    public DBImplementation() {}
    
    public void getEstudiante(String dni) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Estudiante e = em.find(Estudiante.class, dni);
            System.out.println(e);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void getClase(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Clase c = em.find(Clase.class, id);
            System.out.println(c);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void mayorEstudiante() {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            Estudiante e = em.createNamedQuery("Estudiante.findByEdadMayor", Estudiante.class).setParameter("edad", 22).getResultList().get(0);
            System.out.println(e);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void editarEstudiante(int edad, String nombre) {
        EntityManager em = JPAUtil.getEntityManager();
        
        try {
            em.getTransaction().begin();
            int result = em.createNamedQuery("Estudiante.modificarEdad").setParameter("edad", 22).setParameter("nombre", nombre).executeUpdate();
            em.getTransaction().commit();
            System.out.println(result);
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        } finally {
            em.close();
        }
    }
}
