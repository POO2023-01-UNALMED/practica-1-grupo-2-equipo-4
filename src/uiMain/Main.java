package uiMain;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;
import baseDatos.Serializador;
import gestorAplicacion.clasesPrincipales.*;
import java.util.ArrayList;
import java.util.Arrays;
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
		// 1. Objetos. Revisar Requisitos en guiaObjetos.txt dentro de uiMain.
		Gimnasio g1 = new Gimnasio("Gymbro", "Medellín", "Prado", true);
		Gimnasio g2 = new Gimnasio("Gymbro", "Medellín", "Robledo", true);
		Gimnasio g3 = new Gimnasio("Gymbro", "Medellín", "Laureles", true);
		Gimnasio g4 = new Gimnasio("Bodytech", "Medellín", "San Juan", true);
		Gimnasio g5 = new Gimnasio("Smartfit", "Medellín", "Colombia", false);
		Gimnasio g6 = new Gimnasio("Smartfit", "Bogotá", "La Candelaria", true);
		Gimnasio g7 = new Gimnasio("Smartfit", "Bogotá", "20 de Julio", true);
		Gimnasio g8 = new Gimnasio("Smartfit", "Bogotá", "La Merced", true);
		Gimnasio g9 = new Gimnasio("Bodytech", "Bogotá", "Santafe", true);
		Gimnasio g10 = new Gimnasio("Gymbro", "Bogotá", "Luna Park", true);
		
		
		// Entrenadores
		Entrenador e1 = new Entrenador("Felipe", g1, 1837492314, "CARDIO", null, NivelCliente.INTERMEDIO, "MAÑANA");
		Entrenador e2 = new Entrenador("Ricardo", g1, 1927394729, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "TARDE");
		Entrenador e3 = new Entrenador("Andrés", g1, 1834223231, "GIMNASIA", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
		Entrenador e4 = new Entrenador("Felipe", g2, 1481273752, "CARDIO", null, NivelCliente.PRINCIPIANTE, "TARDE");
		Entrenador e5 = new Entrenador("Alfredo", g2, 1245345234, "CROSSFIT", null, NivelCliente.AVANZADO, "MAÑANA");
		Entrenador e6 = new Entrenador("Tomás", g2, 1023948524, "CARDIO", null, NivelCliente.INTERMEDIO, "MAÑANA");
		Entrenador e7 = new Entrenador("Juan", g3, 1234567890, "MUSCULACIÓN", null, NivelCliente.PRINCIPIANTE, "mañana");
		Entrenador e8 = new Entrenador("Pedro", g3, 1234567891, "CARDIO", null, NivelCliente.INTERMEDIO, "tarde");
		Entrenador e9 = new Entrenador("María", g3, 1234567892, "CROSSFIT", null, NivelCliente.AVANZADO, "mañana");
		Entrenador e10 = new Entrenador("Ana", g4, 1234567893, "GIMNASIA", null, NivelCliente.PRINCIPIANTE, "tarde");
		Entrenador e11 = new Entrenador("Luis", g4, 1234567894, "MUSCULACIÓN", null, NivelCliente.INTERMEDIO, "mañana");
		Entrenador e12 = new Entrenador("Carlos", g4, 1234567895, "CARDIO", null, NivelCliente.AVANZADO, "tarde");
		Entrenador e13 = new Entrenador("Laura", g5, 1234567896, "CROSSFIT", null, NivelCliente.PRINCIPIANTE, "mañana");
		Entrenador e14 = new Entrenador("Sofía", g5, 1234567897, "GIMNASIA", null, NivelCliente.INTERMEDIO, "tarde");
		Entrenador e15 = new Entrenador("Miguel", g5, 1234567898, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "mañana");
		Entrenador e16 = new Entrenador("Elena", g6, 1234567899, "CARDIO", null, NivelCliente.PRINCIPIANTE, "tarde");
		Entrenador e17 = new Entrenador("Juan", g6, 1234567890, "MUSCULACIÓN", null, NivelCliente.PRINCIPIANTE, "mañana");
	    Entrenador e18 = new Entrenador("María", g6, 234567890, "CARDIO", null, NivelCliente.INTERMEDIO, "tarde");
	    Entrenador e19 = new Entrenador("Pedro", g7, 345678901, "CROSSFIT", null, NivelCliente.AVANZADO, "mañana");
	    Entrenador e20 = new Entrenador("Laura", g7, 456789012, "GIMNASIA", null, NivelCliente.PRINCIPIANTE, "tarde");
	    Entrenador e21 = new Entrenador("Carlos", g7, 567890123, "MUSCULACIÓN", null, NivelCliente.INTERMEDIO, "mañana");
	    Entrenador e22 = new Entrenador("Ana", g8, 678901234, "CARDIO", null, NivelCliente.AVANZADO, "tarde");
	    Entrenador e23 = new Entrenador("Luis", g8, 789012345, "CROSSFIT", null, NivelCliente.PRINCIPIANTE, "mañana");
	    Entrenador e24 = new Entrenador("Sofía", g8, 890123456, "GIMNASIA", null, NivelCliente.INTERMEDIO, "tarde");
	    Entrenador e25 = new Entrenador("Miguel", g9, 901234567, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "mañana");
	    Entrenador e26 = new Entrenador("Carolina", g9, 1234567891, "CARDIO", null, NivelCliente.PRINCIPIANTE, "tarde");
	    Entrenador e27 = new Entrenador("Luis", g9, 132142333, "CROSSFIT", null, NivelCliente.PRINCIPIANTE, "mañana");
	    Entrenador e28 = new Entrenador("Sofía", g10, 123124123, "GIMNASIA", null, NivelCliente.INTERMEDIO, "tarde");
	    Entrenador e29 = new Entrenador("Miguel", g10, 41234123, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "mañana");
	    Entrenador e30 = new Entrenador("Carolina", g10, 234133123, "CARDIO", null, NivelCliente.PRINCIPIANTE, "tarde");
	    
	    //CLIENTES
	    
	    Cliente c1 = new Cliente("Gilberto", g1, 912384723, 1.72, 71.2, "M", 38, e2, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c2 = new Cliente("Sandro", g1, 42391242, 1.72, 71.2, "M", 51, e1, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c3 = new Cliente("Sebastian", g1, 1025640725, 1.72, 71.2, "M", 19, e2, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c4 = new Cliente("Andrea", g1, 1032131241, 1.62, 57.3, "F", 22, e3, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c5 = new Cliente("Juan", g1, 1012314134, 1.82, 75.2, "M", 24, e3, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c6 = new Cliente("José", g2, 45453453, 1.72, 71.2, "M", 38, e4, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c7 = new Cliente("Andrés", g2, 234534536, 1.72, 71.2, "M", 51, e4, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c8 = new Cliente("Felipe", g2, 636346633, 1.72, 71.2, "M", 19, e5, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c9 = new Cliente("Sofía", g2, 1934285823, 1.62, 57.3, "F", 22, e6, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c10 = new Cliente("Juan", g2, 234235234, 1.82, 75.2, "M", 24, e6, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c11 = new Cliente("Rodrigo", g3, 67376535, 1.72, 71.2, "M", 38, e7, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c12 = new Cliente("Juan Esteban", g3, 564656466, 1.72, 71.2, "M", 51, e8, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c13 = new Cliente("Jerónimo", g3, 564564525 , 1.72, 71.2, "M", 19, e9, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c14 = new Cliente("Sara", g3, 451521021, 1.62, 57.3, "F", 22, e8, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c15 = new Cliente("Sergio", g3, 505556567, 1.82, 75.2, "M", 24, e9, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c16 = new Cliente("Esteban", g4, 454534632, 1.72, 71.2, "M", 38, e10, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c17 = new Cliente("Duván", g4, 988152187, 1.72, 71.2, "M", 51, e10, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c18 = new Cliente("Santiago", g4, 72541885 , 1.72, 71.2, "M", 19, e11, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c19 = new Cliente("María", g4, 108286585, 1.62, 57.3, "F", 22, e12, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c20= new Cliente("Manuel", g4, 981818585, 1.82, 75.2, "M", 24, e11, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c21 = new Cliente("Miguel", g5, 234235234 , 1.72, 71.2, "M", 19, e13, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c22 = new Cliente("Andrés", g5, 516455135 , 1.72, 71.2, "M", 19, e13, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c23 = new Cliente("María", g5, 45452123, 1.62, 57.3, "F", 22, e14, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c24 = new Cliente("Manuel", g5, 56475642, 1.82, 75.2, "M", 24, e14, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c25 = new Cliente("Daniel", g5, 536186710, 1.72, 71.2, "M", 17, e15, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c26 = new Cliente("Santiago", g6, 231455123, 1.72, 71.2, "M", 19, e16, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c27 = new Cliente("Santiago", g6, 231241251, 1.72, 71.2, "M", 22, e16, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c28 = new Cliente("María", g6, 11256563, 1.62, 57.3, "F", 22, e16, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c29 = new Cliente("Manuel", g6, 231245235, 1.82, 75.2, "M", 24, e17, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c30 = new Cliente("Daniel", g6, 15589833, 1.72, 71.2, "M", 51, e18, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c31 = new Cliente("Santiago", g7, 233652441, 1.72, 71.2, "M", 19, e19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c32 = new Cliente("Santiago", g7, 231646824, 1.72, 71.2, "M", 22, e19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c33 = new Cliente("María", g7, 545481650, 1.62, 57.3, "F", 22, e20, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c34 = new Cliente("Manuel", g7, 55159047, 1.82, 75.2, "M", 24, e20, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c35 = new Cliente("Juan", g7, 673345170, 1.72, 71.2, "M", 51, e21, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c36 = new Cliente("Carlos", g8, 1241734524, 1.72, 71.2, "M", 19, e22, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c37 = new Cliente("Angerson", g8, 123854422, 1.72, 71.2, "M", 22, e23, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c38 = new Cliente("Sofía", g8, 21426432, 1.62, 57.3, "F", 22, e24, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c39 = new Cliente("Alexis", g8, 23125341, 1.82, 75.2, "M", 24, e22, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c40 = new Cliente("José", g8, 85484824, 1.72, 71.2, "M", 51, e24, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c41 = new Cliente("Miguel Angel", g9, 233652441, 1.72, 71.2, "M", 19, e25, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c42 = new Cliente("Esneider", g9, 231646824, 1.72, 71.2, "M", 22, e25, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c43 = new Cliente("María", g9, 545481650, 1.62, 57.3, "F", 22, e26, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c44 = new Cliente("Manuel", g9, 55159047, 1.82, 75.2, "M", 24, e26, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c45 = new Cliente("Daniel", g9, 673345170, 1.72, 71.2, "M", 51, e27, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c46 = new Cliente("Stiven", g10, 2131251323, 1.72, 71.2, "M", 19, e28, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c47 = new Cliente("Oscar", g10, 25424340, 1.72, 71.2, "M", 22, e28, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c48 = new Cliente("Claudia", g10, 31239421, 1.62, 57.3, "F", 22, e29, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c49 = new Cliente("Walter", g10, 548478957, 1.82, 75.2, "M", 40, e29, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c50 = new Cliente("Miguel", g10, 2312300, 1.72, 71.2, "M", 51, e30, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    
	    //MAQUINA
	    
	    
	    

		Empresa empresa = new Empresa();
		
		// 1. agregarObjetos a Empresa. No necesariamente todo a la vez. Lo puedes ir creando de a poco.
		
		// 2. revisar que la creación de objetos sea correcta.
		
		
		byte opcion;
		String salir = "n";
		
		Cliente miCliente = null;
	
		do {

			println("\n\nMENU PRINCIPAL");
			println("1. Reservar Gimnasio");
			println("2. Recomendación de Plan de Alimentación Semanal");
			println("3. Recomendación de plan de ejercicio semanal");
			println("4. Funcionalidad 4");
			println("5. Funcionalidad 5");
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
					f3();
					break;
				case 4:
					f4();
					break;
				case 5:
					f5();
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
	
	//Salir y guardar
	private static void salirDelSistema(Empresa empresa){
		System.out.println("Le agradecemos por utilizar nuestros servicios/n Vuelva pronto");
		Serializador.serializar(empresa);
		System.exit(0);
	}

	// Funcionalidades
	static void reservarGimnasio(Empresa empresa, Cliente miCliente) {
		print("Ingrese el nombre del gimnasio en el que desea entrenar: ");
		String gimnasioDeseado = readString();
		print("Ingrese la ciudad en la que desea entrenar: ");
		String ciudadGimnasioDeseado = readString();
		print("Ingrese la rutina que va a realizar: ");
		String rutinaDeseada = readString(); // El nombre debe ser igual al del objeto de Rutina
		
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
	
	static void recomendarPlanAlimentacion(Empresa empresa, Cliente miCliente) { //Se va a recomendar un plan de alimentacion		
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
		
	}
	
	static void f4() {
		System.out.println("*Logica funcionalidad 4*");
	}
	
	static void f5() {
		System.out.println("*Logica funcionalidad 5*");
	}
}
