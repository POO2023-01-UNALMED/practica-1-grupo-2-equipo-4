package uiMain;
import gestorAplicacion.clasesEnum.*;
//import gestorAplicacion.clasesHerencia.*;
import gestorAplicacion.clasesPrincipales.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
//import baseDatos.EscritorLector;

public class Main {
	// Se crea el escaner de inputs
	static Scanner sc = new Scanner(System.in);
	// Se crean espacios para los objetos de nuestras clases
	static ArrayList<Alimento> alimentos = new ArrayList<Alimento>();
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static ArrayList<Comida> comidas = new ArrayList<Comida>();
	static ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
	static ArrayList<Entrenador> entrenadores = new ArrayList<Entrenador>();
	static ArrayList<Gimnasio> gimnasios = new ArrayList<Gimnasio>();
	static ArrayList<Maquina> maquinas = new ArrayList<Maquina>();
	static ArrayList<PlanAlimentacion> planesAlimentacion = new ArrayList<PlanAlimentacion>();
	static ArrayList<PlanEjercicio> planesEjercicio = new ArrayList<PlanEjercicio>();
	static ArrayList<Rutina> rutinas = new ArrayList<Rutina>();
	
	static {
		// ¿Cómo cargamos los objetos del EscritorLector?
		// Discutir con Jacobo
        // Orden de creación F1: Gimnasio, Entrenador, Cliente, Maquina, Movimiento, Ejercicio.
		// Orden de creación F2: Gimnasio, Entrenador, Cliente, Alimento, Comida, PlanAlimentacion.
		
		Gimnasio g1 = new Gimnasio("Golds", "Med", "Robledo", true); // abierto
		
		gimnasios.add(g1);
		// Clientes Similares. Sexo, PreferenciaAlim, Objetivo. Rangos Altura, peso, Edad
		
		Cliente c1 = new Cliente("Platz", g1, 777, 180, 68, "H", 18, null, PreferenciaAlimenticia.Vegano, NivelCliente.PRINCIPIANTE, ObjetivoCliente.BAJARPESO);
		Cliente c2 = new Cliente("Arnold", g1, 778, 180, 68, "H", 18, null, PreferenciaAlimenticia.Vegano, NivelCliente.PRINCIPIANTE, ObjetivoCliente.BAJARPESO);
		Cliente c3 = new Cliente("Max", g1, 779, 180, 68, "H", 18, null, PreferenciaAlimenticia.Vegano, NivelCliente.PRINCIPIANTE, ObjetivoCliente.BAJARPESO);
		Cliente c4 = new Cliente("Tren", g1, 780, 180, 68, "H", 18, null, PreferenciaAlimenticia.Vegano, NivelCliente.PRINCIPIANTE, ObjetivoCliente.BAJARPESO);
		Cliente c5 = new Cliente("Jeff", g1, 781, 180, 68, "H", 18, null, PreferenciaAlimenticia.Vegano, NivelCliente.PRINCIPIANTE, ObjetivoCliente.BAJARPESO);
		
		clientes.add(c1); clientes.add(c2); clientes.add(c3); clientes.add(c4); clientes.add(c5);
		
		Alimento alimento1 = new Alimento("Manzana", 50, 0.5, 13, 0.4, null);
		Alimento alimento2 = new Alimento("Lechuga", 5, 0.5, 1, 0.1, null);
		Alimento alimento3 = new Alimento("Pollo", 150, 25, 0, 5, null);
		Alimento alimento4 = new Alimento("Arroz", 200, 4, 45, 1, null);
		Alimento alimento5 = new Alimento("Pescado", 120, 20, 0, 3, null);
		Alimento alimento6 = new Alimento("Zanahoria", 35, 0.6, 8, 0.2, null);
		Alimento alimento7 = new Alimento("Ternera", 250, 26, 0, 17, null);
		Alimento alimento8 = new Alimento("Camarones", 10, 1, 1, 1, Alergeno.MARISCO);
		
		Comida comida4 = new Comida("Comida 4", new ArrayList<>(Arrays.asList(alimento8)), TipoComida.Desayuno, PreferenciaAlimenticia.Vegano, ObjetivoCliente.BAJARPESO);
		Comida comida5 = new Comida("Comida 5", new ArrayList<>(Arrays.asList(alimento8)), TipoComida.Almuerzo, PreferenciaAlimenticia.Vegano, ObjetivoCliente.BAJARPESO);
		
		// Creación de las listas de alimentos
		ArrayList<Alimento> listaAlimentos1 = new ArrayList<>();
		ArrayList<Alimento> listaAlimentos2 = new ArrayList<>();
		ArrayList<Alimento> listaAlimentos3 = new ArrayList<>();

		// Agregar los alimentos a las listas correspondientes
		listaAlimentos1.add(alimento1);
		listaAlimentos1.add(alimento2);
		listaAlimentos1.add(alimento3);

		listaAlimentos2.add(alimento4);
		listaAlimentos2.add(alimento5);
		listaAlimentos2.add(alimento6);

		listaAlimentos3.add(alimento7);
		
		for (Cliente c : clientes) { // Para cada cliente creo un plan
		    PlanAlimentacion pc1 = new PlanAlimentacion("Plan Cliente " + c.getNombre(), 3);

		    // Creación del plan semanal
		    HashMap<DiaSemana, ArrayList<Comida>> planSemanal = new HashMap<>();
		    
		    if (c.getNombre().equals("Max") || c.getNombre().equals("Tren")) {
		    	ArrayList<Comida> comidasDia = planSemanal.get(DiaSemana.LUNES); // Obtén las comidas del día LUNES
		    	if (comidasDia != null) {
		            comidasDia.add(comida4); // Agrega la nueva comida con alérgeno MARISCO
		            comidasDia.add(comida5); // Agrega otra comida con alérgeno MARISCO
		        }
		    } 
		    
		    for (DiaSemana dia : DiaSemana.values()) {
		        ArrayList<Comida> comidasDia = new ArrayList<>();

		        // Lógica para crear comidas diferentes según el día de la semana
		        // Aquí puedes implementar tu propia lógica o crear nuevas instancias de Comida según corresponda

		        if (dia == DiaSemana.LUNES || dia == DiaSemana.MIERCOLES || dia == DiaSemana.VIERNES) {
		            Comida comida1 = new Comida("Comida 1", new ArrayList<>(Arrays.asList(
		                new Alimento("Manzana", 50, 0.5, 13, 0.4, null),
		                new Alimento("Lechuga", 5, 0.5, 1, 0.1, null),
		                new Alimento("Pollo", 150, 25, 0, 5, null)
		            )), TipoComida.Desayuno, PreferenciaAlimenticia.Vegano, ObjetivoCliente.BAJARPESO);

		            comidasDia.add(comida1);
		        } else if (dia == DiaSemana.MARTES || dia == DiaSemana.JUEVES) {
		            Comida comida2 = new Comida("Comida 2", new ArrayList<>(Arrays.asList(
		                new Alimento("Arroz", 200, 4, 45, 1, null),
		                new Alimento("Pescado", 120, 20, 0, 3, null),
		                new Alimento("Zanahoria", 35, 0.6, 8, 0.2, null)
		            )), TipoComida.Almuerzo, PreferenciaAlimenticia.Vegano, ObjetivoCliente.BAJARPESO);

		            comidasDia.add(comida2);
		        } else if (dia == DiaSemana.SABADO || dia == DiaSemana.DOMINGO) {
		            Comida comida3 = new Comida("Comida 3", new ArrayList<>(Arrays.asList(
		                new Alimento("Ternera", 250, 26, 0, 17, null)
		            )), TipoComida.Cena, PreferenciaAlimenticia.Vegano, ObjetivoCliente.BAJARPESO);

		            comidasDia.add(comida3);
		        }

		        // Agregar el ArrayList comidasDia al HashMap planSemanal con el día como clave
		        planSemanal.put(dia, comidasDia);
		    }

		    pc1.setPlanSemanal(planSemanal);
		    c.planAlimentacion = pc1;
		}
		
		// Hacer algunas comidas alérgicas.
		
		
	}
	
	public static void main(String[] args) {
		byte opcion;
		String salir = "n";
		
		do {
			println("\n\nMENU PRINCIPAL");
			println("1. Reservar Gimnasio");
			println("2. Recomendación de Plan de Alimentación Semanal");
			println("3. Funcionalidad 3");
			println("4. Funcionalidad 4");
			println("5. Funcionalidad 5");
			println("6. Salir");
			print("Ingrese la opción que requiera: ");
			
			opcion = readByte();
			
			switch (opcion) {
				case 1:
					reservarGimnasio();
					break;
				case 2:
					recomendarPlanAlimentacion();
					break;
				case 3:
					f3();
					break;
				case 4:
					f4();
					break;
				case 5:
					f5();
					break;
				case 6:
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
		print("¡Gracias por usar Jimbro!");
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
	
	// Funcionalidades
	static void reservarGimnasio() {
		// Ingresar la identificación del cliente y encontrar el objeto asociado
		print("Ingrese su identificación: ");
		int ident = readInt();
		Cliente miCliente = null;
		
		for (Cliente c : clientes) {
			if (c.getIdentificacion() == ident) {
				miCliente = c;
				break;
			}
		}
		
		if (miCliente == null) {
			println("Identificación incorrecta");
			System.exit(0);
		}
		
		else
			print("Ingrese el nombre del gimnasio en el que desea entrenar: ");
			String gimnasioDeseado = readString();
			print("Ingrese la ciudad en la que desea entrenar: ");
			String ciudadGimnasioDeseado = readString();
			print("Ingrese la rutina que va a realizar: ");
			String rutinaDeseada = readString(); // El nombre debe ser igual al del objeto de Rutina
			
			// Buscar Gimnasio en Ciudad
			Gimnasio gimnasioElegido = null;
			for (Gimnasio g: gimnasios) { // Revisar igualdad de Nombre y Ciudad
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
				for (Rutina rutina : rutinas) {
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
				
				ArrayList<Gimnasio> sedesDisponibles = gimnasioElegido.sedesDisponibles(maquinasNecesarias); // PRIMER MÉTODO EN GIMNASIO
				
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
						String intensidad = readString();					
						
						if (!intensidad.equalsIgnoreCase("PRINCIPIANTE") && !intensidad.equalsIgnoreCase("INTERMEDIO") 
								&& !intensidad.equalsIgnoreCase("AVANZADO")) {
							println("Intensidad Incorrecta. Seleccione PRINCIPIANTE/INTERMEDIO/AVANZADO");
							System.exit(0);
						}
						
						print("Seleccione el horario en el que asistirá (MAÑANA/TARDE): ");
						String horarioAsistencia = readString();

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
	
	static void recomendarPlanAlimentacion() { //Se va a recomendar un plan de alimentacion
		print("Ingrese su identificación: ");
		int ident = readInt();
		Cliente miCliente = null;
		
		for (Cliente c : clientes) {
			if (c.getIdentificacion() == ident) {
				miCliente = c;
				break;
			}
		}
		
		if (miCliente == null) {
			println("Identificación incorrecta");
			System.exit(0);
		}
		
		// Hago la extracción de clientes similares a mi cliente actual. (PRIMER METODO EN GIMNASIO)
		ArrayList<Cliente> clientesSimilares = miCliente.getGimnasio().clientesSimilares(miCliente);
		
		if (clientesSimilares.size() == 0) {
			println("Por favor agende una cita con nuestro nutricionista.");
		}
		
		else { // Utilizo los clientes similares para guardar Planes que podrían servir.
			ArrayList<PlanAlimentacion> planesAdecuados = new ArrayList<>();
			
			for (Cliente c : clientesSimilares) {planesAdecuados.add(c.planAlimentacion);}
			
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
					
					miCliente.asignarPlan(planElegido);
					
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
						print("Plan Alimenticio seleccionado: " + planElegido.nombrePlan);
						
						if (miCliente.asignarPlan(planElegido) == null) { // Si no tiene histórico de planes alimenticios
							println("le recomendamos el nuevo plan: ");
							println(planElegido.toString());
						}
						else { // Muestro el plan que tiene, y le doy una recomendación para hacer la transición de planes.
							println("En su histórico se muestra el plan anterior: ");
							
							miCliente.asignarPlan(planElegido).toString(); // Plan anterior.
							
							println("\n Le recomendamos seguir este plan y en en transcurso de "
									+ "una semana ir cambiando los alimentos para llegar a este nuevo plan: ");
							
							println(planElegido.toString()); // Plan nuevo.
						}
					}
				}
			}
		}
	}
	
	static void f3() {
		System.out.println("*Logica funcionalidad 3*");
	}
	
	static void f4() {
		System.out.println("*Logica funcionalidad 4*");
	}
	
	static void f5() {
		System.out.println("*Logica funcionalidad 5*");
	}
}
