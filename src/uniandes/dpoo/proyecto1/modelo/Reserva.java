package uniandes.dpoo.proyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class Reserva
{
	private String categoria;
	private Sede sede;
	private LocalDate fechaRecogida;
	private LocalTime horaRecogida;
	private boolean especial;
	private ArrayList<Vehiculo>  listaVehiculos;
	private ArrayList<LocalTime>  rangoDeHoras;
	private LocalDate fechaDevuelta;
	private String temporada;
	private Sede sedeEntrega;
	private Double precio;
	private ArrayList<Double> costoSeguros;
	private Double costoConductorAdicional;
	private ArrayList<LicenciaConduccion> conductoresAdicionales;
	private Cliente elCliente;
	
	
	public Reserva(Cliente elCliente,String categoria,Sede sede,LocalDate fechaRecogida,LocalTime horaRecogida,boolean especial,ArrayList<Vehiculo>  listaVehiculos,LocalDate fechaDevuelta, ArrayList<LocalTime>  rangoDeHoras,String temporada,Sede sedeEntrega,Double precio,ArrayList<Double> costoSeguros,Double costoConductorAdicional, ArrayList<LicenciaConduccion> conductoresAdicionales)
	{
		this.elCliente = elCliente;
		this.categoria = categoria;
		this.sede = sede;
		this.fechaRecogida = fechaRecogida;
		this.horaRecogida = horaRecogida;
		this.especial = especial;
		this.listaVehiculos = listaVehiculos;
		this.rangoDeHoras = rangoDeHoras;
		this.fechaDevuelta = fechaDevuelta;
		this.temporada = temporada;
		this.sedeEntrega = sedeEntrega;
		this.precio = precio;
		this.costoSeguros = costoSeguros;
		this.costoConductorAdicional = costoConductorAdicional;
		this.conductoresAdicionales = conductoresAdicionales;
		
	}

	public  Cliente getcliente()
	{
		return elCliente;
	}
	
	public String getcategoria()
	{
		return categoria;
	}
	
	public Sede getsede()
	{
		return sede;
	}
	
	public LocalDate getfechaRecogida()
	{
		return fechaRecogida;
	}
	
	public LocalTime gethoraRecogida()
	{
		return horaRecogida;
	}
	
	public ArrayList<LocalTime> getrangoHoras()
	{
		return rangoDeHoras;
	}
	
	public LocalDate getfechaDevuelta()
	{
		return fechaDevuelta;
	}
	
	public String actualizarTemporada(LocalDate fechaRecogida, String temporada) {
		
		Month mes = fechaRecogida.getMonth();
		//Se encuentra si el mes para hacer la reserva es junio, julio, diciembre o enero para saber si es temporada alta
		if (mes.equals("JANUARY") 
		{
			
		}
		
		return temporada;
		
	}
	
}