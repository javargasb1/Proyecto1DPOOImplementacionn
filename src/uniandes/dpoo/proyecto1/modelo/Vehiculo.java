package uniandes.dpoo.proyecto1.modelo;

public class Vehiculo
{
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String tipoTransmision;
	private String categoria;
	private Sede ubicacion;
	private String estado;
	private TarifaVehiculo tarifa;
	private String fechaDisponibilidad;
	
	public Vehiculo(String placa,String marca,String modelo,String color,String tipoTransmision,
			String categoria,Sede ubicacion,String estado,TarifaVehiculo tarifa,
			String fechaDisponibilidad)
	{
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		this.categoria = categoria;
		this.ubicacion = ubicacion;
		this.estado = estado;
		this.tarifa = tarifa;
		this.fechaDisponibilidad = fechaDisponibilidad;
	}
}