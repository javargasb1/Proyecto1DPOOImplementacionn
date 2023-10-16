package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class Categoria
{
	private String categoria;
	private String rangoFechas;
	private String temporada;
	private Sede sedeEntrega;
	private float precio;
	private ArrayList<Seguro> costoSeguros;
	private Double costoConductoresAdicionales;
	
	public Categoria (String categoria,String rangoFechas,String temporada,
			Sede sedeEntrega,float precio,ArrayList<Seguro> costoSeguros,
			Double costoConductoresAdicionales)
	{
		this.categoria = categoria;
		this.rangoFechas = rangoFechas;
		this.temporada = temporada;
		this.sedeEntrega = sedeEntrega;
		this.precio = precio;
		this.costoSeguros = costoSeguros;
		this.costoConductoresAdicionales = costoConductoresAdicionales;
		
	}
	
	//reserva se cobra inmediatamente el 30% del valor proyectado del alquiler
	
	
}
