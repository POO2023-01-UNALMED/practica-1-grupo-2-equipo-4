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
		
		Gimnasio[] misGimnasios = {g1, g2, g3, g4, g5, g6, g7, g8, g9, g10};
	
		
		// Entrenadores
		Entrenador e1 = new Entrenador("Felipe", g1, 1837492314, "CARDIO", null, NivelCliente.INTERMEDIO, "MAÑANA");
		Entrenador e2 = new Entrenador("Ricardo", g1, 1927394729, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "TARDE");
		Entrenador e3 = new Entrenador("Andrés", g1, 1834223231, "GIMNASIA", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
		Entrenador e4 = new Entrenador("Felipe", g2, 1481273752, "CARDIO", null, NivelCliente.PRINCIPIANTE, "TARDE");
		Entrenador e5 = new Entrenador("Alfredo", g2, 1245345234, "CROSSFIT", null, NivelCliente.AVANZADO, "MAÑANA");
		Entrenador e6 = new Entrenador("Tomás", g2, 1023948524, "CARDIO", null, NivelCliente.INTERMEDIO, "MAÑANA");
		Entrenador e7 = new Entrenador("Juan", g3, 1234567890, "MUSCULACIÓN", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
		Entrenador e8 = new Entrenador("Pedro", g3, 1234567891, "CARDIO", null, NivelCliente.INTERMEDIO, "TARDE");
		Entrenador e9 = new Entrenador("María", g3, 1234567892, "CROSSFIT", null, NivelCliente.AVANZADO, "MAÑANA");
		Entrenador e10 = new Entrenador("Ana", g4, 1234567893, "GIMNASIA", null, NivelCliente.PRINCIPIANTE, "TARDE");
		Entrenador e11 = new Entrenador("Luis", g4, 1234567894, "MUSCULACIÓN", null, NivelCliente.INTERMEDIO, "MAÑANA");
		Entrenador e12 = new Entrenador("Carlos", g4, 1234567895, "CARDIO", null, NivelCliente.AVANZADO, "TARDE");
		Entrenador e13 = new Entrenador("Laura", g5, 1234567896, "CROSSFIT", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
		Entrenador e14 = new Entrenador("Sofía", g5, 1234567897, "GIMNASIA", null, NivelCliente.INTERMEDIO, "TARDE");
		Entrenador e15 = new Entrenador("Miguel", g5, 1234567898, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "MAÑANA");
		Entrenador e16 = new Entrenador("Elena", g6, 1234567899, "CARDIO", null, NivelCliente.PRINCIPIANTE, "TARDE");
		Entrenador e17 = new Entrenador("Juan", g6, 1234567890, "MUSCULACIÓN", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
	    Entrenador e18 = new Entrenador("María", g6, 234567890, "CARDIO", null, NivelCliente.INTERMEDIO, "TARDE");
	    Entrenador e19 = new Entrenador("Pedro", g7, 345678901, "CROSSFIT", null, NivelCliente.AVANZADO, "MAÑANA");
	    Entrenador e20 = new Entrenador("Laura", g7, 456789012, "GIMNASIA", null, NivelCliente.PRINCIPIANTE, "TARDE");
	    Entrenador e21 = new Entrenador("Carlos", g7, 567890123, "MUSCULACIÓN", null, NivelCliente.INTERMEDIO, "MAÑANA");
	    Entrenador e22 = new Entrenador("Ana", g8, 678901234, "CARDIO", null, NivelCliente.AVANZADO, "TARDE");
	    Entrenador e23 = new Entrenador("Luis", g8, 789012345, "CROSSFIT", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
	    Entrenador e24 = new Entrenador("Sofía", g8, 890123456, "GIMNASIA", null, NivelCliente.INTERMEDIO, "TARDE");
	    Entrenador e25 = new Entrenador("Miguel", g9, 901234567, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "MAÑANA");
	    Entrenador e26 = new Entrenador("Carolina", g9, 1234567891, "CARDIO", null, NivelCliente.PRINCIPIANTE, "TARDE");
	    Entrenador e27 = new Entrenador("Luis", g9, 132142333, "CROSSFIT", null, NivelCliente.PRINCIPIANTE, "MAÑANA");
	    Entrenador e28 = new Entrenador("Sofía", g10, 123124123, "GIMNASIA", null, NivelCliente.INTERMEDIO, "TARDE");
	    Entrenador e29 = new Entrenador("Miguel", g10, 41234123, "MUSCULACIÓN", null, NivelCliente.AVANZADO, "MAÑANA");
	    Entrenador e30 = new Entrenador("Carolina", g10, 234133123, "CARDIO", null, NivelCliente.PRINCIPIANTE, "TARDE");
	    
	    Entrenador[] misEntrenadores = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30};
	    
	    
	    //CLIENTES
	    
	    Cliente c1 = new Cliente("Gilberto", g1, 912384723, 1.72, 71.2, "M", 19, e2, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c2 = new Cliente("Sandro", g1, 42391242, 1.72, 71.2, "M", 19, e1, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c3 = new Cliente("Sebastian", g1, 1025640725, 1.72, 71.2, "M", 19, e2, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c4 = new Cliente("Andrea", g1, 1032131241, 1.62, 57.3, "F", 22, e3, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c5 = new Cliente("Juan", g1, 1012314134, 1.82, 75.2, "M", 24, e3, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c6 = new Cliente("José", g2, 45453453, 1.72, 71.2, "M", 19, e4, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c7 = new Cliente("Andrés", g2, 234534536, 1.72, 71.2, "M", 19, e4, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c8 = new Cliente("Felipe", g2, 636346633, 1.72, 71.2, "M", 19, e5, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c9 = new Cliente("Sofía", g2, 1934285823, 1.62, 57.3, "F", 22, e6, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c10 = new Cliente("Juan", g2, 234235234, 1.82, 75.2, "M", 24, e6, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c11 = new Cliente("Rodrigo", g3, 67376535, 1.72, 71.2, "M", 19, e7, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c12 = new Cliente("Juan Esteban", g3, 564656466, 1.72, 71.2, "M", 19, e8, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c13 = new Cliente("Jerónimo", g3, 564564525 , 1.72, 71.2, "M", 19, e9, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c14 = new Cliente("Sara", g3, 451521021, 1.62, 57.3, "F", 22, e8, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c15 = new Cliente("Sergio", g3, 505556567, 1.82, 75.2, "M", 24, e9, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c16 = new Cliente("Esteban", g4, 454534632, 1.72, 71.2, "M", 19, e10, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.AVANZADO, ObjetivoCliente.AUMENTAR);
	    Cliente c17 = new Cliente("Duván", g4, 988152187, 1.72, 71.2, "M", 19, e10, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c18 = new Cliente("Santiago", g4, 72541885 , 1.72, 71.2, "M", 19, e11, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c19 = new Cliente("María", g4, 108286585, 1.62, 57.3, "F", 22, e12, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c20= new Cliente("Manuel", g4, 981818585, 1.82, 75.2, "M", 24, e11, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c21 = new Cliente("Miguel", g5, 234235234 , 1.72, 71.2, "M", 19, e13, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c22 = new Cliente("Andrés", g5, 516455135 , 1.72, 71.2, "M", 19, e13, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c23 = new Cliente("María", g5, 45452123, 1.62, 57.3, "F", 22, e14, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c24 = new Cliente("Manuel", g5, 56475642, 1.82, 75.2, "M", 24, e14, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c25 = new Cliente("Daniel", g5, 536186710, 1.72, 71.2, "M", 19, e15, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c26 = new Cliente("Santiago", g6, 231455123, 1.72, 71.2, "M", 19, e16, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c27 = new Cliente("Santiago", g6, 231241251, 1.72, 71.2, "M", 19, e16, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c28 = new Cliente("María", g6, 11256563, 1.62, 57.3, "F", 22, e16, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c29 = new Cliente("Manuel", g6, 231245235, 1.82, 75.2, "M", 24, e17, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c30 = new Cliente("Daniel", g6, 15589833, 1.72, 71.2, "M", 19, e18, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c31 = new Cliente("Santiago", g7, 233652441, 1.72, 71.2, "M", 19, e19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c32 = new Cliente("Santiago", g7, 231646824, 1.72, 71.2, "M", 19, e19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c33 = new Cliente("María", g7, 545481650, 1.62, 57.3, "F", 22, e20, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c34 = new Cliente("Manuel", g7, 55159047, 1.82, 75.2, "M", 24, e20, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c35 = new Cliente("Juan", g7, 673345170, 1.72, 71.2, "M", 19, e21, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c36 = new Cliente("Carlos", g8, 1241734524, 1.72, 71.2, "M", 19, e22, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c37 = new Cliente("Angerson", g8, 123854422, 1.72, 71.2, "M", 19, e23, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c38 = new Cliente("Sofía", g8, 21426432, 1.62, 57.3, "F", 22, e24, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c39 = new Cliente("Alexis", g8, 23125341, 1.82, 75.2, "M", 24, e22, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c40 = new Cliente("José", g8, 85484824, 1.72, 71.2, "M", 19, e24, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c41 = new Cliente("Miguel Angel", g9, 233652441, 1.72, 71.2, "M", 19, e25, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c42 = new Cliente("Esneider", g9, 231646824, 1.72, 71.2, "M", 19, e25, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c43 = new Cliente("María", g9, 545481650, 1.62, 57.3, "F", 22, e26, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c44 = new Cliente("Manuel", g9, 55159047, 1.82, 75.2, "M", 24, e26, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c45 = new Cliente("Daniel", g9, 673345170, 1.72, 71.2, "M", 19, e27, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    Cliente c46 = new Cliente("Stiven", g10, 2131251323, 1.72, 71.2, "M", 19, e28, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c47 = new Cliente("Oscar", g10, 25424340, 1.72, 71.2, "M", 19, e28, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR);
	    Cliente c48 = new Cliente("Claudia", g10, 31239421, 1.62, 57.3, "F", 22, e29, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR);
	    Cliente c49 = new Cliente("Walter", g10, 548478957, 1.82, 75.2, "M", 40, e29, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR);
	    Cliente c50 = new Cliente("Miguel", g10, 2312300, 1.72, 71.2, "M", 19, e30, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO);
	    
	    Cliente[] misClientes = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50};
	    
	    //MAQUINA
	    
	    Maquina m1 = new Maquina("Barra", g1);
	    Maquina m2 = new Maquina("Polea", g1);
	    Maquina m3 = new Maquina("Caminadora", g1);
	    g2.agregarMaquina(m1);g2.agregarMaquina(m2);g2.agregarMaquina(m3);
	    Maquina m4 = new Maquina("Remo", g3);
	    Maquina m5 = new Maquina("Polea", g3);
	    Maquina m6 = new Maquina("Caminadora", g3);
	    g4.agregarMaquina(m4);g4.agregarMaquina(m5);g4.agregarMaquina(m6);
	    Maquina m7 = new Maquina("Rodillo", g5);
	    Maquina m8 = new Maquina("Remo", g5);
	    Maquina m9 = new Maquina("Aductores", g5);
	    g6.agregarMaquina(m7);g6.agregarMaquina(m8);g6.agregarMaquina(m9);
	    Maquina m10 = new Maquina("Caminadora", g7);
	    Maquina m11 = new Maquina ("Banco de abdominales", g7);
	    Maquina m12 = new Maquina ("Eliptica", g7);
	    g8.agregarMaquina(m10);g8.agregarMaquina(m11);g8.agregarMaquina(m12);
	    Maquina m13 = new Maquina ("Rodillo", g9);
	    Maquina m14 = new Maquina ("Eliptica", g9);
	    Maquina m15 = new Maquina ("Caminadora", g9);
	    g10.agregarMaquina(m13);g10.agregarMaquina(m14);g10.agregarMaquina(m15);
	    Maquina m16 = new Maquina ("Bicicleta", g4);
	    Maquina m17 = new Maquina ("Banco de abdominales", g4);
	    Maquina m18 = new Maquina ("Banca press", g4);
	    
	    Maquina [] misMaquinas = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18};
	    
	    //MOVIMIENTO
	    Movimiento mo1 = new Movimiento ("Press plano de pecho", TipoEjercicio.EMPUJAR, m1, NivelCliente.INTERMEDIO);
	    Movimiento mo2 = new Movimiento ("Elevaciones frontales", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo3 = new Movimiento ("Escalada", TipoEjercicio.PIERNA, m3, NivelCliente.PRINCIPIANTE);
	    Movimiento mo4 = new Movimiento("Remo a ambas manos", TipoEjercicio.EMPUJAR, m4, NivelCliente.INTERMEDIO);
	    Movimiento mo5 = new Movimiento("Remo en polea baja", TipoEjercicio.HALAR, m5, NivelCliente.AVANZADO);
	    Movimiento mo6 = new Movimiento("Escalada", TipoEjercicio.PIERNA, m6, NivelCliente.PRINCIPIANTE);
	    Movimiento mo7 = new Movimiento("Abdominales con rodillo", TipoEjercicio.EMPUJAR, m7, NivelCliente.AVANZADO);
	    Movimiento mo8 = new Movimiento("Remo al pecho", TipoEjercicio.HALAR, m8, NivelCliente.INTERMEDIO);
	    Movimiento mo9 = new Movimiento("Aductor de cadera", TipoEjercicio.PIERNA, m9, NivelCliente.INTERMEDIO);
	    Movimiento mo10 = new Movimiento("Caminata lenta", TipoEjercicio.CALENTAMIENTO, m15, NivelCliente.PRINCIPIANTE);
	    Movimiento mo11 = new Movimiento("Bicicleta lenta", TipoEjercicio.CARDIO, m16, NivelCliente.PRINCIPIANTE);
	    Movimiento mo12 = new Movimiento ("Correr", TipoEjercicio.CARDIO, m10, NivelCliente.INTERMEDIO);
	    Movimiento mo13 = new Movimiento ("Press de pierna", TipoEjercicio.PIERNA, m18, NivelCliente.AVANZADO);
	    Movimiento mo14 = new Movimiento ("Abdominales", TipoEjercicio.CARDIO, m11, NivelCliente.INTERMEDIO);
	    Movimiento mo15 = new Movimiento ("Aducción de cadera invertida", TipoEjercicio.PIERNA, m9, NivelCliente.PRINCIPIANTE);
	    Movimiento mo16 = new Movimiento ("Prueba de resistencia", TipoEjercicio.CARDIO, m6, NivelCliente.AVANZADO);
	    Movimiento mo17 = new Movimiento ("Prueba de resistencia en bicicleta fija", TipoEjercicio.CARDIO, m16, NivelCliente.INTERMEDIO);
	    Movimiento mo18 = new Movimiento ("Prueba de resistencia en escaladora elíptica", TipoEjercicio.CARDIO, m14, NivelCliente.AVANZADO);
	    Movimiento mo19 = new Movimiento ("Press inclinado de pecho", TipoEjercicio.EMPUJAR, m1, NivelCliente.INTERMEDIO);
	    Movimiento mo20 = new Movimiento ("Press inclinado de hombre", TipoEjercicio.EMPUJAR, m1, NivelCliente.INTERMEDIO);
	    Movimiento mo21 = new Movimiento ("Oblicuos en polea alta", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo22 = new Movimiento ("Encogimiento abdominales en polea alta", TipoEjercicio.HALAR, m2, NivelCliente.AVANZADO);
	    Movimiento mo23 = new Movimiento ("Elevaciones de pierna en polea alta", TipoEjercicio.PIERNA, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo24 = new Movimiento ("Flexion lateral de tronco en polea baja", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo25 = new Movimiento ("Elevaciones frontales con polea baja", TipoEjercicio.HALAR, m2, NivelCliente.PRINCIPIANTE);
	    Movimiento mo26 = new Movimiento ("Face pull", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo27 = new Movimiento ("Pullover con polea alta", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo28 = new Movimiento ("Cruce de poleas de pie", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO);
	    Movimiento mo29 = new Movimiento ("Peso muerto con barra", TipoEjercicio.HALAR, m1, NivelCliente.AVANZADO);
	    Movimiento mo30 = new Movimiento ("Remo inclinado con barra", TipoEjercicio.EMPUJAR, m1, NivelCliente.AVANZADO);
	    Movimiento mo31 = new Movimiento ("Press militar", TipoEjercicio.EMPUJAR, m1, NivelCliente.AVANZADO);
	    Movimiento mo32 = new Movimiento ("Sentadilla con press", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO);
	    Movimiento mo33 = new Movimiento ("Zancada con press", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO);
	    Movimiento mo34 = new Movimiento ("Elevación de pelvis", TipoEjercicio.PIERNA, m11, NivelCliente.PRINCIPIANTE);
	    Movimiento mo35 = new Movimiento ("Sentadilla búlgara", TipoEjercicio.PIERNA, m18, NivelCliente.AVANZADO);
	    Movimiento mo36 = new Movimiento ("Sentadilla búlgara con barra", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO);
	    Movimiento mo37 = new Movimiento ("Triceps con barra", TipoEjercicio.EMPUJAR, m1, NivelCliente.AVANZADO);
	    Movimiento mo38 = new Movimiento ("Peso muerto rumano", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO);
	    Movimiento mo39 = new Movimiento ("Elíptica intensidad máxima", TipoEjercicio.CARDIO, m12, NivelCliente.PRINCIPIANTE);
	    Movimiento mo40 = new Movimiento ("Remo con agarra interno", TipoEjercicio.HALAR, m4, NivelCliente.INTERMEDIO);
	    Movimiento mo41 = new Movimiento ("Extensión sentada de espalda", TipoEjercicio.HALAR, m4, NivelCliente.INTERMEDIO);
	    Movimiento mo42 = new Movimiento ("Tracción de rodillas", TipoEjercicio.PIERNA, m4, NivelCliente.INTERMEDIO);
	    Movimiento mo43 = new Movimiento ("De rodillas cruzado", TipoEjercicio.PIERNA, m4, NivelCliente.AVANZADO);
	    Movimiento mo44 = new Movimiento ("De rodillas cruzado y con elevación", TipoEjercicio.PIERNA, m4, NivelCliente.INTERMEDIO);
	    Movimiento mo45 = new Movimiento ("Sentadilla de pie", TipoEjercicio.PIERNA, m4, NivelCliente.INTERMEDIO);
	    Movimiento mo46 = new Movimiento ("Press de banca con mancuernas", TipoEjercicio.EMPUJAR, m11, NivelCliente.INTERMEDIO);
	    Movimiento mo47 = new Movimiento ("Curl de Bíceps", TipoEjercicio.HALAR, m11, NivelCliente.INTERMEDIO);
	    Movimiento mo48 = new Movimiento ("Press francés", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO);
	    Movimiento mo49 = new Movimiento ("Flexiones", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO);
	    Movimiento mo50 = new Movimiento ("Fondos", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO);
	    Movimiento mo51 = new Movimiento ("Sentadillas con banco", TipoEjercicio.PIERNA, m11, NivelCliente.INTERMEDIO);
	    Movimiento mo52 = new Movimiento ("Hip Thrust", TipoEjercicio.PIERNA, m11, NivelCliente.AVANZADO);
	    Movimiento mo53 = new Movimiento ("Remo con mancuerna", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO);
	    Movimiento mo54 = new Movimiento ("Elevaciones con banco inclinado", TipoEjercicio.ESTIRAMIENTO, m11, NivelCliente.AVANZADO);
	    Movimiento mo55 = new Movimiento ("Abductores", TipoEjercicio.PIERNA, m11, NivelCliente.INTERMEDIO);
	    Movimiento mo56 = new Movimiento ("Aperturas de pectoral", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO);
	    Movimiento mo57 = new Movimiento ("Lumbares", TipoEjercicio.ESTIRAMIENTO, m11, NivelCliente.INTERMEDIO);
	    Movimiento mo58 = new Movimiento ("Tibial anterior", TipoEjercicio.ESTIRAMIENTO, m7, NivelCliente.INTERMEDIO);
	    Movimiento mo59 = new Movimiento ("Vasto interno", TipoEjercicio.ESTIRAMIENTO, m7, NivelCliente.INTERMEDIO);
	    Movimiento mo60 = new Movimiento ("Vasto lateral", TipoEjercicio.ESTIRAMIENTO, m7, NivelCliente.INTERMEDIO);
	    
	    Movimiento[] misMovimientos = {mo1, mo2, mo3, mo4, mo5, mo6, mo7, mo8, mo9, mo10, mo11, mo12, mo13, mo14, mo15, mo16, mo17, mo18, mo19, mo20, mo21, mo22, mo23, mo24, mo25, mo26, mo27, mo28, mo29, mo30, mo31, mo32, mo33, mo34, mo35, mo36, mo37, mo38, mo39, mo40, mo41, mo42, mo43, mo44, mo45, mo46, mo47, mo48, mo49, mo50, mo51, mo52, mo53, mo54, mo55, mo56, mo57, mo58, mo59, mo60};
	    
	    //EJERCICIOS
	    Ejercicio eje1 = Ejercicio.generarEjercicio(mo1, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje2 = Ejercicio.generarEjercicio(mo2, ObjetivoCliente.MANTENER);
	    Ejercicio eje3 = Ejercicio.generarEjercicio(mo3, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje4 = Ejercicio.generarEjercicio(mo4, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje5 = Ejercicio.generarEjercicio(mo5, ObjetivoCliente.DEFINIR);
	    Ejercicio eje6 = Ejercicio.generarEjercicio(mo6, ObjetivoCliente.MANTENER);
	    Ejercicio eje7 = Ejercicio.generarEjercicio(mo7, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje8 = Ejercicio.generarEjercicio(mo8, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje9 = Ejercicio.generarEjercicio(mo9, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje10 = Ejercicio.generarEjercicio(mo10, ObjetivoCliente.DEFINIR);
	    Ejercicio eje11 = Ejercicio.generarEjercicio(mo11, ObjetivoCliente.MANTENER);
	    Ejercicio eje12 = Ejercicio.generarEjercicio(mo12, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje13 = Ejercicio.generarEjercicio(mo13, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje14 = Ejercicio.generarEjercicio(mo14, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje15 = Ejercicio.generarEjercicio(mo15, ObjetivoCliente.DEFINIR);
	    Ejercicio eje16 = Ejercicio.generarEjercicio(mo16, ObjetivoCliente.MANTENER);
	    Ejercicio eje17 = Ejercicio.generarEjercicio(mo17, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje18 = Ejercicio.generarEjercicio(mo18, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje19 = Ejercicio.generarEjercicio(mo19, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje20 = Ejercicio.generarEjercicio(mo20, ObjetivoCliente.DEFINIR);
	    Ejercicio eje21 = Ejercicio.generarEjercicio(mo21, ObjetivoCliente.MANTENER);
	    Ejercicio eje22 = Ejercicio.generarEjercicio(mo22, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje23 = Ejercicio.generarEjercicio(mo23, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje24 = Ejercicio.generarEjercicio(mo24, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje25 = Ejercicio.generarEjercicio(mo25, ObjetivoCliente.DEFINIR);
	    Ejercicio eje26 = Ejercicio.generarEjercicio(mo26, ObjetivoCliente.MANTENER);
	    Ejercicio eje27 = Ejercicio.generarEjercicio(mo27, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje28 = Ejercicio.generarEjercicio(mo28, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje29 = Ejercicio.generarEjercicio(mo29, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje30 = Ejercicio.generarEjercicio(mo30, ObjetivoCliente.DEFINIR);
	    Ejercicio eje31 = Ejercicio.generarEjercicio(mo31, ObjetivoCliente.MANTENER);
	    Ejercicio eje32 = Ejercicio.generarEjercicio(mo32, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje33 = Ejercicio.generarEjercicio(mo33, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje34 = Ejercicio.generarEjercicio(mo34, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje35 = Ejercicio.generarEjercicio(mo35, ObjetivoCliente.DEFINIR);
	    Ejercicio eje36 = Ejercicio.generarEjercicio(mo36, ObjetivoCliente.MANTENER);
	    Ejercicio eje37 = Ejercicio.generarEjercicio(mo37, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje38 = Ejercicio.generarEjercicio(mo38, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje39 = Ejercicio.generarEjercicio(mo39, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje40 = Ejercicio.generarEjercicio(mo40, ObjetivoCliente.DEFINIR);
	    Ejercicio eje41 = Ejercicio.generarEjercicio(mo41, ObjetivoCliente.MANTENER);
	    Ejercicio eje42 = Ejercicio.generarEjercicio(mo42, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje43 = Ejercicio.generarEjercicio(mo43, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje44 = Ejercicio.generarEjercicio(mo44, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje45 = Ejercicio.generarEjercicio(mo45, ObjetivoCliente.DEFINIR);
	    Ejercicio eje46 = Ejercicio.generarEjercicio(mo46, ObjetivoCliente.MANTENER);
	    Ejercicio eje47 = Ejercicio.generarEjercicio(mo47, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje48 = Ejercicio.generarEjercicio(mo48, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje49 = Ejercicio.generarEjercicio(mo49, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje50 = Ejercicio.generarEjercicio(mo50, ObjetivoCliente.DEFINIR);
	    Ejercicio eje51 = Ejercicio.generarEjercicio(mo51, ObjetivoCliente.MANTENER);
	    Ejercicio eje52 = Ejercicio.generarEjercicio(mo52, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje53 = Ejercicio.generarEjercicio(mo53, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje54 = Ejercicio.generarEjercicio(mo54, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje55 = Ejercicio.generarEjercicio(mo55, ObjetivoCliente.DEFINIR);
	    Ejercicio eje56 = Ejercicio.generarEjercicio(mo56, ObjetivoCliente.MANTENER);
	    Ejercicio eje57 = Ejercicio.generarEjercicio(mo57, ObjetivoCliente.BAJARPESO);
	    Ejercicio eje58 = Ejercicio.generarEjercicio(mo58, ObjetivoCliente.ACONDICIONAR);
	    Ejercicio eje59 = Ejercicio.generarEjercicio(mo59, ObjetivoCliente.AUMENTAR);
	    Ejercicio eje60 = Ejercicio.generarEjercicio(mo60, ObjetivoCliente.DEFINIR);
	    
	    Ejercicio[] misEjercicios = {eje1, eje2, eje3, eje4, eje5, eje6, eje7, eje8, eje9, eje10, eje11, eje12, eje13, eje14, eje15, eje16, eje17, eje18, eje19, eje20, eje21, eje22, eje23, eje24, eje25, eje26, eje27, eje28, eje29, eje30, eje31, eje32, eje33, eje34, eje35, eje36, eje37, eje38, eje39, eje40, eje41, eje42, eje43, eje44, eje45, eje46, eje47, eje48, eje49, eje50, eje51, eje52, eje53, eje54, eje55, eje56, eje57, eje58, eje59, eje60};
	    
	    //RUTINA
	    
	    Rutina rut1 = new Rutina("Entrenamiento de Fit Medellin", obtenerRutina(eje1, eje2, eje3), null); 
	    Rutina rut2 = new Rutina("Entrenamiento de Fit Bogota", obtenerRutina(eje4, eje5, eje6), null); 
	    Rutina rut3 = new Rutina("Entrenamiento de Superfit Medellin", obtenerRutina(eje7, eje8, eje9), null);
	    Rutina rut4 = new Rutina("Entrenamiento Bodytech Medellín", obtenerRutina(eje10, eje11, eje12), null);
	    Rutina rut5 = new Rutina("Entrenamiento Bodytech Bogotá", obtenerRutina(eje13, eje14, eje15), null);
	    Rutina rut6 = new Rutina("Entrenamiento Smartfit Medellín", obtenerRutina(eje16, eje17, eje18), null);
	    Rutina rut7 = new Rutina("Entrenamiento Smartfit Bogotá", obtenerRutina(eje19, eje20, eje21), null);
	    Rutina rut8 = new Rutina("Entrenamiento Gymbro Medellín", obtenerRutina(eje22, eje23, eje24), null);
	    Rutina rut9 = new Rutina("Entrenamiento Gymbro Bogotá", obtenerRutina(eje25, eje26, eje27), null);
	    Rutina rut10 = new Rutina("Entrenamiento Superfit Bogotá", obtenerRutina(eje28, eje29, eje30), null);
	    
	    Rutina[] misRutinas = {rut1, rut2, rut3, rut4, rut5, rut6, rut7, rut8, rut9, rut10};
	    
	    
	    //ALIMENTO
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
        
        Alimento[] misAlimentos = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38, a39, a40, a41, a42, a43, a44, a45, a46, a47, a48, a49, a50, a51};
        
	    
	    //COMIDA
	    
        Comida co1 = new Comida("Desayuno saludable 1", obtenerListaAlimentos(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER);
        Comida co2 = new Comida("Desayuno saludable 2", obtenerListaAlimentos(a4, a5, a6), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR);
        Comida co3 = new Comida("Desayuno saludable 3", obtenerListaAlimentos(a10, a13, a14), TipoComida.DESAYUNO, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO);
        Comida co4 = new Comida("Desayuno saludable 4", obtenerListaAlimentos(a7, a8, a9), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR);
        Comida co5 = new Comida("Desayuno saludable 5", obtenerListaAlimentos(a13, a14, a15), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.ACONDICIONAR);
        Comida co6 = new Comida("Desayuno saludable 6", obtenerListaAlimentos(a37, a38, a39), TipoComida.DESAYUNO, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.MANTENER);

        Comida co7 = new Comida("Almuerzo equilibrado 1", obtenerListaAlimentos(a16, a17, a18), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER);
        Comida co8 = new Comida("Almuerzo equilibrado 2", obtenerListaAlimentos(a19, a20, a21), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR);
        Comida co9 = new Comida("Almuerzo equilibrado 3", obtenerListaAlimentos(a49, a50, a51), TipoComida.ALMUERZO, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO);
        Comida co10 = new Comida("Almuerzo equilibrado 4", obtenerListaAlimentos(a22, a23, a24), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR);
        Comida co11 = new Comida("Almuerzo equilibrado 5", obtenerListaAlimentos(a25, a26, a27), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.ACONDICIONAR);
        Comida co12 = new Comida("Almuerzo equilibrado 6", obtenerListaAlimentos(a34, a35, a36), TipoComida.ALMUERZO, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.MANTENER);

        Comida co13 = new Comida("Cena ligera 1", obtenerListaAlimentos(a28, a29, a30), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER);
        Comida co14 = new Comida("Cena ligera 2", obtenerListaAlimentos(a31, a32, a33), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR);
        Comida co15 = new Comida("Cena ligera 3", obtenerListaAlimentos(a10, a11, a12), TipoComida.CENA, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO);
        Comida co16 = new Comida("Cena ligera 4", obtenerListaAlimentos(a41, a42, a44), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR);
        Comida co17 = new Comida("Cena ligera 5", obtenerListaAlimentos(a25, a26, a27), TipoComida.CENA, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.ACONDICIONAR);
        
        Comida [] misComidas = {co1, co2, co3, co4, co5, co6, co7, co8, co9, co10, co11, co12, co13, co14, co15, co16, co17};
        
        
        //PLAN ALIMENTACIÓN
        PlanAlimentacion p1 = new PlanAlimentacion("Plan Vegetariano", obtenerPlanAlim(co3, co9, co15, co3, co9, co15));
        PlanAlimentacion p2 = new PlanAlimentacion("Plan Vegano", obtenerPlanAlim(co6, co12, co17, co6, co12, co17));
        PlanAlimentacion p3 = new PlanAlimentacion("Plan completo 1", obtenerPlanAlim(co1, co7, co13, co2, co8, co14));
        PlanAlimentacion p4 = new PlanAlimentacion("Plan completo 2", obtenerPlanAlim(co4, co10, co16, co4, co10, co16));
        PlanAlimentacion p5 = new PlanAlimentacion("Plan completo 3", obtenerPlanAlim(co5, co11, co17, co6, co12, co13));
        PlanAlimentacion p6 = new PlanAlimentacion("Plan completo 4", obtenerPlanAlim(co1, co7, co13, co2, co8, co14));
        PlanAlimentacion p7 = new PlanAlimentacion("Plan coompleto 5", obtenerPlanAlim(co2, co12, co16, co5, co10, co15));
        PlanAlimentacion p8 = new PlanAlimentacion("Plan completo 6", obtenerPlanAlim(co3, co11, co14, co4, co12, co16));
        PlanAlimentacion p9 = new PlanAlimentacion("Plan completo 7", obtenerPlanAlim(co4, co10, co17, co3, co11, co17));
        PlanAlimentacion p10 = new PlanAlimentacion("Plan completo 8", obtenerPlanAlim(co5, co9, co13, co2, co7, co13));
        
        PlanAlimentacion[] misPlanesAlimentacion = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
        

		Empresa empresa = new Empresa();
		
		// 1. agregarObjetos a Empresa. No necesariamente todo a la vez. Lo puedes ir creando de a poco.
		
		// 2. revisar que la creación de objetos sea correcta.
		
		empresa.agregarObjetosGimnasio(misGimnasios); 
		empresa.agregarObjetosEntrenador(misEntrenadores); 
		empresa.agregarObjetosCliente(misClientes);
		empresa.agregarObjetosMaquina(misMaquinas);
		empresa.agregarObjetosMovimiento(misMovimientos);
		empresa.agregarObjetosEjercicio(misEjercicios);
		empresa.agregarObjetosRutina(misRutinas);
		empresa.agregarObjetosAlimentos(misAlimentos);
		empresa.agregarObjetosComida(misComidas);
		empresa.agregarObjetosPlanAlimentacion(misPlanesAlimentacion);
		
		
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
	
	private static HashMap<DiaSemana, ArrayList<Comida>> obtenerPlanAlim(Comida co3, Comida co9, Comida co15, 
			Comida co32, Comida co92, Comida co152) {
        ArrayList<Comida> listaComidas1 = new ArrayList<>();
        listaComidas1.add(co3); listaComidas1.add(co9);  listaComidas1.add(co15);
        
        ArrayList<Comida> listaComidas2 = new ArrayList<>();
        listaComidas2.add(co32); listaComidas2.add(co92);  listaComidas2.add(co152); 
        
        HashMap<DiaSemana, ArrayList<Comida>> planAlim = new HashMap<>();
        
        planAlim.put(DiaSemana.LUNES, listaComidas1);
        planAlim.put(DiaSemana.MARTES, listaComidas2);
        planAlim.put(DiaSemana.MIERCOLES, listaComidas1);
        planAlim.put(DiaSemana.JUEVES, listaComidas2);
        planAlim.put(DiaSemana.VIERNES, listaComidas1);
        planAlim.put(DiaSemana.SABADO, listaComidas2);
        planAlim.put(DiaSemana.DOMINGO, listaComidas1);
        
        return planAlim;
    }
	
	private static ArrayList<Ejercicio> obtenerRutina(Ejercicio e1, Ejercicio e2, Ejercicio e3) {
        ArrayList<Ejercicio> listaEjercicios = new ArrayList<>();
        listaEjercicios.add(e1);
        listaEjercicios.add(e2);
        listaEjercicios.add(e3);
        return listaEjercicios;
    }
	private static ArrayList<Alimento> obtenerListaAlimentos(Alimento a1, Alimento a2, Alimento a3) {
        ArrayList<Alimento> listaAlimentos = new ArrayList<>();
        listaAlimentos.add(a1);
        listaAlimentos.add(a2);
        listaAlimentos.add(a3);
        return listaAlimentos;
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