package uniandes.dpoo.proyecto1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	private String precio;
	private Map<LocalDate, Boolean> disponibilidad = new HashMap<>();
	
	public Vehiculo(String placa,String marca,String modelo,String color,String tipoTransmision,
			String categoria,Sede ubicacion,String precio)
	{
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		this.categoria = categoria;
		this.ubicacion = ubicacion;
		this.estado = "Disponible";
		this.precio = precio;
		LocalDate date = LocalDate.now();
		for (int i = 0; i < 730; i++) {
			disponibilidad.put(date.plusDays(i), true);
		}
	}
	
	public String getPlaca() {

		return placa;
	}
	
	public String getMarca() {

		return marca;
	}
	
	public String getModelo() {

		return modelo;
	}
	
	public String getTipoTransmision() {

		return tipoTransmision;
	}
	
	public String getCategoria() {

		return categoria;
	}
	
	public Sede getUbi() {

		return ubicacion;
	}
	
	public String getEstado() {

		return estado;
	}
	public String getPrecio() {

		return precio;
	}
	
}