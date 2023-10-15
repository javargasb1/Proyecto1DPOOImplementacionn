package uniandes.dpoo.proyecto1.modelo;

import java.time.LocalDate;
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
	private Double precio;
	private static Map<LocalDate, Boolean> disponibilidad = new HashMap<>();
	
	public Vehiculo(String placa,String marca,String modelo,String color,String tipoTransmision,
			String categoria,Sede ubicacion,Double precio)
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
	public Double getPrecio() {

		return precio;
	}
	
	public void actualizarEstado(String nuevoEstado)
	{
		estado = nuevoEstado;
	}
	
	public static void bloquearDisponibilidad(LocalDate fechaRecogida, LocalDate fechaDevuelta)
	{
		for (LocalDate date = fechaRecogida; date.isBefore(fechaDevuelta); date = date.plusDays(1)) 
		{
            disponibilidad.put(date, false);
        }
	}
	
	public void desbloquearDisponibilidad(LocalDate fechaRecogida, LocalDate fechaDevuelta)
	{
		for (LocalDate date = fechaRecogida; date.isBefore(fechaDevuelta); date = date.plusDays(1)) 
		{
            disponibilidad.put(date, true);
        }
		
	}
	
	public boolean verificarDisponibilidad(LocalDate fechaRecogida, LocalDate fechaDevuelta)
	{
		for (LocalDate date = fechaRecogida; date.isBefore(fechaDevuelta); date = date.plusDays(1)) 
		{
            if (!disponibilidad.get(date)) 
            {
                return false;
            }
        }
        return true;
		
	}

	public String getColor() {
		return color;
	}
	
}