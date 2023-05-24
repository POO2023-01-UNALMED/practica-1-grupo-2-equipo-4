package uiMain;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;
import baseDatos.Serializador;
import gestorAplicacion.clasesPrincipales.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.util.HashMap;

public class Main {
	// Se crea el escaner de inputs
	static Scanner sc = new Scanner(System.in);
	static long readLong(){
		return sc.nextLong();
	}
	static String readln(){
		sc.nextLine();
		return sc.nextLine();
	}
	// Se crean espacios para los objetos de nuestras clases
	
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		
		byte opcion;
		String salir = "n";
		
		Cliente miCliente = null;
		
		println("¡Hola! Bienvenido a Gymbro\n");
		print("-----INICIO DE SESIÓN-----\nIngrese su identificación: ");

		while (miCliente == null) {
		    int ident = readInt();
		    boolean clienteEncontrado = false;

		    for (Cliente c : empresa.getClientes()) {
		        if (c.getIdentificacion() == ident) {
		            miCliente = c;
		            clienteEncontrado = true;
		            break;
		        }
		    }

		    if (!clienteEncontrado) {
		        println("Identificación incorrecta, no estás suscrito a nuestro gimnasio.\nVuelve a ingresar tu identificación: ");
		    }
		}
	
		do {

			println("\n\nMENÚ PRINCIPAL");
			println("1. Reservar Gimnasio");
			println("2. Recomendación de Plan de Alimentación Semanal");
			println("3. Recomendación de Plan de Ejercicio Semanal");
			println("4. Funcionalidad 4");
			println("5. Recomendación de Entrenadores");
			println("6. Salir");
			print("Ingrese la opción que requiera: ");
			
			opcion = readByte();
			
			switch (opcion) {
				case 1:
					reservarGimnasio(empresa, miCliente);
					break;
				case 2:
					recomendarPlanAlimentacion(empresa, miCliente);
					break;
				case 3:
					recomendarPlanEjercicio(miCliente);
					break;
				case 4:
					f4();
					break;
				case 5:
					recomendarEntrenadores(empresa, miCliente);
					break;
				case 6:
					salirDelSistema(empresa);
					break;
				default:
					println("Digitó una opción incorrecta");
			}
			
			if (opcion != 6) {
				do {
					print("\nDesea salir (y/n): ");
					salir = readString();
				}
				while (!salir.toLowerCase().equals("y") && !salir.toLowerCase().equals("n"));
			}
		} while (opcion != 6 && !salir.toLowerCase().equals("y"));
		print("¡Gracias por usar Gymbro!");
		sc.close();
	}
	

	// Funciones útiles
	private static void print(Object string) {
		System.out.print(string);
	}

	private static void println(Object string) {
		System.out.println(string);
	}
	
	private static byte readByte() {byte opcion = sc.nextByte(); return opcion;}
	
	private static String readString() {String input = sc.next(); return input;}
	
	private static int readInt() {int i = sc.nextInt(); return i;}
	
	
	//Salir y guardar
	private static void salirDelSistema(Empresa empresa){
		System.out.println("Le agradecemos por utilizar nuestros servicios");
		System.out.println("¡Vuelva pronto!");
		Serializador.serializar(empresa);
		System.exit(0);
	}

	// Funcionalidades
	static void reservarGimnasio(Empresa empresa, Cliente miCliente) {
		print("Ingrese el nombre del gimnasio en el que desea entrenar: ");
		String gimnasioDeseado = readString();
		sc.nextLine(); 
		print("Ingrese la ciudad en la que desea entrenar: ");
		String ciudadGimnasioDeseado = readString();
		sc.nextLine(); 
		print("Ingrese la rutina que va a realizar: ");
		String rutinaDeseada = sc.nextLine(); // El nombre debe ser igual al del objeto de Rutina
		
		
		// Buscar Gimnasio en Ciudad
		Gimnasio gimnasioElegido = null;
		
		for (Gimnasio g: empresa.getGimnasios()) { // Revisar igualdad de Nombre y Ciudad
			if ((g.getNombre().equals(gimnasioDeseado)) && (g.getCiudad().equals(ciudadGimnasioDeseado))) {
				gimnasioElegido = g;
				break;
			}
		}
		
		if (gimnasioElegido == null) {
			println("No hay sedes disponibles");
		}
		
		
		else {
			// Inicializar lista de maquinas necesarias para hacer la rutina
			ArrayList<Maquina> maquinasNecesarias = new ArrayList<>();
			// Buscar rutina deseada por el cliente por Nombre
			Rutina rutinaBuscar = null;
			for (Rutina rutina : empresa.getRutinas()) {
				if (rutina.getNombre().equals(rutinaDeseada)) {
					rutinaBuscar = rutina;
					break;
				}
			}
			
			if (rutinaBuscar == null) {
				println("No hay gimnasios disponibles para esta rutina en " + ciudadGimnasioDeseado);
			}
			else { // Quiero ver si mi gimnasio tiene las maquinas necesarias
				for (Ejercicio e : rutinaBuscar.getEjercicios()) {
					maquinasNecesarias.add(e.getMaquina());
				}
			}
			
			gimnasioElegido.setListaGimnasios(new ArrayList<>(empresa.getGimnasios())); // Seteo Todos los gimnasios con informacion actualizada
			
			ArrayList<Gimnasio> sedesDisponibles = gimnasioElegido.sedesDisponibles(maquinasNecesarias); // PRIMER MÉTODO EN GIMNASIO
			
			for (Gimnasio sede : sedesDisponibles) {
				sede.getListaMaquinas();
			}
			
			if (sedesDisponibles.size() == 0) {
				println("No hay sedes disponibles en "+ciudadGimnasioDeseado+" para esta rutina");
			}
			
			else { // Muestro las sedes disponibles para entrenar esa rutina
				println("Sedes disponibles para entrenar:");
				for (int i = 1; i <= sedesDisponibles.size(); i++) {
					println(i +": " + sedesDisponibles.get(i-1).getSede());
				}
				print("Ingrese el número de la sede en la que desea entrenar: ");
				byte opcSede = readByte();
				
				if (opcSede <= 0 || opcSede > sedesDisponibles.size()) {
					println("Opción incorrecta");
				}
				else { // Selecciona la intensidad del entrenamiento y el horario de reserva del Entrenador en esta Sede seleccionada.
					Gimnasio sedeGimnasio = sedesDisponibles.get(opcSede-1);
					println("Sede seleccionada: " + sedeGimnasio.toString());
					
					print("Seleccione la intensidad del entrenamiento (PRINCIPIANTE/INTERMEDIO/AVANZADO): ");
					String intensidad = readString().toUpperCase();					
					
					if (!intensidad.equalsIgnoreCase("PRINCIPIANTE") && !intensidad.equalsIgnoreCase("INTERMEDIO") 
							&& !intensidad.equalsIgnoreCase("AVANZADO")) {
						println("Intensidad Incorrecta. Seleccione PRINCIPIANTE/INTERMEDIO/AVANZADO");
						System.exit(0);
					}
					
					print("Seleccione el horario en el que asistirá (MAÑANA/TARDE): ");
					String horarioAsistencia = readString().toUpperCase();

					if (!horarioAsistencia.equalsIgnoreCase("MAÑANA") && !horarioAsistencia.equalsIgnoreCase("TARDE")) {
						println("Horario Incorrecto. Seleccione MAÑANA/TARDE");
						System.exit(0);
					}
					
					ArrayList<Entrenador> entrenadoresSede = sedeGimnasio.getListaEntrenadores(); // Filtrar sobre esta lista.
					ArrayList<Entrenador> entrenadoresDisponibles = new ArrayList<>(); // Contiene los entrenadores adecuados.
					
					for (Entrenador e : entrenadoresSede) { // Filtra sobre los entrenadores y llena la lista de objetos.
						if (!e.getDisponibilidad().equalsIgnoreCase("NO DISPONIBLE")) {
							Entrenador entrenadorDisponible = e.entrenadoresDisponibles(horarioAsistencia, intensidad); // SEGUNDO MÉTODO
							
							if (entrenadorDisponible != null) {
								entrenadoresDisponibles.add(entrenadorDisponible);
							}
						}
					}
					
					if (entrenadoresDisponibles.size() == 0) {
						println("No hay entrenadores disponibles en "+ciudadGimnasioDeseado+" para esta rutina");
					}
					else {
					println("Entrenadores Disponibles: ");
					for (int i=1; i<=entrenadoresDisponibles.size(); i++) {
						println(i + ". "+ entrenadoresDisponibles.get(i-1).getNombre());
					}
					
					print("Seleccione el entrenador deseado: ");
					byte opcionEntrenador = readByte();
					
					if (opcionEntrenador <= 0 || opcionEntrenador > entrenadoresDisponibles.size()) 
						println("Opción incorrecta");
					
					else { // Se pide seleccione uno de los adecuados.
						Entrenador entrenadorElegido = entrenadoresDisponibles.get(opcionEntrenador-1);
						print("Entrenador seleccionado: " + entrenadorElegido.getNombre());
						
						miCliente.asignarEntrenador(entrenadorElegido); // TERCER MÉTODO
						}
					}		
				}
			}
		}
	}
	
	static void recomendarPlanAlimentacion(Empresa empresa, Cliente miCliente) { //Se va a recomendar un plan de alimentacion		
		// Hago la extracción de clientes similares a mi cliente actual. (PRIMER METODO EN GIMNASIO)
		ArrayList<Cliente> clientesSimilares = miCliente.getGimnasio().clientesSimilares(miCliente);
		
		// NECESITO OBJETOS DE MISMA PREFERENCIA ALIMENTICIA.
		
		if (clientesSimilares.size() == 0) {
			println("Por favor agende una cita con nuestro nutricionista.");
		}
		
		else { // Utilizo los clientes similares para guardar Planes que podrían servir.
			ArrayList<PlanAlimentacion> planesAdecuados = new ArrayList<>();
			
			for (Cliente c : clientesSimilares) {
				//print(c.getPlanAlimentacion());
				planesAdecuados.add(c.getPlanAlimentacion());
			}
			
			// Le pido al cliente sus alergias.
			ArrayList<Alergeno> alergias = new ArrayList<>();
			
			print("Es alergico al HUEVO (SI / NO): ");
			String opcionHuevo = readString().toUpperCase();
			
			if (opcionHuevo.equals("SI")) {
			    alergias.add(Alergeno.HUEVO);
			} else if (!opcionHuevo.equals("NO")) { // SI ES "NO" CONTINUA EL PROGRAMA
			    println("No alérgico. Se ingresó una opción distinta de SI.");
			}
			
			print("Es alergico a los MARISCOS (SI / NO): ");
			String opcionMariscos = readString().toUpperCase();
			
			if (opcionMariscos.equals("SI")) {
			    alergias.add(Alergeno.MARISCO);
			} else if (!opcionMariscos.equals("NO")) {
			    println("No alérgico. Se ingresó una opción distinta de SI.");
			}
			
			print("Es intolerante a la LACTOSA (SI / NO): ");
			String opcionLactosa = readString().toUpperCase();
			
			if (opcionLactosa.equals("SI")) {
			    alergias.add(Alergeno.LACTOSA);
			} else if (!opcionLactosa.equals("NO")) {
			    println("No alérgico. Se ingresó una opción distinta de SI.");
			}
			
			print("Es alergico al GLUTEN (SI / NO): ");
			String opcionGluten = readString().toUpperCase();
			
			if (opcionGluten.equals("SI")) {
			    alergias.add(Alergeno.GLUTEN);
			} else if (!opcionGluten.equals("NO")) {
			    println("No alérgico. Se ingresó una opción distinta de SI.");
			}
			
			print("Es alergico a los FRUTOS SECOS (SI / NO): ");
			String opcionFrutosSecos = readString().toUpperCase();
			
			if (opcionFrutosSecos.equals("SI")) {
			    alergias.add(Alergeno.FRUTOSECO);
			} else if (!opcionFrutosSecos.equals("NO")) {
			    println("No alérgico. Se ingresó una opción distinta de SI.");
			}
			
			if (alergias.isEmpty()) { // Muestro todos los planes y le pido al usuario que escoja uno.
				println("Planes Disponibles: ");
				for (int i=1; i<=planesAdecuados.size(); i++) {
					println(i + ". "+ planesAdecuados.get(i-1).nombrePlan);
				}
				print("Seleccione el plan deseado: ");
				byte opcionPlan = readByte();
				
				if (opcionPlan <= 0 || opcionPlan > planesAdecuados.size()) 
					println("Opción incorrecta");
				
				else { // Se pide seleccione uno de los adecuados.
					PlanAlimentacion planElegido = planesAdecuados.get(opcionPlan-1);
					println("Plan Alimenticio Personalizado: ");
					
					miCliente.asignarPlanAlimentacion(planElegido); // TERCER METODO
					
					print(planElegido.toString());
				}
			}
			
			else { // filtrar según los alergenos de las comidas. Reemplazar alergenos con proteina.
				ArrayList<PlanAlimentacion> planesModificados = new ArrayList<>();
				for (PlanAlimentacion p : planesAdecuados) {
					if (p != null) {
						p.filtrarPorAlergenos(alergias); // SEGUNDO METODO EN PLANALIMENTACION
						planesModificados.add(p);
					}
				}
				
				if (planesModificados.size() == 0) { // Esto si no quedan planes.
					print("Para recibir mejores recomendaciones de planes según sus alergias por favor pida una cita con Nutricionista");
				}
				
				else {
					println("Planes Disponibles: ");
					for (int i=1; i<=planesModificados.size(); i++) {
						println(i + ". "+ planesModificados.get(i-1).nombrePlan);
					}
					print("Seleccione el plan deseado: ");
					byte opcionPlan = readByte();
					
					if (opcionPlan <= 0 || opcionPlan > planesModificados.size()) 
						println("Opción incorrecta");
					
					else { // Se pide seleccione uno de los adecuados.
						PlanAlimentacion planElegido = planesModificados.get(opcionPlan-1);
						println("Plan Alimenticio seleccionado: " + planElegido.nombrePlan);
						
						miCliente.asignarPlanAlimentacion(planElegido); // TERCER MÉTODO DE NUEVO.
						print(planElegido.toString());
					}
				}
			}
		}
	}
	
	static void recomendarPlanEjercicio(Cliente miCliente) {
		System.out.println("Basándonos en tu objetivo y tu nivel de experiencia, hemos desarrollado un plan para ti");
		System.out.println(miCliente.generarPlanEjercicio());
	}
	
	static void f4() {
		System.out.println("*Logica funcionalidad 4*");
	}
	
	static void recomendarEntrenadores(Empresa empresa, Cliente miCliente) {
		print("Ingrese el nombre de su gimnasio principal: ");
		String gimnasioEscrito = readString().toUpperCase();

		// Revisar si el gimnasio ingresado es igual al que se le atribuye al cliente.
		Gimnasio gimnasioPrincipal = null;
		Gimnasio gimnasioCliente = miCliente.getGimnasio();
		for (Gimnasio g : empresa.getGimnasios()) { // Revisar igualdad de Nombre
			if ((g.getNombre().equalsIgnoreCase(gimnasioEscrito)) && (gimnasioCliente.getNombre().equalsIgnoreCase(gimnasioEscrito))) {
				gimnasioPrincipal = g;
				break;
			}
		}

		if (gimnasioPrincipal == null) {
			println("Este no es su gimnasio principal.");
		}

		else {
			// Se obtienen los entrenadores de la sede del cliente.
			ArrayList<Entrenador> entrenadoresSedeCliente = gimnasioPrincipal.getListaEntrenadores();
			ArrayList<Entrenador> entrenadoresFiltrados = new ArrayList<>();
			
			// Se filtran los entrenadores según nivel (mismo del cliente), edad (no mayor a
			// 10 años respecto a la del cliente), formacion (debe estar enfocada en el
			// objetivo del cliente).
			for (Entrenador e : entrenadoresSedeCliente) {
				Entrenador entrenadorFiltrado = e.filtroEntrenadores(miCliente);

				if (entrenadorFiltrado != null) {
					entrenadoresFiltrados.add(entrenadorFiltrado);
				}
			}
			
			// Se comparan las califcaciones promedio de los entrenadores filtrados.
			Comparator<Entrenador> comparadorCalificacionPromedio = new Comparator<Entrenador>() {
				@Override
				public int compare(Entrenador entrenador1, Entrenador entrenador2) {
					if (entrenador1.calificacionPromedio > entrenador2.calificacionPromedio) {
						return -1;
					} else if (entrenador1.calificacionPromedio < entrenador2.calificacionPromedio) {
						return 1;
					} else {
						return 0;
					}

				}
			};
			
			// Se ordenan de mayor a menor calificacion promedio.
			Collections.sort(entrenadoresFiltrados, comparadorCalificacionPromedio);

			ArrayList<Entrenador> entrenadoresRecomendados = new ArrayList<>();
			
			// Se añaden solo los tres mejores entrenadores a lista de recomendados.
			for (int i = 0; i < entrenadoresFiltrados.size(); i++) {
				if (entrenadoresRecomendados.size() < 3) {
					entrenadoresRecomendados.add(entrenadoresFiltrados.get(i));
				} 
				
				else {
					break;
				}
			}
			
			// Se muestra el TOP 3 recomendados y sus "hojas de vida".
			print("\n");
			println("TOP ENTRENADORES RECOMENDADOS\n");
			for (int i = 1; i <= entrenadoresRecomendados.size(); i++) {
				println(i + ". " + entrenadoresRecomendados.get(i - 1).descripcionHojaVida());
			}

			print("Seleccione el entrenador deseado: ");
			byte opcionEntrenador = readByte();

			if (opcionEntrenador <= 0 || opcionEntrenador > entrenadoresRecomendados.size())
				println("Opción incorrecta.");
			
			// Se selecciona y asigna el entrenador al cliente.
			else {
				Entrenador entrenadorElegido = entrenadoresRecomendados.get(opcionEntrenador - 1);
				println("Entrenador seleccionado: " + entrenadorElegido.getNombre());

				miCliente.asignarEntrenador(entrenadorElegido);

				ArrayList<String> opcionesCambiarPlanes = new ArrayList<>();
				opcionesCambiarPlanes.add("Ambos");
				opcionesCambiarPlanes.add("Solo el Plan de Ejercicio");
				opcionesCambiarPlanes.add("Solo el Plan de Alimentación");
				
				// Se empiezan a dar las opciones para asignar o no, uno de los dos o ambos
				// planes (Ejercicio y Alimentación) recomendados que tiene el entrenador.
				if ((entrenadorElegido.getPlanEjercicioRecomendado() != null
						&& entrenadorElegido.getPlanAlimentacionRecomendado() != null)
						&& ((miCliente.getPlanEjercicio() != null 
						|| miCliente.getPlanEjercicio() == null) 
						&& (miCliente.getPlanAlimentacion() != null 
						|| miCliente.getPlanAlimentacion() == null))) {
					
					print("\n");
					println("El entrenador seleccionado cuenta con un Plan de Ejercicio y un Plan de Alimentación recomendados."
							+ "\nDesea asignar ambos como sus planes actuales o solo uno de ellos: ");
					print("\n");
					
					for (int i = 1; i <= opcionesCambiarPlanes.size(); i++) {
						println(i + ". " + opcionesCambiarPlanes.get(i - 1));
					}
					
					print("\n");
					print("Seleccione la opción deseada: ");
					byte opcionCambiarPlanes = readByte();

					if (opcionCambiarPlanes <= 0 || opcionCambiarPlanes > opcionesCambiarPlanes.size())
						println("Opción incorrecta.");

					else {
						String planElegido = opcionesCambiarPlanes.get(opcionCambiarPlanes - 1);
						if (planElegido == "Ambos") {
							miCliente.asignarPlanEjercicio(entrenadorElegido.getPlanEjercicioRecomendado());
							println(miCliente.getPlanEjercicio());
							miCliente.asignarPlanAlimentacion(entrenadorElegido.getPlanAlimentacionRecomendado());
							print(miCliente.getPlanAlimentacion());
							println("Se asignaron ambos planes.");
						}
						
						if (planElegido == "Solo el Plan de Ejercicio") {
							miCliente.asignarPlanEjercicio(entrenadorElegido.getPlanEjercicioRecomendado());
							print("\n");
							println(miCliente.getPlanEjercicio());
							println("Se asignó el Plan de Ejercicio.");
						}
						
						if (planElegido == "Solo el Plan de Alimentación") {
							miCliente.asignarPlanAlimentacion(entrenadorElegido.getPlanAlimentacionRecomendado());
							print("\n");
							print(miCliente.getPlanAlimentacion());
							println("Se asignó el Plan de Alimentación.");
						}
					}
				}
			}
		}
	}
}