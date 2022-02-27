package escuela.ver2;

public class Aula {
//    Se añade la propiedad estática para ir añadiendo aulas 'unicas' según se instancie
    private static int totAulas = 0;
    private String nombre;
    private int numero_aula;
    private int capacidad;
    private boolean disponible;
//    Se añade numero de alumnos actuales
    private int numero_alumnos;

    public Aula() {
	// TODO Auto-generated constructor stub
	this.numero_aula = ++Aula.totAulas;
	this.disponible = true;
    }

    public Aula(String nombre, int numero_aula, int capacidad, boolean disponible) {
	this();
	this.nombre = nombre;
	this.numero_aula = numero_aula;
	this.capacidad = capacidad;
	this.disponible = disponible;
    }

    public Aula(String nombre, int numero_aula, int capacidad) {
	this();
	this.nombre = nombre;
	this.numero_aula = numero_aula;
	this.capacidad = capacidad;
    }

    public int numero_alumnos() {
	return this.numero_alumnos;
    }

    public boolean disponibilidad() {
	return this.disponible;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "Aula: (" + this.numero_aula + ") " + this.nombre + " " + " Cap.Max.: " + this.capacidad
		+ (this.isDisponible() ? " (DISPONIBLE)" : " (NO DISPONIBLE)");
    }

//  GETTERS & SETTERS
    public int getNumero_aula() {
	return numero_aula;
    }

    public void setNumero_aula(int numero_aula) {
	this.numero_aula = numero_aula;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public boolean isDisponible() {
	return disponible;
    }

    public void setIsDisponible(boolean disponible) {
	this.disponible = disponible;
    }

    public int getCapacidad() {
	return capacidad;
    }

    public void setCapacidad(int capacidad) {
	this.capacidad = capacidad;
    }

    public int getNumero_alumnos() {
        return numero_alumnos;
    }

    public void setNumero_alumnos(int numero_alumnos) {
        this.numero_alumnos = numero_alumnos;
    }

    

}
