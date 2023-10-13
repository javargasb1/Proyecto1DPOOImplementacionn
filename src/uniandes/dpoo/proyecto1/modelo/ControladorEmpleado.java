package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;

import uniandes.dpoo.proyecto1.consola.ConsolaPrincipal;

public class ControladorEmpleado
{
	private static String placa;
	private static String marca;
	private static String modelo;
	private static String color;
	private static String tipoTransmision;
	private static String categoria;
	private static Sede ubicacion;
	private static String estado;
	private static String precio;
	
	public static void mostrarConsolaEmpleado(Usuario elEmpleado)
	{
		String trabajo = elEmpleado.getWork();
	
		if(trabajo.equals("AdministradorLocal")) 
		{
		mostrarMenuAdmin();
		}
		if(trabajo.equals("ActualizadorEstadoVehiculo")) 
		{
		mostrarMenuAct();
		}
	}
	
	public static void mostrarMenuAdmin()
	{
		boolean seguir = true;
		while (seguir)
		{
		System.out.println("\n Bienvenido Empleado ");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Registrar la compra de nuevos vehículos");
		System.out.println("2. Dar de baja a un vehiculo");
		System.out.println("3. Salir");
		int opcion1 = Integer.parseInt(input("Por favor seleccione una opción:"));
		 if (opcion1 ==1 ) 
		 {
			 registrarCompra();
		 }
		 if (opcion1 ==2)
		 {
			 darBaja();
		 }
		 if (opcion1 ==3)
		 {
			 seguir = false; 
		 }
		}
	}
	
	
	public static void mostrarMenuAct()
	{
		boolean continuar = true;
		while (continuar)
		{
		System.out.println("\n Bienvenido Empleado ");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Actualizar estado de vehiculo");
		
		}
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
	
	public static void registrarCompra() 
	{
		System.out.println("\n----------- COMENCEMOS A REGISTAR LA COMPRA ----------- ");
		placa = input("\nIngresa la placa del nuevo vehiculo:");
		marca = input("\nIngresa la marca del nuevo vehiculo:");
		modelo = input("\nIngresa el modelo del nuevo vehiculo:");
		color =  input("\nIngresa el color del nuevo vehiculo:");
		tipoTransmision = input("\nIngresa el tipo de transmicion del nuevo vehiculo (Hidraulico, Mecanico, Electrico):");
		categoria = input("\nIngresa la categoria a la que pertenece del nuevo vehiculo (Pequeno,Lujo,SUV,VAN):");
		String ubicacion1 =  input("\nIngresa la ubicacion del nuevo vehiculo:");
		boolean encontrado2 = false;
		int q = 0;
		Sede ubicacion = null;
		while(encontrado2 == false && q<ConsolaPrincipal.listaSedes.size())
		{
			ubicacion = ConsolaPrincipal.listaSedes.get(q);
			if (ubicacion.getnombre().equals(ubicacion1))
			{
				encontrado2 = true;
			}
			q +=1;
		}
		estado =  "Disponible";
		precio =  input("\nIngresa el precio de alquiler del nuevo vehiculo:");
		AdministradorLocal.nuevoVehiculo(placa,marca,modelo, color, tipoTransmision, categoria, ubicacion, precio);
		System.out.println("\nEL VEHICULO HA SIDO REGISTRADO EXITOSAMENTE ");
	
	}
	
	public static void darBaja()
	{
		System.out.println("\n----------- VAMOS A DAR DE BAJA A UN VEHICULO ----------- ");
		String vehiculobaja = input("\nIngresa la placa del vehiculo que vamos a dar de baja:");
		AdministradorLocal.darBajaVehiculo(vehiculobaja);
		System.out.println("\nEL VEHICULO HA SIDO DADO DE BAJA EXITOSAMENTE ");
		
	}

}