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
		
		
		//Alimento
		Alimento a1 = new Alimento("Manzana", 52, 0.3, 14, 0.2, null);
        Alimento a2 = new Alimento("Banana", 96, 1.2, 23, 0.2, null);
        Alimento a3 = new Alimento("Zanahoria", 41, 0.9, 10, 0.2, null);
        Alimento a4 = new Alimento("Tomate", 18, 0.9, 3.9, 0.2, null);
        Alimento a5 = new Alimento("Papa", 77, 2, 17, 0.1, null);
        Alimento a6 = new Alimento("Lechuga", 5, 0.5, 1, 0.1, null);
        Alimento a7 = new Alimento("Espárragos", 20, 2.2, 3.7, 0.2, null);
        Alimento a8 = new Alimento("Brócoli", 55, 3.7, 11, 0.6, null);
        Alimento a9 = new Alimento("Cebolla", 40, 1.1, 9.3, 0.1, null);
        Alimento a10 = new Alimento("Arroz", 130, 2.7, 28, 0.3, null);
        Alimento a11 = new Alimento("Lentejas", 116, 9, 20, 0.4, null);
        Alimento a12 = new Alimento("Garbanzos", 164, 8.9, 27, 2.6, null);
        
        Alimento a13 = new Alimento("Leche", 60, 3.3, 4.8, 3.2, Alergeno.LACTOSA);
        Alimento a14 = new Alimento("Huevo", 155, 12.6, 0.6, 11, Alergeno.HUEVO);
        Alimento a15 = new Alimento("Pollo", 165, 31, 0, 3.6, null);
        
        Alimento a16 = new Alimento("Carne de res", 250, 26, 0, 17, null);
        Alimento a17 = new Alimento("Pescado", 206, 22, 0, 13, null);
        Alimento a18 = new Alimento("Atún", 184, 25, 0, 8, null);
        
        Alimento a19 = new Alimento("Camarones", 85, 18, 0.2, 1.2, Alergeno.MARISCO);
        Alimento a20 = new Alimento("Queso", 402, 25, 1.3, 33, Alergeno.LACTOSA);
        Alimento a21 = new Alimento("Pan", 265, 9, 49, 3.1, Alergeno.GLUTEN);
        Alimento a22 = new Alimento("Mantequilla", 717, 0.9, 0.1, 81, Alergeno.LACTOSA);
        Alimento a23 = new Alimento("Nueces", 654, 15, 13, 65, Alergeno.FRUTOSECO);
        Alimento a24 = new Alimento("Fresas", 32, 0.7, 7.7, 0.3, null);
        Alimento a25 = new Alimento("Sandía", 30, 0.6, 7.6, 0.2, null);
        Alimento a26 = new Alimento("Naranja", 43, 0.9, 9, 0.1, null);
        Alimento a27 = new Alimento("Uva", 69, 0.7, 18, 0.2, null);
        Alimento a28 = new Alimento("Kiwi", 41, 1.1, 9, 0.5, null);
        Alimento a29 = new Alimento("Plátano", 96, 1.2, 23, 0.2, null);
        Alimento a30 = new Alimento("Cereza", 50, 1, 12, 0.3, null);
        Alimento a31 = new Alimento("Pera", 57, 0.4, 15, 0.2, null);
        Alimento a32 = new Alimento("Melón", 34, 0.8, 8.6, 0.2, null);
        Alimento a33 = new Alimento("Piña", 50, 0.5, 13, 0.1, null);
        Alimento a34 = new Alimento("Mango", 60, 0.8, 14, 0.4, null);
        Alimento a35 = new Alimento("Papaya", 43, 0.5, 11, 0.4, null);
        Alimento a36 = new Alimento("Calabaza", 26, 1, 6.5, 0.1, null);
        Alimento a37 = new Alimento("Remolacha", 43, 1.6, 10, 0.1, null);
        Alimento a38 = new Alimento("Espinaca", 23, 2.9, 3.6, 0.4, null);
        Alimento a39 = new Alimento("Coliflor", 25, 1.9, 5, 0.3, null);
        Alimento a40 = new Alimento("Aceite de oliva", 884, 0, 0, 100, null);
        Alimento a41 = new Alimento("Azúcar", 387, 0, 100, 0, null);
        Alimento a42 = new Alimento("Sal", 0, 0, 0, 0, null);
        Alimento a43 = new Alimento("Vinagre", 18, 0, 0.2, 0, null);
        Alimento a44 = new Alimento("Canela", 247, 4, 81, 3.2, null);
        Alimento a45 = new Alimento("Chocolate", 546, 7.8, 57, 31, null);
        Alimento a46 = new Alimento("Miel", 304, 0.3, 82, 0, null);
        Alimento a47 = new Alimento("Avena", 389, 16.9, 66, 6.9, null);
        Alimento a48 = new Alimento("Yogur", 61, 3.5, 4.7, 3.3, Alergeno.LACTOSA);
        Alimento a49 = new Alimento("Aceitunas", 145, 1.2, 3.8, 15, null);
        Alimento a50 = new Alimento("Mermelada", 250, 0.4, 63, 0.2, null);
        Alimento a51 = new Alimento("Avellanas", 628, 15, 17, 61, Alergeno.FRUTOSECO);
		
		// Comida
        
        Comida c1 = new Comida("Desayuno saludable 1", obtenerListaAlimentosDesayuno(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER);
        Comida c2 = new Comida("Desayuno saludable 2", obtenerListaAlimentosDesayuno(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR);
        Comida c3 = new Comida("Desayuno saludable 3", obtenerListaAlimentosDesayuno(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO);
        Comida c4 = new Comida("Desayuno saludable 4", obtenerListaAlimentosDesayuno(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR);
        Comida c5 = new Comida("Desayuno saludable 5", obtenerListaAlimentosDesayuno(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.ACONDICIONAR);
        Comida c6 = new Comida("Desayuno saludable 6", obtenerListaAlimentosDesayuno(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.MANTENER);

        Comida c7 = new Comida("Almuerzo equilibrado 1", obtenerListaAlimentosAlmuerzo(a1, a2, a3), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER);
        Comida c8 = new Comida("Almuerzo equilibrado 2", obtenerListaAlimentosAlmuerzo(a1, a2, a3), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR);
        Comida c9 = new Comida("Almuerzo equilibrado 3", obtenerListaAlimentosAlmuerzo(a1, a2, a3), TipoComida.ALMUERZO, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO);
        Comida c10 = new Comida("Almuerzo equilibrado 4", obtenerListaAlimentosAlmuerzo(a1, a2, a3), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR);
        Comida c11 = new Comida("Almuerzo equilibrado 5", obtenerListaAlimentosAlmuerzo(a1, a2, a3), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.ACONDICIONAR);
        Comida c12 = new Comida("Almuerzo equilibrado 6", obtenerListaAlimentosAlmuerzo(a1, a2, a3), TipoComida.ALMUERZO, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.MANTENER);

        Comida c13 = new Comida("Cena ligera 1", obtenerListaAlimentosCena(a1, a2, a3), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER);
        Comida c14 = new Comida("Cena ligera 2", obtenerListaAlimentosCena(a1, a2, a3), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR);
        Comida c15 = new Comida("Cena ligera 3", obtenerListaAlimentosCena(a1, a2, a3), TipoComida.CENA, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO);
        Comida c16 = new Comida("Cena ligera 4", obtenerListaAlimentosCena(a1, a2, a3), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR);
        Comida c17 = new Comida("Cena ligera 5", obtenerListaAlimentosCena(a1, a2, a3), TipoComida.CENA, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.ACONDICIONAR);
        
		Empresa empresa = new Empresa();
		
		// 1. agregarObjetos a Empresa. No necesariamente todo a la vez. Lo puedes ir creando de a poco.
		
		// 2. revisar que la creación de objetos sea correcta.
		
		byte opcion;
		String salir = "n";
		
		// INICIO DE SESIÓN UTILIZANDO LA IDENTIFICACIÓN DE MI CLIENTE.
		
		println(">>> GIMBRO <<< \nTU ASISTENTE PERSONAL\n");
		print(">>>INICIO DE SESION<<<\nIngrese su identificación: ");
		
		Cliente miCliente = null;

		while (miCliente == null) {
		    int ident = readInt();
		    boolean clienteEncontrado = false;

		    for (Cliente c : empresa.getClientes()) {
		        if (c.getIdentificacion() == ident) {
		            miCliente = c;
		            clienteEncontrado = true;
		            print("\nBienvenido. ¡Es un gusto tenerte de vuelta!");
		            break;
		        }
		    }

		    if (!clienteEncontrado) {
		        println("Identificación incorrecta, no estás suscrito a nuestro gimnasio.\nVuelve a ingresar tu identificación: ");
		    }
		}
		
		
		
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
