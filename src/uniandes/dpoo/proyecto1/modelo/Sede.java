package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class Sede
{
	private String nombre;
	private String ubicacion;
	private String horario;
	private ArrayList<Empleado> empleados;
	
	public Sede(String nombre,String ubicacion,String horario,
			ArrayList<Empleado> empleados)
	{
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.horario = horario;
		this.empleados = empleados;
	}
}