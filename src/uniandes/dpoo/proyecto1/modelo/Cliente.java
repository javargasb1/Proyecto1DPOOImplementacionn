package uniandes.dpoo.proyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Cliente implements Usuario
{
	private String nombre;
	private String login;
	private String clave;
	private ArrayList<String> datosContacto;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private String imagenDocumento;
	private LicenciaConduccion datosLicencia;               
	private ArrayList<String> datosTarjeta;

	
	
	public Cliente(String nombre, String login, String clave, ArrayList<String> datosContacto, LocalDate nacimiento, 
			String nacionalidad, String imagenDocumento,
			LicenciaConduccion datosLicencia,ArrayList<String> datosTarjeta)
	{
		this.nombre = nombre;
		this.login =login;
		this.clave= clave;
		this.datosContacto = datosContacto;
		this.fechaNacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.imagenDocumento = imagenDocumento;
		this.datosLicencia = datosLicencia;
		this.datosTarjeta = datosTarjeta;
	}
	
	public String getLogin() {

		return login;
	}
	
	public String getClave() {

		return clave;
	}
	
	public String getNombre() {

		return nombre;
	}
	public ArrayList<String> getDatosContacto() {

		return datosContacto;
	}
	
	public Reserva crearReserva(Cliente elCliente,String categoria,Sede sede,LocalDate fechaRecogida,LocalTime horaRecogida,boolean especial,ArrayList<Vehiculo>  listaVehiculos,LocalDate fechaDevuelta, ArrayList<LocalTime>rangoDeHoras,String temporada,Sede sedeEntrega,Double precio,ArrayList<Double> costoSeguros,Double costoConductorAdicional, ArrayList<LicenciaConduccion> conductoresAdicionales)
	{
		Reserva nuevaReserva = new Reserva(elCliente,categoria,sede,fechaRecogida,horaRecogida,especial,listaVehiculos,fechaDevuelta, rangoDeHoras,temporada,sedeEntrega,precio,costoSeguros,costoConductorAdicional, conductoresAdicionales);
		ArrayList<Usuario> listaempleados = Sede.getEmpleados();
		boolean encontrado = false;
		int i = 0;
		Usuario empleadoreal = null;
		Usuario empleado;
		while(encontrado == false && i<listaempleados.size())
		{
			empleado = listaempleados.get(i);
			if (empleadoreal.getWork().equals("ActualizadorEstadoVehiculo"))
			{
				encontrado = true;
				empleadoreal = empleado;
			}
			i +=1;
				
		}
		ActualizadorEstadoVehiculo actualizar = new ActualizadorEstadoVehiculo(empleadoreal.getLogin(), empleadoreal.getClave(), empleadoreal.getNombre(), empleadoreal.getUbi());
		actualizar.actualizarEstado(fechaRecogida, fechaDevuelta);
		return nuevaReserva;
	}

	@Override
	public String getUbi() {
		
		return null;
	}

	@Override
	public String getWork() {
		
		return "Cliente";
	}

	public String getNacionalidad() {
		
		return nacionalidad;
	}

	public String getDocumento() {
		return imagenDocumento;
	}

	public LicenciaConduccion getLicencia() {
		return datosLicencia;
	}

	public ArrayList<String> getPago() {

		return datosTarjeta;
	}

	public LocalDate getNacimiento() {
	
		return fechaNacimiento;
	}

}