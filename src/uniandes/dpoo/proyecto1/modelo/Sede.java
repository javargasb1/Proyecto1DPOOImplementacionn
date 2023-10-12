package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;

public class Sede
{
	private String nombre;
	private String ubicacion;
	private ArrayList<Float> horario;
	private ArrayList<Empleado> empleados;
	
	public Sede(String nombre,String ubicacion, ArrayList<Float> horario,
			ArrayList<Empleado> empleados)
	{
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.horario = horario;
		this.empleados = empleados;
	}
	
	public String getnombre() {

		return nombre;
	}
	
	public String getUbi() {

		return ubicacion;
	}
	
	public ArrayList<Float> gethorario() {

		return horario;
	}
	public ArrayList<Empleado> getEmpleados() {

		return empleados;
	}
}
