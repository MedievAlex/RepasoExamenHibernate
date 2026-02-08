package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="p_id")
    private Long id;
    
    @Column(name="p_nombre", nullable = false, length = 40)
    private String nombre;
    
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Clase> clases = new ArrayList<>();
    
    public Profesor() {}

    public Profesor(String nombre) {
        this.nombre = nombre;
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
    
    public List<Clase> getClases() {
        return clases;
    }
    
    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    @Override
    public String toString() {
        return "Profesor{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
