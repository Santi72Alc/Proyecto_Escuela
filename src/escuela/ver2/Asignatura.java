package escuela.ver2;

public class Asignatura {
    private String nombre;
    private Profesor profesor;
    private Aula aula;

    public Asignatura() {
	// TODO Auto-generated constructor stub
    }

    public Asignatura(String nombre, Profesor profesor, Aula aula) {
	super();
	this.nombre = nombre;
	this.profesor = profesor;
	this.aula = aula;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "Asignatura: " + this.nombre + "\n\t" + this.profesor + "\n\t" + this.aula;
    }

//  GETTERS & SETTERS

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public Profesor getProfesor() {
	return profesor;
    }

    public void setProfesor(Profesor profesor) {
	this.profesor = profesor;
    }

    public Aula getAula() {
	return aula;
    }

    public void setAula(Aula aula) {
	this.aula = aula;
    }

}
