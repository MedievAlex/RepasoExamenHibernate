package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Estudiante;
import utilidades.Utilidades;

public class Main {

    public static void main(String[] args) {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceFile");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Estudiante estudiante = new Estudiante();
        
        int option;

        do {
            System.out.println("***************************************");
            option = showMenu();
            System.out.println("***************************************");

            switch (option) {
                case 1: // 1. Create
                	create(entityManager, estudiante);
                    break;
                case 2: // 2. Read
                	read(entityManager, estudiante);
                    break;
                case 3: // 3. Update
                	update(entityManager, estudiante);
                    break;
                case 4: // 3. Delete
                	delete(entityManager, estudiante);
                    break;
            }
        } while (option != 0);
        
        entityManagerFactory.close();
    }
    
    private static int showMenu() {
    	System.out.println("###################[MENU]###################");
    	System.out.println("1- Create");
    	System.out.println("2- Read");
    	System.out.println("3- Update");
    	System.out.println("4- Delete");
    	System.out.println("0- EXIT");

    	System.out.print("Choose: ");
    	return Utilidades.leerInt(0, 4);
    }
    
    private static void create(EntityManager entityManager, Estudiante estudiante) {
         entityManager.persist(estudiante); // Guardar en la Base de Datos
         entityManager.getTransaction().commit();

         entityManager.close();
    }

    private static void read(EntityManager entityManager, Estudiante estudiante) {
    	List<Estudiante> estudiantes = entityManager.createNamedQuery("Estudiante.listarEstudiantes", Estudiante.class).getResultList();
    	
    	entityManager.close();
    	
    	for(Estudiante est : estudiantes) {
    		est.toString();
    	}
    }

    private static void update(EntityManager entityManager, Estudiante estudiante) {
    	estudiante.setEdad(18); // Lo actualiza en la Base de Datos tras el commit
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    private static void delete(EntityManager entityManager, Estudiante estudiante) {
    	entityManager.remove(estudiante);

        entityManager.close();
    }
}
