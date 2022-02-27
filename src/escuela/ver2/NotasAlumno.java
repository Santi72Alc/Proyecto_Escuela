package escuela.ver2;

public class NotasAlumno {
    private Alumno alumno;
    private Asignatura asignatura;
    private double nota;
    
    public NotasAlumno() {
	// TODO Auto-generated constructor stub
    }
    
    public NotasAlumno(Alumno alumno, Asignatura asignatura, double nota) {
	super();
	this.alumno = alumno;
	this.asignatura = asignatura;
	this.nota = nota;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nota de: "+ alumno.getNombre() + " "+ alumno.getApellido1() + " "+  alumno.getApellido2() +
        	" en " + asignatura.getNombre()+" es de: " + String.format("%.2f", this.nota);
    }

    // GETTERS & SETTERS
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    

}
