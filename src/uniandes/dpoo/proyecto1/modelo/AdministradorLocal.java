package uniandes.dpoo.proyecto1.modelo;

import uniandes.dpoo.proyecto1.consola.ConsolaPrincipal;

public class AdministradorLocal implements Usuario{

	private String nombre;
	private String login;
	private String clave;
	private String ubicacion;

	
	public AdministradorLocal(String login, String clave, String nombre, String ubicacion)
	{
		this.login = login;
		this.clave = clave;
		this.nombre = nombre;
		this.ubicacion= ubicacion;

	}


	public String getNombre() {
		return nombre;
	}	
	
	public String getClave() {
		return clave;
	}	
	
	public String getLogin() {
		return login;
	}	
	
	public String getUbi() {
		return ubicacion;
	}	
	
	public String getWork() {
		return "AdministradorLocal";
	}

	public static void nuevoVehiculo(String placa,String marca,String modelo,String color,String tipoTransmision, String categoria,Sede ubicacion,String precio)
	{
		Vehiculo nuevoVehiculo = new Vehiculo(placa,marca,modelo, color, tipoTransmision, categoria, ubicacion, precio);
		ConsolaPrincipal.listaVehiculos.add(nuevoVehiculo);
	}
	
	public static void darBajaVehiculo(String vehiculobaja)
	{
		int z =0;
		boolean enlista = false;
		while (z <ConsolaPrincipal.listaVehiculos.size())
		{
			Vehiculo vehiculo = ConsolaPrincipal.listaVehiculos.get(z);
			if (vehiculo.getPlaca().equals(vehiculobaja))
			{
				enlista = true;
				
			}
			z +=1;
			
		}

		if (enlista == false)
		{
			System.out.println("\nEl vehiculo ingresado no se encuentra en el inventario ");
		}
		
		else
		{
			boolean encontrado = false;
			int i = 0;
			Vehiculo vehiculoBaja = null;
			while(encontrado == false && i<ConsolaPrincipal.listaVehiculos.size())
			{
				vehiculoBaja = ConsolaPrincipal.listaVehiculos.get(i);
				if (vehiculoBaja.getPlaca().equals(vehiculobaja))
				{
					encontrado = true;
				
				i +=1;
					
				}
			}
			ConsolaPrincipal.listaVehiculos.remove(vehiculoBaja);
		}
	}
}