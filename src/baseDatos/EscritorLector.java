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
		Person p1 = new Person("Juan");
		Person p2 = new Person("Rodri");
		
		try {
			FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
			"\\src\\baseDatos\\temp\\Personas.txt"));

			ObjectOutputStream o = new ObjectOutputStream(f);
			
			// ESCRIBIR OBJETOS AL ARCHIVO
			o.writeObject(p1);
			o.writeObject(p2);
			
			// CERRAR CONEXIONES ABIERTAS
			o.close();
			f.close();
			
			FileInputStream fi = new FileInputStream(new File(archivo.getAbsolutePath()+
					"\\src\\baseDatos\\temp\\Personas.txt"));
			
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			// LEER OBJETOS
			Person pr1 = (Person) oi.readObject();
			Person pr2 = (Person) oi.readObject();
			
			System.out.println(pr1.toString());
			System.out.println(pr2.toString());
			
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
