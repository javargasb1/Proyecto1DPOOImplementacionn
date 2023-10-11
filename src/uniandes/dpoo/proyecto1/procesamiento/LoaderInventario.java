package uniandes.dpoo.proyecto1.procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;

import uniandes.dpoo.proyecto1.modelo.Inventario;
import uniandes.dpoo.proyecto1.modelo.Sede;
import uniandes.dpoo.proyecto1.modelo.TarifaVehiculo;

public class LoaderInventario
{
	public Inventario cargarInventario(String archivoInventario)
	{
		BufferedReader br = new BufferedReader(new FileReader(archivoInventario));
		String linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(";");
			String placa = partes[0];
			String marca = partes[1];
			String modelo = partes[2];
			String color = partes[0];
			String tipoTransmision = partes[3];
			String categoria = partes[4];
			Sede ubicacion = partes[5];
			String estado = partes[6];
			TarifaVehiculo tarifa = partes[7];
			String fechaDisponibilidad = partes[8];
			
			
			linea = br.readLine();
		 }
		 br.close();
	}
	
}