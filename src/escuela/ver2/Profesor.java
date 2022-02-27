package escuela.ver2;

public class Profesor {
//    Se añade la propiedad estática para ir añadiendo profesores 'unicos' según se instancie
    private static int totProfesores = 0;
    private int codProfesor;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private String asignatura;

    public Profesor() {
	// TODO Auto-generated constructor stub
	this.codProfesor = ++Profesor.totProfesores;
    }

    public Profesor(String nombre, String apellido1, String apellido2, int edad, String asignatura) {
	// TODO Auto-generated constructor stub
	this();
	this.nombre = nombre;
	this.apellido1 = apellido1;
	this.apellido2 = apellido2;
	this.edad = edad;
	this.asignatura = asignatura;
    }

    public String obtenerNombreCompleto() {
	return this.nombre + " " + this.apellido1 + " " + this.apellido2;
    }

    public String preguntarEjercicio(int ejercicio) {
	return " "; // ??

    }

    public String nombreYAsignatura() {
	return this.obtenerNombreCompleto() + " (" + this.asignatura + ")";
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "Profesor: (" + this.codProfesor + ") " + obtenerNombreCompleto() + " (" + this.asignatura + ")";
    }

//    GETTERS & SETTERS

    public int getCodProfesor() {
	return this.codProfesor;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido1() {
	return apellido1;
    }

    public void setApellido1(String apellido1) {
	this.apellido1 = apellido1;
    }

    public String getApellido2() {
	return apellido2;
    }

    public void setApellido2(String apellido2) {
	this.apellido2 = apellido2;
    }

    public int getEdad() {
	return edad;
    }

    public void setEdad(int edad) {
	this.edad = edad;
    }

    public String getAsignatura() {
	return asignatura;
    }

    public void setAsignatura(String asignatura) {
	this.asignatura = asignatura;
    }

}
