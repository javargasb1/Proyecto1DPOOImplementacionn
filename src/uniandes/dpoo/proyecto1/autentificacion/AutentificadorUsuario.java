package uniandes.dpoo.proyecto1.autentificacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AutentificadorUsuario
{
	
	public AutentificadorUsuario(String login, String contraseña) throws IOException
	{
		String archivoClientes = "";
		String archivoEmpleados = "";
		
		HashMap<String,String> usuariosClientes = LoaderUsuarios.getUsuariosClientes(archivoClientes);
		HashMap<String,String> usuariosEmpleados = LoaderUsuarios.getUsuariosEmpleados(archivoEmpleados);
		ArrayList<String> listaUsuarios = LoaderUsuarios.getListaUsuarios();
		
		if (listaUsuarios.contains(login))
		{
			if (usuariosClientes.containsKey(login))
			{
				if (usuariosClientes.get(login) == contraseña)
				{
					
				}
				else
				{
					
				}
			}
			else if (usuariosEmpleados.containsKey(login))
			{
				
			}
		}
		
		else
		{
			
		}
	}
	
	
}