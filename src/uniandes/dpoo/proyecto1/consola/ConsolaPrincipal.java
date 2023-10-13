package uniandes.dpoo.proyecto1.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

import uniandes.dpoo.proyecto1.modelo.*;
import uniandes.dpoo.proyecto1.procesamiento.*;


public class ConsolaPrincipal {
	public Sistema sistema = new Sistema();
	public static HashMap<String,String> usuariosClientes;
	public static HashMap<String,String> usuariosEmpleados;
	public static ArrayList<Usuario> listaEmpleados;
	public static ArrayList<Cliente> listaClientes;
	public static ArrayList<Sede> listaSedes;
	public static ArrayList<Vehiculo> listaVehiculos;
	
	public static void main(String[] args) throws IOException, ParseException {
		ConsolaPrincipal consola = new ConsolaPrincipal();
		consola.cargarDatos();
		System.out.println(usuariosClientes);
		consola.ejecutarConsolaAdministrador();
		
	}
	
	public void cargarDatos() throws IOException, ParseException {
		String archivoClientes = "data/archivoClientes.txt";
		String archivoEmpleados = "data/archivoEmpleados.txt";
		String archivoSedes = "data/archivoSedes.txt";
		String archivoVehiculos = "data/archivoInventario.txt";
		usuariosClientes = LoaderUsuarios.getUsuariosClientes(archivoClientes);
		usuariosEmpleados = LoaderUsuarios.getUsuariosEmpleados(archivoEmpleados);
		listaEmpleados = LoaderUsuarios.getListaEmpleados();
		listaClientes = LoaderUsuarios.getListaClientes();
		listaSedes = LoaderSedes.cargarSedes(archivoSedes,listaEmpleados);
		listaVehiculos = LoaderInventario.cargarInventario(archivoVehiculos,listaSedes);
	}
	
	public void ejecutarConsolaAdministrador() throws IOException {
		boolean continuar= true;
		 System.out.println("Bienvenido al Alquiler de Carros !\n");
		 while (continuar) {
			 mostrarMenuInicial();
			 int opcion = Integer.parseInt(input("Por favor seleccione una opción:"));
			 if (opcion ==1 ) {
				 crearCuenta();
			 }
			 else if (opcion ==2) {
				 iniciarSesion();
			 }
			 else if (opcion ==3 ) {
				 continuar=false;
			 }
		 }
	}

	public void mostrarMenuInicial() {
		System.out.println("Porfavor Seleccione: \n1. Crear Cuenta");
		System.out.println("2. Iniciar Sesion");
		System.out.println("3. Cerrar Aplicacion"); 
	}
	public void crearCuenta() {

		System.out.println("Porfavor Seleccione: ");
		System.out.println("1. Cliente \n2. Empleado");
		int opcion = Integer.parseInt(input(""));
		System.out.println("Vamos a crear tu cuenta! Porfavor Ingrese los siguientes datos: ");
		if (opcion ==1 ) {
			String nombre = input ("\nIngrese su nombre: \n");
			String contacto1 = input ("\nIngrese su cecular de contacto: \n");
			String contacto2 = input ("\nIngrese su email de contacto: \n");
			ArrayList<String> contacto = new ArrayList<String>();
			contacto.add(contacto1);
			contacto.add(contacto2);
			String nacimiento1 = input ("\nIngrese su fecha de nacimiento con el formato AA-MM-DD: \n");
			LocalDate nacimiento= LocalDate.parse(nacimiento1);
			String nacionalidad = input ("\nIngrese su nacionalidad: \n");
			String documento = input ("\nIngrese su numero de documento: \n");
			System.out.println("Porfavor Ingrese los datos de su licencia de conduccion: ");
			String licencia1 = input ("\nIngrese su numero de licencia: \n");
			String licencia2 = input ("\nIngrese el pais de expedicion: \n");
			String licencia3 = input ("\nIngrese la fecha de vencimiento con el formato AA-MM-DD: \n");
			LicenciaConduccion licencia = new LicenciaConduccion(licencia1, licencia2, licencia3);
			System.out.println("Porfavor Ingrese los datos de pago: ");
			String pago1 = input ("\nIngrese su numero de su tarjeta de credito: \n");
			String pago2 = input ("\nIngrese la fecha de vencimiento de su tarjeta con el formato AA-MM-DD: \n");
			ArrayList<String> pago = new ArrayList<String>();
			pago.add(pago1);
			pago.add(pago2);
			String login = input ("Cree su login: \n");
			String clave = input ("Cree su clave: \n");
			usuariosClientes.put(login, clave);
			Cliente nuevo = new Cliente(nombre, login, clave, contacto, nacimiento, nacionalidad, documento, licencia, pago);
			listaClientes.add(nuevo);
			System.out.println("Cuenta creada! Porfavor inicia sesion");
		}
		else if (opcion ==2 ) {
			System.out.println("Porfavor Seleccione: ");
			System.out.println("1. Administrador local \n2. Actualizador del estado de vehiculos");
			int opcion1 = Integer.parseInt(input(""));
			String nombre = input ("\nIngrese su nombre: \n");
			String ubicacion = input ("\nIngrese su ubicacion actual en donde opera (Usaquen, Chapinero...): \n");
			String login = input ("Cree su login: \n");
			String clave = input ("Cree su clave: \n");
			usuariosEmpleados.put(login, clave);
			if(opcion1==1) {
				AdministradorLocal nuevo = new AdministradorLocal(login, clave,nombre, ubicacion);
				listaEmpleados.add(nuevo);
			}
			if(opcion1==2) {
				ActualizadorEstadoVehiculo nuevo = new ActualizadorEstadoVehiculo(login, clave,nombre, ubicacion);
				listaEmpleados.add(nuevo);
			}
			System.out.println("Cuenta creada! Porfavor inicia sesion");

		}
		else {
			System.out.println("Opcion no valida ");
		}
		
		
		
	}
	public void iniciarSesion() throws IOException {
		System.out.println("Porfavor Seleccione:\n ");
		System.out.println("1. Cliente \n2. Empleado \n");
		int opcion = Integer.parseInt(input(""));
		String login = input("Ingrese su login:  ");
		String clave = String.valueOf(input("Ingrese su clave:  "));
		if(opcion==1) {
				Cliente usuario= AutentificadorCliente(login,clave);
				if (usuario!=null) {
					System.out.println("Estas registrado como cliente");
					ControladorCliente.mostrarConsolaCliente(usuario);
				}
				else {
					System.out.println("Ingresaste la clave incorrecta o si no estas registrado, crea una cuenta!");
				}
				}
			
		else if (opcion==2) {
				Usuario usuario = AutentificadorEmpleado(login,clave);
				if (usuario!=null) {
					System.out.println("Estas registrado como empleado");
					ControladorEmpleado.mostrarConsolaEmpleado(usuario);
				}
				else {
				System.out.println("Ingresaste la clave incorrecta o si no estas registrado, crea una cuenta!");
				}
				}

	}
	
	
	public Cliente AutentificadorCliente(String login, String clave) throws IOException
	{
		Cliente usuario= null;
			boolean encontrado = false;
			int i=0;
			while(encontrado==false && i < listaClientes.size()){
				Cliente elCliente = listaClientes.get(i);
				String login1 = elCliente.getLogin();
				if(login.equals(login1)) {
					if (clave.equals(usuariosClientes.get(login)))
					{
						usuario= elCliente;
						encontrado= true;
					}
				}
				i=i+1;
				
			}
		return usuario;

	}
	
	public Usuario AutentificadorEmpleado(String login, String clave) throws IOException
	{
		Usuario usuario= null;
		boolean encontrado = false;
		int i=0;
		while(encontrado==false && i < listaEmpleados.size()){
			Usuario elEmpleado = listaEmpleados.get(i);
			String login1 = elEmpleado.getLogin();
			if(login.equals(login1)) {
				if (clave.equals(usuariosEmpleados.get(login)))
				{
					usuario= elEmpleado;
					encontrado= true;
				}
			}
			i=i+1;
				
			}
		return usuario;

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