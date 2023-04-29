package uiMain;
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
	}
	
	public static void main(String[] args) {
		byte opcion;
		String salir = "n";
		
		do {
			println("\n\nMENU PRINCIPAL");
			println("1. Reservar Gimnasio");
			println("2. Funcionalidad 2");
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
					f2();
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
	
	
	// Funcionalidades
	static void reservarGimnasio() {
		System.out.println("*Logica Reserva*");
	}
	
	static void f2() {
		System.out.println("*Logica funcionalidad 2*");
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
