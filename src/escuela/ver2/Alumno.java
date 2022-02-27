package escuela.ver2;

public class Alumno {
//    Se añade la propiedad estática para ir añadiendo Alumnos 'unicos' según se instancie
    private static int totAlumnos = 0;
    private int codAlumno;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private byte edad;
    private Profesor profesor;

    public Alumno() {
	// TODO Auto-generated constructor stub
	this.codAlumno = ++Alumno.totAlumnos;
    }

    /**
     * Constructor principal de la clase Alumno
     * 
     * @param nombre    Nombre del alumno
     * @param apellido1 1er apellido del alumno
     * @param apellido2 2do apellido del alumno
     * @param edad      edad del alumno
     */
    public Alumno(String nombre, String apellido1, String apellido2, byte edad) {
	// TODO Auto-generated constructor stub
	this();
	this.nombre = nombre;
	this.apellido1 = apellido1;
	this.apellido2 = apellido2;
	this.edad = edad;
    }

    public String obtenerNombreCompleto() {
	return this.nombre + " " + this.apellido1 + " " + this.apellido2;
    }

    public String obtenerNombreFormato2() {
	return this.apellido1 + " " + this.apellido2 + ", " + this.nombre;
    }

    public String darRespuesta(String respuesta) {
	return respuesta;
    }

    @Override
    public String toString() {
	// TODO Auto-generated method stub
	return "Alumno: (" + this.codAlumno + ") " + obtenerNombreCompleto() + " (" + this.edad + " años)";
    }

//    GETTERS & SETTERS
    public int getCodAlumno() {
	return this.codAlumno;
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

    public byte getEdad() {
	return edad;
    }

    public void setEdad(byte edad) {
	this.edad = edad;
    }

    public Profesor getProfesor() {
	return profesor;
    }

    public void setProfesor(Profesor profesor) {
	this.profesor = profesor;
    }

}
