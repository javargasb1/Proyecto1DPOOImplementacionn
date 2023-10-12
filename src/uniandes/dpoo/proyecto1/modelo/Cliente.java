package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class Cliente
{
	private String nombre;
	private String login;
	private String clave;
	private ArrayList<String> datosContacto;
	private String fechaNacimiento;
	private String nacionalidad;
	private String imagenDocumento;
	private LicenciaConduccion datosLicencia;               
	private ArrayList<String> datosTarjeta;
	
	public Cliente(String nombre, String login, String clave, ArrayList<String> datosContacto, String fechaNacimiento, 
			String nacionalidad, String imagenDocumento,
			LicenciaConduccion datosLicencia,ArrayList<String> datosTarjeta)
	{
		this.nombre = nombre;
		this.login =login;
		this.clave= clave;
		this.datosContacto = datosContacto;
		this.fechaNacimiento = fechaNacimiento;
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
	
}