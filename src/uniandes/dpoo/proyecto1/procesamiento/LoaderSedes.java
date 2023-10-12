package uniandes.dpoo.proyecto1.procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import uniandes.dpoo.proyecto1.modelo.*;

public class LoaderSedes
{
	public static ArrayList<Sede> listaSedes = new ArrayList<Sede>();
	
	public static ArrayList<Sede> cargarSedes(String archivoSedes, ArrayList<Empleado> listaEmpleados) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(archivoSedes));
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(":");
			String nombre = partes[0];
			String ubicacion = partes[1];
			String[] rangoHoras = partes[2].split("-");
			ArrayList<Float> horario= new ArrayList<Float>();
			horario.add(Float.valueOf(rangoHoras[0]));
			horario.add(Float.valueOf(rangoHoras[1]));
			
			ArrayList<Empleado> empleadosSede= new ArrayList<Empleado>();
			for (Empleado empleado: listaEmpleados) {
				String ubicacionEmpleado = empleado.getUbi();
				if(ubicacionEmpleado.equals(ubicacion)) {
					empleadosSede.add(empleado);
				}
			}
			Sede nueva = new Sede(nombre, ubicacion, horario, empleadosSede);
			listaSedes.add(nueva);
			linea = br.readLine();
		 }
		 br.close();
		 
		 return listaSedes;
	}
	
	
	
}