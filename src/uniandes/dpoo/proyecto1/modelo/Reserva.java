package uniandes.dpoo.proyecto1.modelo;

public class Reserva
{
	private String categoria;
	private Sede sede;
	private String fechaRecogida;
	private boolean especial;
	
	public Reserva(String categoria,Sede sede,String fechaRecogida,boolean especial)
	{
		this.categoria = categoria;
		this.sede = sede;
		this.fechaRecogida = fechaRecogida;
		this.especial = especial;
	}
}