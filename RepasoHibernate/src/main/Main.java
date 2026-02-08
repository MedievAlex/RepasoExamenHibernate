package main;
import dao.DBImplementation;
import dao.JPAUtil;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            JPAUtil.getEntityManagerFactory();
            
            int opcion;
            DBImplementation dao = new DBImplementation();
            
            System.out.println("Introduce una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    dao.editarEstudiante(2, "Ekaitz");
                    break;
                case 2:
                    dao.mayorEstudiante();
                    break;
            }
        }
    }
}