package Model;

import java.io.PrintWriter;

public class Profesional extends Usuario {
	private String titulo;
	private String fechaIngreso;

	// Constructor con parámetros

	public Profesional(String nombre, String fechaNacimiento, int run, String titulo, String fechaIngreso) {
		super(nombre, fechaNacimiento, getrut(), getClave());
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;

	}

	// Constructor sin parámetros
	public Profesional(String nombre, String fechaNacimiento, int rut, String acceso, Object object, String titulo2, String fechaIngreso2) {
	}

public Profesional() {
		// TODO Auto-generated constructor stub
	}

	////Métodos accesores de Profesional
	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getfechaIngreso() {
		return fechaIngreso;
	}

	public void setfechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public void mostrarProfesionales(PrintWriter out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
	    return "Profesional [Nombre: " + getnombre() +
	            ", Fecha de nacimiento: " + getfechaNacimiento() +
	            ", RUN: " + getRun() +
	            ", Título: " + titulo +
	            ", Fecha de ingreso: " + fechaIngreso + "]";
	}

	public static Profesional[] getProfesionales() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}

	

