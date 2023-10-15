package uniandes.dpoo.proyecto1.procesamiento;

import java.io.BufferedReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import uniandes.dpoo.proyecto1.modelo.*;

public class LoaderSeguros
{
	public static ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
	
	public static ArrayList<Seguro> cargarSeguros(String archivoSeguros) throws IOException, ParseException
	{
		
		BufferedReader br = new BufferedReader(new FileReader(archivoSeguros));
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String precio = partes[1];
			Double precioreal = Double.parseDouble(precio);
			Seguro nueva = new Seguro(nombre, precioreal);
			listaSeguros.add(nueva);
			linea = br.readLine();
		 }
		 br.close();
		 
		 return listaSeguros;
	}
	
	
	
}