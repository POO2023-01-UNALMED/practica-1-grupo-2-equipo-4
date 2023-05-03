package uiMain;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;
import gestorAplicacion.clasesPrincipales.*;
import java.util.ArrayList;
import java.util.Scanner;
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
		
        // Orden de creación: Gimnasio, Entrenador, Cliente, Maquina, Movimiento, Ejercicio.
		Gimnasio g1 = new Gimnasio("Golds", "Med", "Robledo", true); // abierto
		Gimnasio g2 = new Gimnasio("Golds2", "Med", "Poblado", true); // abierto
		Gimnasio g3 = new Gimnasio("g3", "Med", "Calasanz", true); // abierto
		
		Entrenador e1 = new Entrenador("Entrenador1", g1, 1001, "Doctor", null, NivelCliente.PRINCIPIANTE, "MAÑANA"); // disponible
		Entrenador e2 = new Entrenador("Entrenador2", g1, 1002, "PosDoctor", null, NivelCliente.INTERMEDIO, "TARDE");
		
		Entrenador e21 = new Entrenador("Entrenador3", g2, 2001, "Bachi", null, NivelCliente.INTERMEDIO, "MAÑANA");
		Entrenador e22 = new Entrenador("Entrenador4", g2, 2002, "Bachi", null, NivelCliente.PRINCIPIANTE, "TARDE");
	 
		g3.agregarEntrenador(e1);
		
		Maquina m1 = new Maquina("Barra", g1);
		Maquina m2 = new Maquina("Pared", g1);
		Maquina m3 = new Maquina("Libre", g1);
		Maquina m4 = new Maquina("Libre", g1);

		Maquina m21 = new Maquina("Libre", g2);
		Maquina m22 = new Maquina("Libre", g2);
		Maquina m23 = new Maquina("Libre", g2);
		Maquina m24 = new Maquina("Libre", g2);
		
		g3.agregarMaquina(m23); g3.agregarMaquina(m24); // La mismas maquinas para hacer pierna que en g2
		
		Ejercicio eje1 = new Ejercicio("Barra", "", "", TipoEjercicio.EMPUJAR, m1, 1, 1);
		Ejercicio eje2 = new Ejercicio("Pullup", "", "", TipoEjercicio.HALAR, m2, 1, 1);
		Ejercicio eje3 = new Ejercicio("Pulldown", "", "", TipoEjercicio.EMPUJAR, m3, 1, 1);
		Ejercicio eje4 = new Ejercicio("Remo", "", "", TipoEjercicio.HALAR, m4, 1, 1);
		
		Ejercicio eje21 = new Ejercicio("Correr", "", "", TipoEjercicio.CARDIO, m21, 1, 1);
		Ejercicio eje22 = new Ejercicio("Caminar", "", "", TipoEjercicio.CARDIO, m22, 1, 1);
		Ejercicio eje23 = new Ejercicio("Sentadilla", "", "", TipoEjercicio.PIERNA, m23, 1, 1);
		Ejercicio eje24 = new Ejercicio("Extension Pierna", "", "", TipoEjercicio.PIERNA, m24, 1, 1);
		
		ArrayList<Ejercicio> r1 = new ArrayList<Ejercicio>();
		ArrayList<Ejercicio> r2 = new ArrayList<Ejercicio>();
		ArrayList<Ejercicio> r3 = new ArrayList<Ejercicio>();
		ArrayList<Ejercicio> r4 = new ArrayList<Ejercicio>();
		
		r1.add(eje1); r1.add(eje3); // Empujar
		r2.add(eje2); r2.add(eje4); // Jalar
		r3.add(eje21); r3.add(eje22); // Cardio
		r4.add(eje23); r4.add(eje24); // Pierna
		
		Rutina rut1 = new Rutina("r1", r1, TipoEjercicio.EMPUJAR); // Creo las rutinas
		Rutina rut2 = new Rutina("r2", r2, TipoEjercicio.HALAR);
		Rutina rut3 = new Rutina("r3", r3, TipoEjercicio.CARDIO);
		Rutina rut4 = new Rutina("r4", r4, TipoEjercicio.PIERNA);
		
		Cliente c1 = new Cliente("Platz", g1, 777, 180, 68, "H", 18, null, PreferenciaAlimenticia.Vegano, NivelCliente.PRINCIPIANTE, ObjetivoCliente.BAJARPESO);
	
		
		gimnasios.add(g1); gimnasios.add(g2); gimnasios.add(g3);
		entrenadores.add(e1); entrenadores.add(e2); entrenadores.add(e21); entrenadores.add(e22);
		maquinas.add(m1); maquinas.add(m2); maquinas.add(m3); maquinas.add(m4);
		maquinas.add(m21); maquinas.add(m22); maquinas.add(m23); maquinas.add(m24);
		ejercicios.add(eje1); ejercicios.add(eje2); ejercicios.add(eje3); ejercicios.add(eje4);
		ejercicios.add(eje21); ejercicios.add(eje22); ejercicios.add(eje23); ejercicios.add(eje24);
		rutinas.add(rut1); rutinas.add(rut2); rutinas.add(rut3); rutinas.add(rut4); 
		clientes.add(c1);
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
					print("Entrenador seleccionado: " + planElegido.nombrePlan);
					
					miCliente.asignarPlan(planElegido);
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
				
				if (planesModificados.size() == 0) {
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
						print("Entrenador seleccionado: " + planElegido.nombrePlan);
						
						if (miCliente.asignarPlan(planElegido) == null) {
							println("le recomendamos el nuevo plan: ");
							planElegido.toString();
						}
						else {
							println("En su histórico se muestra el plan anterior: ");
							miCliente.asignarPlan(planElegido).toString(); // Hacer un toString() bacano.
							
							println("Le recomendamos seguir este plan y en en transcurso de "
									+ "una semana ir cambiando los alimentos para llegar a este nuevo plan: ");
							
							planElegido.toString();
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
