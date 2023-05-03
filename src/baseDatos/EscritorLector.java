package baseDatos;
import gestorAplicacion.clasesPrincipales.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class EscritorLector {
	static File archivo = new File("");
	
	public static void main(String[] args) {
		Alimento papa = new Alimento("Papa", 100, 3, 80, 1); // Nombre, Calorias, Proteina, Carbos, Grasa
		
		try {
			FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
			"\\src\\baseDatos\\temp\\Clientes.txt"));

			ObjectOutputStream o = new ObjectOutputStream(f);
			
			// ESCRIBIR OBJETOS AL ARCHIVO
			o.writeObject(papa);
			
			// CERRAR CONEXIONES ABIERTAS
			o.close();
			f.close();
			
			FileInputStream fi = new FileInputStream(new File(archivo.getAbsolutePath()+
					"\\src\\baseDatos\\temp\\Clientes.txt"));
			
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			// LEER OBJETOS
			Alimento papa1 = (Alimento) oi.readObject();
			
			System.out.println(papa1.toString());
			
			// CERRAR CONEXIONES ABIERTAS
			oi.close();
			fi.close();
		}
		
		catch (FileNotFoundException e) {
			System.out.println("No se encuentra archivo");
			}
			catch (IOException e) {
			System.out.println("Error flujo de inicialización");
			}
			catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		}
	}
