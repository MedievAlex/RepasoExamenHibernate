package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Ekasestao
 */

@Entity
@Table(name = "Clase")
public class Clase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 40)
    private String nombre;
    
    @OneToMany(mappedBy = "clase")
    private List<Inscrito> inscripciones = new ArrayList<> ();
    
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
    
    public Clase() {}

    public Clase(String nombre, List<Inscrito> inscripciones, Profesor profesor) {
        this.nombre = nombre;
        this.inscripciones = inscripciones;
        this.profesor = profesor;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inscrito> getEstudiantes() {
        return inscripciones;
    }

    public void setEstudiantes(List<Inscrito> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Clase{" + "nombre=" + nombre + ", estudiantes=" + inscripciones + ", profesor=" + profesor + '}';
    }
}
