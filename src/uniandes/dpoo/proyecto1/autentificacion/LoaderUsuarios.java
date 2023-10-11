package uniandes.dpoo.proyecto1.autentificacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoaderUsuarios
{
	private static HashMap<String,String> usuariosClientes;
	private static HashMap<String,String> usuariosEmpleados;
	private static ArrayList<String> listaUsuarios;
	
	
	private static HashMap<String,String> cargarClientes(String archivoClientes) throws IOException
	{
		 usuariosClientes = new HashMap<String,String>();
		 
		 BufferedReader br = new BufferedReader(new FileReader(archivoClientes));
		 String linea = br.readLine();
		 linea = br.readLine();
		 while (linea != null)
		 {
			 String[] partes = linea.split(":");
			 String usuarioCliente = partes[0];
			 String contraseñaCliente = partes[1];
			 
			 usuariosClientes.put(usuarioCliente, contraseñaCliente);
			 listaUsuarios.add(usuarioCliente);
			 linea = br.readLine();
		 }
		 br.close();
		 return usuariosClientes;
	}
	
	private static HashMap<String,String> cargarEmpleados(String archivoEmpleados) throws IOException
	{
		usuariosEmpleados = new HashMap<String,String>();
		
		BufferedReader br = new BufferedReader(new FileReader(archivoEmpleados));
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null)
		{
			String[] partes = linea.split(":");
			String usuarioEmpleado = partes[0];
			String contraseñaEmpleado = partes[1];
			
			usuariosClientes.put(usuarioEmpleado, contraseñaEmpleado);
			listaUsuarios.add(usuarioEmpleado);
			linea = br.readLine();
		}
		br.close();
		
		return usuariosEmpleados;
	}
	
	public static HashMap<String,String> getUsuariosClientes(String archivoClientes) throws IOException
	{
		cargarClientes(archivoClientes);
		return usuariosClientes;
	}
	
	public static HashMap<String,String> getUsuariosEmpleados(String archivoEmpleados) throws IOException
	{
		cargarEmpleados(archivoEmpleados);
		return usuariosEmpleados;
	}
	
	public static ArrayList<String> getListaUsuarios()
	{
		return listaUsuarios;
	}
}