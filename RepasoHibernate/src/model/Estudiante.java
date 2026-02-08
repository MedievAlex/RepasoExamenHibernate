package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
	@NamedQuery(
			name = "Estudiante.listarEstudiantes",
			query = "SELECT * FROM Estudiante"
			),
	@NamedQuery(
			name = "Estudiante.listarEstudiantesMayoresDeEdad",
			query = "SELECT * FROM Estudiante WHERE e_edad > 18"
			)
	})
@Table(name="Estudiante")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="e_dni", length = 9)
    private String dni;
    
    @Column(name="e_nombre", nullable = false, length = 30)
    private String nombre;
    
    @Column(name="e_edad",nullable = false)
    private int edad;
    
    @OneToMany(mappedBy = "estudiante")
    private List<Inscrito> inscripciones = new ArrayList<> ();
    
    public Estudiante() {}

    public Estudiante(String dni, String nombre, int edad, List<Inscrito> inscripciones) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.inscripciones = inscripciones;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Inscrito> getClases() {
        return inscripciones;
    }

    public void setClases(List<Inscrito> inscripciones) {
        this.inscripciones = inscripciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", clases=" + inscripciones + '}';
    }
}
