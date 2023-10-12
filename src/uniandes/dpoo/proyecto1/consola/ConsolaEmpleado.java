package uniandes.dpoo.proyecto1.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uniandes.dpoo.proyecto1.modelo.*;

public class ConsolaEmpleado
{
	public static void mostrarConsolaEmpleado(Empleado elEmpleado)
	{
		String trabajo = elEmpleado.getWork();
	
		if(trabajo.equals("AdministradorLocal")) {
		mostrarMenuAdmin();
		}
		if(trabajo.equals("ActualizadorEstadoVehiculo")) {
		mostrarMenuAct();
		}
	}
	
	public static void mostrarMenuAdmin()
	{

		System.out.println("\n Bienvenido Empleado ");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. ");
	}
	
	public static void mostrarMenuAct()
	{

		System.out.println("\n Bienvenido Empleado ");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. ");
	}
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje );
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

}