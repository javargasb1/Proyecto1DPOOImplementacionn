package uniandes.dpoo.proyecto1.modelo;

import java.time.LocalDate;

public class ActualizadorEstadoVehiculo implements Usuario{

	private String nombre;
	private String login;
	private String clave;
	private String ubicacion;

	
	public ActualizadorEstadoVehiculo(String login, String clave, String nombre, String ubicacion)
	{
		this.login = login;
		this.clave = clave;
		this.nombre = nombre;
		this.ubicacion= ubicacion;
	}


	public String getNombre() {
		return nombre;
	}	
	
	public String getClave() {
		return clave;
	}	
	
	public String getLogin() {
		return login;
	}	
	
	public String getUbi() {
		return ubicacion;
	}	
	
	public String getWork() {
		return "ActualizadorEstadoVehiculo";
	}

	public void actualizarEstado(LocalDate fechaRecogida, LocalDate fechaDevuelta)
	{
		Vehiculo.bloquearDisponibilidad(fechaRecogida,fechaDevuelta);;
		
	}

}
