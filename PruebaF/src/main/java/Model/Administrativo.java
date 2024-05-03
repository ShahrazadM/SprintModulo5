package Model;

import java.io.PrintWriter;

public class Administrativo extends Usuario implements Asesoria {

	// Atributos

	private String area;
	private String experienciaPrevia;

	// Constructor con parámetros
	public Administrativo(String nombre, String fechaNacimiento, int run, String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, getRut(), getClave());
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}

	// Constructor sin parámetros
	public Administrativo(String nombre, String fechaNacimiento, int rut, String acceso, Object object, String area2, String experienciaPrevia2) {

	}

	public Administrativo() {
		// TODO Auto-generated constructor stub
	}

	//
	// Métodos accesores para area
	public String getarea() {
		return area;
	}

	public void setarea(String area) {
		this.area = area;
	}

	// Métodos accesores para experienciaPrevia

	public String experienciaPrevia() {
		return experienciaPrevia;
	}

	public void setexperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	public void mostrarAdministrativos(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String toString() {
	    return "Administrativo [Nombre: " + getnombre() +
	            ", Fecha de nacimiento: " + getfechaNacimiento() +
	            ", RUN: " + getRun() +
	            ", Área: " + area +
	            ", Experiencia previa: " + experienciaPrevia + "]";
	}

	public static Administrativo[] getAdministrativos() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getExperienciaPrevia() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}


