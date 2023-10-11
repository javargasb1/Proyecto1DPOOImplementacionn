package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class TarifaVehiculo
{
	private String categoria;
	private String rangoFechas;
	private String temporada;
	private Sede sedeEntrega;
	private float precio;
	private ArrayList<Float> costoSeguros;
	private ArrayList<LicenciaConduccion> conductoresAdicionales;
	
	public TarifaVehiculo(String categoria,String rangoFechas,String temporada,
			Sede sedeEntrega,float precio,ArrayList<Float> costoSeguros,
			ArrayList<LicenciaConduccion> conductoresAdicionales)
	{
		this.categoria = categoria;
		this.rangoFechas = rangoFechas;
		this.temporada = temporada;
		this.sedeEntrega = sedeEntrega;
		this.precio = precio;
		this.costoSeguros = costoSeguros;
		this.conductoresAdicionales = conductoresAdicionales;
		
	}
}