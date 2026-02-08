package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utilidades.Utilidades;

public class Main {

    public static void main(String[] args) {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceFile");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        int option;

        entityManager.getTransaction().begin();
        entityManager.persist(""); // Insertar
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        
        do {
            System.out.println("***************************************");
            option = showMenu();
            System.out.println("***************************************");

            switch (option) {
                case 1: // 1. Create
                	create();
                    break;
                case 2: // 2. Read
                	read();
                    break;
                case 3: // 3. Update
                	update();
                    break;
                case 4: // 3. Delete
                	delete();
                    break;
            }
        } while (option != 0);
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
    
    private static void create() {
    	
    }

    private static void read() {
    	
    }

    private static void update() {
    	
    }

    private static void delete() {
    	
    }
}
