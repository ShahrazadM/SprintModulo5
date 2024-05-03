package Model;

public class Capacitacion {

	// Atributos

	private int identificador;
	private int rutCliente;
	private String dia;
	private String hora;
	private String lugar;
	private String duracion;
	private int cantidadAsistentes;

	// Constructor con parametros
	public Capacitacion(int identificador, int rutCliente, String dia, String hora, String lugar, String duracion,
			int cantidadAsistentes) {
		this.identificador = identificador;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidadAsistentes = cantidadAsistentes;
	}

	// Constructor sin parámetros
	public Capacitacion() {
	}

	// Método para mostrar el detalle de la capacitación
	public void mostrarDetalle() {
		System.out.println(
				"La capacitación será en " + lugar + " a las " + hora + " del día " + dia + ", y durará " + duracion);
	}

	// Método toString para representar la capacitación como cadena
	

	// Métodos de acceso (getters y setters) para los atributos
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public int getCantidadAsistentes() {
		return cantidadAsistentes;
	}

	public void setCantidadAsistentes(int cantidadAsistentes) {
		this.cantidadAsistentes = cantidadAsistentes;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	// Método toString para representar la capacitación como cadena
    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora="
                + hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidadAsistentes=" + cantidadAsistentes + "]";
    }
}