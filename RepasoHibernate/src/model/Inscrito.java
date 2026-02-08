package model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "Inscrito")
public class Inscrito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;
    
    @Column(nullable = false, length = 10)
    private String aula;
    
    public Inscrito() {}

    public Inscrito(Estudiante estudiante, Clase clase, String aula) {
        this.estudiante = estudiante;
        this.clase = clase;
        this.aula = aula;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    @Override
    public String toString() {
        return "Inscrito{" + "estudiante=" + estudiante + ", clase=" + clase + ", aula=" + aula + '}';
    }
}
