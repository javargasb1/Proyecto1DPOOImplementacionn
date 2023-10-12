package uniandes.dpoo.proyecto1.modelo;

public class LicenciaConduccion
{
	private String numeroLicencia;
	private String paisExpedicion;
	private String fechaVencimiento;
	private String imagenLicencia;
	
	public LicenciaConduccion(String numeroLicencia,String paisExpedicion,
			String fechaVencimiento)
	{
		this.numeroLicencia = numeroLicencia;
		this.paisExpedicion = paisExpedicion;
		this.fechaVencimiento = fechaVencimiento;
	}
}