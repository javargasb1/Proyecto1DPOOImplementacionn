package uniandes.dpoo.proyecto1.modelo;

public class Cliente
{
	private String nombre;
	private String datosContacto;
	private String fechaNacimiento;
	private String nacionalidad;
	private String imagenDocumento;
	private LicenciaConduccion datosLicencia;               
	private String datosTarjeta;
	
	public Cliente(String nombre, String datosContacto, String fechaNacimiento, 
			String nacionalidad, String imagenDocumento,
			LicenciaConduccion datosLicencia,String datosTarjeta)
	{
		this.nombre = nombre;
		this.datosContacto = datosContacto;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.imagenDocumento = imagenDocumento;
		this.datosLicencia = datosLicencia;
		this.datosTarjeta = datosTarjeta;
	}
	
}