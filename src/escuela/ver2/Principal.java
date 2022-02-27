package escuela.ver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author GRUPO-3
 * @since Java 8
 *
 */
public class Principal {
    private static HashMap<Integer, Alumno> alumnos = new HashMap<Integer, Alumno>();
    private static HashMap<Integer, Profesor> profesores = new HashMap<Integer, Profesor>();
    private static HashMap<Integer, Aula> aulas = new HashMap<Integer, Aula>();
    private static HashMap<String, Asignatura> asignaturas = new HashMap<String, Asignatura>();
    private static ArrayList<NotasAlumno> notasAlumnos = new ArrayList<NotasAlumno>();

    /**
     * Constructor principal
     */
    public Principal() {
	// TODO Auto-generated constructor stub
    }

    /**
     * Método de ejecución pricipal
     * 
     * @param args NO USADO
     */
    public static void main(String[] args) {
	int opc;

	carga();
	do {
	    opc = showMenu();

	    if (opc != 0)
		runOpcion(opc);

	} while (opc != 0);

	System.out.println("Gracias por usar mi app... fin!!");

    }

    /**
     * Visualiza el menú de la APP
     */
    private static int showMenu() {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	int opc;

	System.out.println();
	System.out.println("*".repeat(30));
	System.out.println("    Escuela Tech Dreaming");
	System.out.println("        MENÚ Principal");
	System.out.println("*".repeat(30));
	System.out.println("1.- Visualizar 'Alumnos'");
	System.out.println("2.- Visualizar 'Profes'");
	System.out.println("3.- Visualizar 'Aulas'");
	System.out.println("4.- visualizar 'Asignaturas'");
	System.out.println("          ------");
	System.out.println("5.- Info asignatura");
	System.out.println("6.- Info profesor");
	System.out.println("7.- Info alumno");
	System.out.println("8.- Notas del alumno");

	System.out.print("\nOpción (0->Salir): ");

	try {
	    opc = Integer.parseInt(teclado.readLine());
	} catch (NumberFormatException | IOException e) {
	    // TODO Auto-generated catch block
	    System.out.println("\nOpción NO válida!!\n");
	    opc = 99;
	}
	return opc;
    }

    /**
     * Llama a todos los procesos de carga de datosy
     */
    private static void carga() {
	System.out.print("Cargando datos... ");
	cargaAlumnos();
	cargaProfesores();
	cargaAulas();
	asignaProfesoresTutor(); // Se hace para que cada alumno tenga un 'tutor'
	cargaNotasAlumnos();
	System.out.println("done!!");
    }

    /**
     * Carga los datos de Alumnos
     */
    private static void cargaAlumnos() {
	Alumno alu;

	System.out.print("Alumnos... ");

	alu = new Alumno("José Ricardo", "Sánchez", "Morante", (byte) 14);
	alumnos.put(alu.getCodAlumno(), alu);

	alu = new Alumno("Pedro", "Martínez", "de la Rosa", (byte) 17);
	alumnos.put(alu.getCodAlumno(), alu);

	alu = new Alumno("Luisa", "Duarte", "Mora", (byte) 13);
	alumnos.put(alu.getCodAlumno(), alu);

	alu = new Alumno("María Rosa", "Silva", "Morante", (byte) 13);
	alumnos.put(alu.getCodAlumno(), alu);

	alu = new Alumno("Enrique", "Salsa", "Giménez", (byte) 16);
	alumnos.put(alu.getCodAlumno(), alu);
    }

    /**
     * Asigna un profesor 'tutor' a cada alumno Se asigna el 'tutor' que tenga su
     * mismo codigo
     */
    private static void asignaProfesoresTutor() {
	Alumno alu;
	System.out.print("Asignando tutores... ");
	for (Profesor profesor : profesores.values()) {
	    alu = alumnos.get(profesor.getCodProfesor()); // Cogemos el alumno
	    alu.setProfesor(profesor); // Asignamos el 'tutor'
	    alumnos.put(alu.getCodAlumno(), alu); // Actualizamos el hashMap
	}
    }

    /**
     * Carga los datos de Profesores
     */
    private static void cargaProfesores() {
	Profesor profe;

	System.out.print("Profesores... ");

	profe = new Profesor("Luís", "de la Casa", "Mayor", 43, "Matemáticas");
	profesores.put(profe.getCodProfesor(), profe);

	profe = new Profesor("Pedro", "Miró", "Menor", 51, "Literatura");
	profesores.put(profe.getCodProfesor(), profe);

	profe = new Profesor("Encarni", "Liante", "Ríos", 29, "Educ.Física");
	profesores.put(profe.getCodProfesor(), profe);

	profe = new Profesor("Amparo", "Mirador", "Vyacheslav", 38, "Sociales");
	profesores.put(profe.getCodProfesor(), profe);

	profe = new Profesor("Susana", "Mecano", "Alcina", 36, "Valenciano");
	profesores.put(profe.getCodProfesor(), profe);
    }

    /**
     * Carga los datos de Aulas
     */
    private static void cargaAulas() {
	Aula aula;

	System.out.print("Aulas... ");

	aula = new Aula("1roA", 1, 20);
	aulas.put(aula.getNumero_aula(), aula);
	aula = new Aula("2doA", 2, 20, false);
	aulas.put(aula.getNumero_aula(), aula);

	aula = new Aula("1roB", 3, 23);
	aulas.put(aula.getNumero_aula(), aula);

	aula = new Aula("3roA", 4, 25, false);
	aulas.put(aula.getNumero_aula(), aula);

	aula = new Aula("2doB", 5, 25);
	aulas.put(aula.getNumero_aula(), aula);

	cargaAsignaturas(); // Se cargan las asignaturas dependiendo de los
	// datos introducidos en Profesores y aulas
    }

    /**
     * Carga los datos de asignaturas
     */
    private static void cargaAsignaturas() {
	ArrayList<Aula> arrAulas = new ArrayList<Aula>();
	String nomAsig;
	Aula aula;
	int numAula = 0;
	Asignatura asignatura;

	arrAulas.addAll(aulas.values());
	asignaturas.clear();
	for (Profesor profesor : profesores.values()) {
	    nomAsig = profesor.getAsignatura();
	    aula = arrAulas.get(numAula);
	    asignatura = new Asignatura(nomAsig, profesor, aula);
	    asignaturas.put(nomAsig, asignatura);
	    numAula++;
	}
    }

    /**
     * Carga valores 'aleatorios' entre 0 y 10 para las notas
     */
    private static void cargaNotasAlumnos() {
	double numAleatorio;

	for (Alumno alumno : alumnos.values()) {
	    for (Asignatura asignatura : asignaturas.values()) {
		numAleatorio = (Math.random() * 10);
		notasAlumnos.add(new NotasAlumno(alumno, asignatura, numAleatorio));
	    }
	}
    }

    /**
     * Llama al proceso correspondiente según la opción recibida
     * 
     * @param opcion Opción seleccionada en el menú
     */
    private static void runOpcion(int opcion) {
	switch (opcion) {

	case 1: {
	    showAlumnos();
	    break;
	}
	case 2: {
	    showProfesores();
	    break;
	}
	case 3: {
	    showAulas();
	    break;
	}
	case 4: {
	    showAsignaturas();
	    break;
	}
	case 5: {
	    showInfoAsignatura();
	    break;
	}
	case 6: {
	    showInfoProfesor();
	    break;
	}
	case 7: {
	    showInfoAlumno();
	    break;
	}
	case 8: {
	    showNotasAlumno();
	    break;
	}
	}
	System.out.println("\n---> FIN OPERACIÓN <---");
    }

    /**
     * Método auxiliar para visualizar los títulos según se elija en el menú
     * 
     * @param title
     */
    private static void showTitle(String title) {
	System.out.println();
	System.out.println("*".repeat(50));
	System.out.println("\t" + title.toUpperCase());
	System.out.println("*".repeat(50));
    }

    /**
     * Visualiza TODOS los registros de alumnos
     */
    private static void showAlumnos() {
	showTitle("Listado de Alumnos");
	for (Alumno alumno : alumnos.values()) {
	    System.out.println(alumno);
	}
    }

    /**
     * Visuzaliza TODOS los registros de Profesores
     */
    private static void showProfesores() {
	showTitle("Listado de Profesores");
	for (Profesor profesor : profesores.values()) {
	    System.out.println(profesor);
	}
    }

    /**
     * Visuzaliza TODOS los registros de Aulas
     */
    private static void showAulas() {
	showTitle("Listado de Aulas");
	for (Aula aula : aulas.values()) {
	    System.out.println(aula);
	}
    }

    /**
     * Visuzaliza TODOS los registros de Asignaturas
     */
    private static void showAsignaturas() {
	showTitle("Listado de Asignaturas");
	for (Asignatura asignatura : asignaturas.values()) {
	    System.out.println(asignatura);
	}
    }

    /**
     * Visualiza los datos de una asignatura en concreto. Visualiza TODAS las aulas
     * existentes y pregunta por el nombre de la asignatura y visuzalida su profesor
     * y aula
     */
    private static void showInfoAsignatura() {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	String asignatura;

	showTitle("Consulta de asignatura");
	System.out.print("\n** Nombre asignatura a consultar: ");
	try {
	    asignatura = teclado.readLine();
	    if (!asignatura.isBlank()) {
		if (asignaturas.containsKey(asignatura)) {
		    System.out.println(asignaturas.get(asignatura));
		} else
		    System.out.printf("La asignatura (%s) NO existe", asignatura);
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println();
    }

    /**
     * Visuzaliza el aula que tiene asignada un profesor. Visuzaliza el listado de
     * TODOS los profesores y solita el código del profesor que queremos saber su
     * aula
     */
    private static void showInfoProfesor() {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	int profesor;

	showTitle("Consulta de datos de un profesor");
	showProfesores();
	System.out.print("\n** Cod. Profesor a consultar (0-Salir): ");
	try {
	    profesor = Integer.parseInt(teclado.readLine());
	    if (profesor != 0) {
		if (profesores.containsKey(profesor)) {
		    Profesor profe = profesores.get(profesor);
		    String asignatura = profe.getAsignatura();
		    if (asignatura != null) {
			Asignatura asig = asignaturas.get(asignatura);
			if (asig != null) {
			    System.out.printf("El profesor %s es tutor de la asignatura %s ", profesor,
				    asig.getNombre());
			    System.out.printf("en el aula %s\n", asig.getAula().getNombre());
			} else
			    System.out.println("NO se ha encontrado el aula");
		    } else
			System.out.println("No se ha podido encontrar el aula");
		} else
		    System.out.println("NO se ha encontrado el profesor: " + profesor);
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Visuzaliza el aula que tiene asignada un profesor. Visuzaliza el listado de
     * TODOS los profesores y solita el código del profesor que queremos saber su
     * aula
     */
    private static void showInfoAlumno() {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	int alumno;
	Profesor profe;
	Asignatura asignatura;
	Aula aula;

	showAlumnos();

	System.out.print("\n** Cod. alumno a consultar (0-Salir): ");
	try {
	    alumno = Integer.parseInt(teclado.readLine());
	    if (alumno != 0) {
		if (alumnos.containsKey(alumno)) {
		    profe = alumnos.get(alumno).getProfesor();
		    asignatura = asignaturas.get(profe.getAsignatura());
		    aula = asignatura.getAula();
		    System.out.printf("Info del alumno: %s\n", alumno);
		    System.out.printf("\t%s\n", profe);
		    System.out.printf("\t%s\n", aula);

		} else
		    System.out.println("NO se ha encontrado el alumno: " + alumno);
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * Visualiza TODAS las notas de un alumno Visuzaliza TODOS los alumnos y
     * solicita el código del alumno a consultar sus notas
     */
    private static void showNotasAlumno() {
	BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
	int codAlumno;
	Profesor profe;
	Alumno alu;

	showTitle("Ver notas de un alumno");
	showAlumnos();

	System.out.print("\n** Cod. alumno a consultar notas (0-Salir): ");
	try {
	    codAlumno = Integer.parseInt(teclado.readLine());
	    if (codAlumno != 0) {
		if (alumnos.containsKey(codAlumno)) {
		    alu = alumnos.get(codAlumno);
		    System.out.println("\n*** NOTAS");
		    System.out.print("\n*** ");
		    System.out.println(alu);
		    
		    for (NotasAlumno nota : notasAlumnos) {
			if (nota.getAlumno().equals(alu)) {
			    profe = nota.getAsignatura().getProfesor();
			    System.out.printf("\t%s (nota: %.2f) - Profesor: %s\n", profe.getAsignatura(),
				    nota.getNota(), profe.obtenerNombreCompleto());
			}
		    }
		} else
		    System.out.println("NO se ha encontrado el alumno: " + codAlumno);
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
}
