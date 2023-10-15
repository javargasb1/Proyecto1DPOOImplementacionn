package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import uniandes.dpoo.proyecto1.consola.ConsolaPrincipal;

public class ControladorCliente
{
	private static String categoria;
	private static String sede;
	private static LocalDate fechaRecogida;
	private static LocalTime horaRecogida;
	private static boolean especial;

	private static LocalDate fechaDevuelta;
	private static ArrayList<LocalTime> rangoDeHoras;
	private static String temporada;
	private static String sedeEntrega;
	private static Double precio;
	private static ArrayList<Double> costoSeguros;
	private static Double costoConductorAdicional;
	private static ArrayList<LicenciaConduccion> conductoresAdicionales;
	private static Reserva reserva;
	
	public static void mostrarConsolaCliente(Cliente elCliente)
	{
		boolean continuar = true;
		while (continuar)
		{
		mostrarMenu();
		int opcion = Integer.parseInt(input("Por favor seleccione una opción:"));
		 if (opcion ==1 ) 
		 	{
			 reserva = comenzarReserva(elCliente,ConsolaPrincipal.listaSedes,ConsolaPrincipal.listaVehiculos);
		 }
		 if(opcion ==2) 
		 {
			 if (reserva != null)
			 {
			 recogerVehiculo(reserva);
			 }
			 else;
			 {
				 System.out.println("No haz creado tu reserva. Elige la opcion 1 para crearla");
			 }
			 
		 }
		 if(opcion == 4)
		 {
			 continuar = false;
		 }
		}
		
	}
	
	public static void mostrarMenu()
	{
		System.out.println("\n Bienvenido Cliente ");
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Reservar vehiculo");
		System.out.println("2. Recoger vehiculo");
		System.out.println("3. Devolver vehiculo");
		System.out.println("4. Salir");
	}
	public static Reserva comenzarReserva(Cliente elCliente,ArrayList<Sede> listaSedes,ArrayList<Vehiculo>  listaVehiculos)
	{

		System.out.println("\n----------- COMENCEMOS CON TU RESERVA----------- \n");
		categoria = input ("\nElija la categoria de vehiculo desea reservar (Pequeno, SUV, Lujo o VAN): \n");
		System.out.println("\nEstas son las sedes donde puede recoger su vehiculo: \n");
		boolean encontrado1 = false;
		int j = 0;
		while(encontrado1 == false && j<listaSedes.size())
		{	
			Sede sedeReal = listaSedes.get(j);
			String sedes = sedeReal.getnombre();
			System.out.println(sedes);
					j +=1;
		}
					
		sede = input("\nElija la sedes donde quiera recoger su vehiculo: \n");
		boolean encontrado = false;
		int i = 0;
		ArrayList<LocalTime> horario;
		Sede sedeRecoger = null;
		while(encontrado == false && i<listaSedes.size())
		{
			sedeRecoger = listaSedes.get(i);
			if (sedeRecoger.getnombre().equals(sede))
			{
				encontrado = true;
				horario = sedeRecoger.gethorario();
				System.out.println("El horario de atencion de esta sede es:"+ horario.get(0)+"AM -"+horario.get(1)+" PM");
			}
			i +=1;
				
		}
		String fechaRecogida1 = input("\nIndique la fecha en la que se espera llegar a la agencia en formato AA-MM-DD: \n");
		LocalDate fechaRecogida= LocalDate.parse(fechaRecogida1);	
		String horaRecogida1 = input("\nIndique la hora en la que se espera llegar a la agencia en formato HH:MM : \n");
		LocalTime horaRecogida= LocalTime.parse(horaRecogida1);
		String respuesta = input("\nDesea ver los seguros adicionales? (SI/NO): \n");
		if (respuesta.equals("SI"))
		{
			especial = true;
			//MOSTRAR SEGUROS
			String respuesta1 = input("\nDeseas anadir seguros adicionales? (SI/NO): \n");
			if (respuesta1.equals("SI"))
			{
				String seguro = input("\nQue seguro deseas adicionar: \n");
				//FALTAAAA llamar a seguro
			}
		}
		else
		{
			especial = false;
		}
		System.out.println("\nEstas son las sedes donde puede entregar su vehiculo: \n");
		boolean encontrado2 = false;
		int k = 0;
		while(encontrado2 == false && k<listaSedes.size())
		{
			Sede sedeReal = listaSedes.get(k);
			String sedes = sedeReal.getnombre();
			System.out.println(sedes);
			k +=1;
		}
		String sedeEntrega1 = input("\nElija la sedes donde quiera entregar su vehiculo: \n");
		boolean encontrado3 = false;
		int l = 0;
		Sede sedeEntrega = null;
		ArrayList<LocalTime> horario1;
		while(encontrado3 == false && l<listaSedes.size())
		{
			sedeEntrega = listaSedes.get(l);
			if (sedeEntrega.getnombre().equals(sedeEntrega1))
			{
				encontrado3 = true;
				horario1 = sedeEntrega.gethorario();
				System.out.println("El horario de atencion de esta sede es:"+ horario1.get(0)+"AM -"+horario1.get(1)+" PM");
			}
			l +=1;
					
		}
		
		String fechaDevuelta1 = input("\nIndique la fecha en el que se devolvera el vehiculo en el formato AA-MM-DD: \n");
		LocalDate fechaDevuelta= LocalDate.parse(fechaDevuelta1);	
		String horainf1 = input("\nEs necesario saber el rango de horas en las que va a devolver el vehiculo, ingrese la hora inferior en formato HH:MM : \n");
		LocalTime horaInf= LocalTime.parse(horainf1);
		String horasup1 = input("\nAhora ingrese la hora superior en formato HH:MM : \n");
		LocalTime horaSup= LocalTime.parse(horasup1);
		rangoDeHoras = new ArrayList<LocalTime>() ;
		rangoDeHoras.add(horaInf);
		rangoDeHoras.add(horaSup);
		
		reserva = elCliente.crearReserva(elCliente,categoria,sedeRecoger,fechaRecogida,horaRecogida,especial,listaVehiculos,fechaDevuelta,rangoDeHoras,temporada,sedeEntrega,precio,costoSeguros,costoConductorAdicional, conductoresAdicionales);
		String temporada = reserva.actualizarTemporada(fechaRecogida);
		return reserva;
	}

	public static void recogerVehiculo(Reserva reserva)
	{
		//cuando el vehículo se recoge se debe pagar por el servicio completo. Además, en el momento en el que se recoge un vehículo la agencia realiza un bloqueo sobre la tarjeta de crédito 
		//del cliente que es desactivado cuando se entrega de nuevo en una sede de la empresa
				
		LocalDate fecha = reserva.getfechaRecogida();
		LocalTime hora =reserva.gethoraRecogida();
		LocalDate ahorafecha = LocalDate.now();
		Sede sedeRecoger = reserva.getsede();

		boolean encontrado = false;
		int i = 0;
		ArrayList<LocalTime> horario;
		LocalTime horainf = null;
		LocalTime horasup = null;
		while(encontrado == false && i<ConsolaPrincipal.listaSedes.size())
		{
			sedeRecoger = ConsolaPrincipal.listaSedes.get(i);
			if (sedeRecoger.getnombre().equals(sede))
			{
				encontrado = true;
				horario = sedeRecoger.gethorario();
				horainf = horario.get(0);
				horasup = horario.get(1);
			}
			i +=1;
				
		}
		
		if (ahorafecha.equals(fecha) && hora.isAfter(horainf)&& hora.isBefore(horasup))
		{
		System.out.println("\n----------- ES HORA DE RECOGER TU VEHICULO ----------- \n");
		String conductor = input("\nHabrán otros conductores? (SI/NO): \n");
		if (conductor == "SI")
		{
			ConductorAdicional nuevoConductor = new ConductorAdicional();
			//FALTA
		}
				
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
	
}