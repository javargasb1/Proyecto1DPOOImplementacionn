package uniandes.dpoo.proyecto1.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
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
	private static ArrayList<Seguro> costoSeguros;
	private static Double costoConductorAdicional;
	private static ArrayList<ConductorAdicional> conductoresAdicionales;
	public static Reserva reserva;
	
	public static void mostrarConsolaCliente(Cliente elCliente) throws IOException
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
			 else if(reserva==null) {
				 
			 }
			 else
			 {
				 System.out.println("No haz creado tu reserva. Elige la opcion 1 para crearla");
			 }
			 
		 }
		 if(opcion ==3) 
		 {
			 if (reserva != null)
			 {
				 devolverVehiculo(reserva);
			 }
			 else
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
	public static Reserva comenzarReserva(Cliente elCliente,ArrayList<Sede> listaSedes,ArrayList<Vehiculo>  listaVehiculos) throws IOException
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
					
		sede = input("\nElija la sede donde quiera recoger su vehiculo: \n");
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
				String fechaRecogida1 = input("\nIndique la fecha en la que se espera llegar a la agencia en formato AA-MM-DD: \n");
				fechaRecogida= LocalDate.parse(fechaRecogida1);	
				boolean enRango = false;
				while(enRango==false) {
					String horaRecogida1 = input("\nIndique la hora en la que se espera llegar a la agencia en formato HH:MM : \n");
					horaRecogida= LocalTime.parse(horaRecogida1);
					if(horaRecogida.isAfter(horario.get(0)) && horaRecogida.isBefore(horario.get(1))) {
						enRango = true;
					}
					else {
						System.out.println("La hora escogida no esta dentro del horario de atencion de la sede");
					}
					
				}
			}
			i +=1;
				
		}

		String respuesta = input("\nDesea ver los seguros adicionales? (SI/NO): \n");
		if (respuesta.equals("SI"))
		{
			especial = true;
			boolean enc = false;
			int a = 0;
			while(enc == false && a<listaSedes.size())
			{	
				Seguro seguro = ConsolaPrincipal.listaSeguros.get(a);
				System.out.println((a+1)+")"+seguro.getNombre()+":$"+seguro.getPrecio());
						a +=1;
			}
			

			String respuesta1 = input("\nDeseas anadir seguros adicionales? (SI/NO): \n");
			if (respuesta1.equals("SI"))
			{
				String seguros= "SI";
				int k=0;
				costoSeguros = new ArrayList<Seguro>() ;
				while(seguros.equals("SI") && k<ConsolaPrincipal.listaSeguros.size()) {
					String seguro = input("\nQue seguro deseas adicionar(1,2,3): \n");
					int num  =Integer.parseInt(seguro);
					Seguro sele = ConsolaPrincipal.listaSeguros.get(num-1);	
					costoSeguros.add(sele);
					seguros = input("\nDeseas anadir otro seguro? (SI/NO): \n");
					k+=1;
				}
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
		String sedeEntrega1 = input("\nElija la sede donde quiera entregar su vehiculo: \n");
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
				String fechaDevuelta1 = input("\nIndique la fecha en el que se devolvera el vehiculo en el formato AA-MM-DD: \n");
				fechaDevuelta= LocalDate.parse(fechaDevuelta1);	
				boolean enRango = false;
				while(enRango==false) {
					String horainf1 = input("\nEs necesario saber el rango de horas en las que va a devolver el vehiculo, ingrese la hora inferior en formato HH:MM : \n");
					LocalTime horaInf= LocalTime.parse(horainf1);
					String horasup1 = input("\nAhora ingrese la hora superior en formato HH:MM : \n");
					LocalTime horaSup= LocalTime.parse(horasup1);
					if(horaInf.isAfter(horario1.get(0)) && horaSup.isBefore(horario1.get(1))) {
						rangoDeHoras = new ArrayList<LocalTime>() ;
						rangoDeHoras.add(horaInf);
						rangoDeHoras.add(horaSup);
						enRango = true;
					}
					else {
						System.out.println("El rango escogido no esta dentro del horario de atencion de la sede");
					}
					
				}
			}
			l +=1;
					
		}
		costoConductorAdicional =0.0;
		conductoresAdicionales= new ArrayList<ConductorAdicional>();
		reserva = elCliente.crearReserva(elCliente,categoria,sedeRecoger,fechaRecogida,horaRecogida,especial,listaVehiculos,fechaDevuelta,rangoDeHoras,temporada,sedeEntrega,precio,costoSeguros,costoConductorAdicional, conductoresAdicionales);
		if(reserva != null) {
			System.out.println("Su reserva a sido creada con exito, cuando sea la hora adecuada, recoja su vehiculo.");
			reserva.actualizarTemporada(fechaRecogida);
			reserva.actualizarPrecio();
			ConsolaPrincipal.listaReservas.add(reserva);
			reEscribirReservas();
		}
		else {
			System.out.println("No hay vehiculos disponibles con esa categoria, en esas fechas y en esa sede, vuelva a hacer una nueva reserva.");
		}
		return reserva;
	}

	public static void recogerVehiculo(Reserva reserva) throws IOException
	{
		//cuando el vehículo se recoge se debe pagar por el servicio completo. Además, en el momento en el que se recoge un vehículo la agencia realiza un bloqueo sobre la tarjeta de crédito 
		//del cliente que es desactivado cuando se entrega de nuevo en una sede de la empresa
				
		LocalDate fecha = reserva.getfechaRecogida();
		LocalTime hora = LocalTime.now();
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
		boolean salir = true;
		
		while(salir ==true)
		{
		String conductor = input("\nHabrán otros conductores? (SI/NO): \n");
		while (conductor.equals("SI"))
		{
			String nombre = input ("\nIngrese su nombre: \n");
			String contacto1 = input ("\nIngrese su celular de contacto: \n");
			String contacto2 = input ("\nIngrese su email de contacto: \n");
			ArrayList<String> contacto = new ArrayList<String>();
			contacto.add(contacto1);
			contacto.add(contacto2);
			String nacimiento1 = input ("\nIngrese su fecha de nacimiento con el formato AA-MM-DD: \n");
			LocalDate nacimiento= LocalDate.parse(nacimiento1);
			String nacionalidad = input ("\nIngrese su nacionalidad: \n");
			String documento = input ("\nIngrese su numero de documento: \n");
			System.out.println("Porfavor Ingrese los datos de la licencia de conduccion del conductor: ");
			String licencia1 = input ("\nIngrese su numero de licencia: \n");
			String licencia2 = input ("\nIngrese el pais de expedicion: \n");
			String licencia3 = input ("\nIngrese la fecha de vencimiento con el formato AA-MM-DD: \n");
			LicenciaConduccion licencia = new LicenciaConduccion(licencia1, licencia2, licencia3);
			ConductorAdicional nuevoConductor = new ConductorAdicional(nombre,contacto,nacimiento,nacionalidad,documento,licencia);
			costoConductorAdicional+=60000;
			conductoresAdicionales= new ArrayList<ConductorAdicional>();
			conductoresAdicionales.add(nuevoConductor);
			reserva.actualizarConductores(costoConductorAdicional,conductoresAdicionales);
			conductor = input("\nDesea adicionar otro conductor? (SI/NO): \n");
		}
		if (conductor.equals("NO"))
		{
			salir = false;
		}
		}
		reEscribirReservas();
		System.out.println("\n----------- ESTE ES TU VEHICULO: ENTREGA ----------- \n");
		System.out.println("Categoria: "+reserva.getVehiculo().getCategoria()+"\n");
		System.out.println("Placa: "+reserva.getVehiculo().getPlaca()+"\n");
		System.out.println("Color: "+reserva.getVehiculo().getColor()+"\n");
		System.out.println("Modelo: "+reserva.getVehiculo().getModelo()+"\n");
		System.out.println("Tipo de Transmision: "+reserva.getVehiculo().getTipoTransmision()+"\n");
		System.out.println("Ubicacion: "+reserva.getVehiculo().getUbi().getnombre()+"\n");
		}
	}
	
	private static void devolverVehiculo(Reserva reserva2) {
		LocalDate fecha = reserva.getfechaDevuelta();
		ArrayList<LocalTime> rangoDeHoras =reserva.gethorasDevuelta();
		LocalDate ahorafecha = LocalDate.now();
		LocalTime ahoraTime = LocalTime.now();
		Sede sedeDevolver = reserva.getsedeEntrega();


		if (ahorafecha.equals(fecha)&&ahoraTime.isAfter(rangoDeHoras.get(0)) &&ahoraTime.isBefore(rangoDeHoras.get(1)))
				
		{
		System.out.println("\n----------- ES HORA DE DEVOLVER TU VEHICULO ----------- \n");
		System.out.println("\n----------- CONFIRMA QUE ES TU VEHICULO: DEVUELTA ----------- \n");
		System.out.println("Categoria: "+reserva.getVehiculo().getCategoria()+"\n");
		System.out.println("Placa: "+reserva.getVehiculo().getPlaca()+"\n");
		System.out.println("Color: "+reserva.getVehiculo().getColor()+"\n");
		System.out.println("Modelo: "+reserva.getVehiculo().getModelo()+"\n");
		System.out.println("Tipo de Transmision: "+reserva.getVehiculo().getTipoTransmision()+"\n");
		System.out.println("Ubicacion: "+reserva.getVehiculo().getUbi().getnombre()+"\n");
		String confirmacion = input("\nDesea adicionar otro conductor? (SI/NO): \n");
		}
		else {
			System.out.println("No es el horario adecuado para devolver tu vehiculo, vulve despues.");
		}
		
	}

	public static void reEscribirReservas() throws IOException {
		String data="login:categoria:nombreSede:fechaRecogida:horaRecogida:especial:fechaDevuelta:rangoDeHoras:temporada:sedeEntrega:precio:Seguros:costoConductorAdicional:conductoresAdicionales\n";
		for (int a =0 ; a < ConsolaPrincipal.listaReservas.size(); a++) {
			Reserva laReserva = ConsolaPrincipal.listaReservas.get(a);
			data+= laReserva.getcliente().getLogin()+ ";" + laReserva.getcategoria()+ ";" + laReserva.getsede().getnombre()+ ";" + laReserva.getfechaRecogida().toString()+ ";" + laReserva.gethoraRecogida().toString()+ ";" + laReserva.getEspecial()+ ";" + laReserva.getfechaDevuelta().toString()+ ";" + laReserva.getrangoHoras().get(0)+ "," +laReserva.getrangoHoras().get(1)+ ";" + laReserva.getTemporada() + ";" + laReserva.getsedeEntrega().getnombre()+ ";" + laReserva.getPrecio().toString()+";";
			if(laReserva.getCostosSeguro() == null) {
				data+="*";
			}
			else {
			for(Seguro seguro: laReserva.getCostosSeguro()) {
				data+=seguro.getNombre()+",";
				
			}
			}
			data+= ";"+laReserva.getCostoConductorAdicional().toString()+";";
			if(laReserva.getConductores().size()==0) {
				data+="*";
			}
			else {
			for(ConductorAdicional c: laReserva.getConductores()) {
				data+=c.getNombre()+"&"+c.getContacto().get(0)+"/"+c.getContacto().get(1)+"&"+c.getFechaNacimiento().toString()+"&"+c.getNacionalidad()+"&"+c.getDoc().toString()+"&"+c.getLicencia().getNumero()+"/"+c.getLicencia().getPais()+"/"+c.getLicencia().getFecha().toString()+",";
				
			}
			}
			data+="\n";
		}
			FileWriter file = new FileWriter("./data/archivoReservas.txt");
			BufferedWriter output = new BufferedWriter(file);
			output.write(data);
			output.close();
	}

	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje);
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