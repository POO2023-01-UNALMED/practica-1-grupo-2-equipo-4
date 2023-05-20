package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import gestorAplicacion.clasesHerencia.Movimiento;
import gestorAplicacion.clasesPrincipales.*;

public class Deserializador {
    private static File rutaTemp = new File("src\\baseDatos\\temp");
    public static void desearilizar(Empresa empresa){
        File[] docs = rutaTemp.listFiles();
        FileInputStream fis;
        ObjectInputStream ois;
        for (File file : docs ){
            if (file.getAbsolutePath().contains("gimnasio")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setGimnasios((List<Gimnasio>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("entrenador")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setEntrenadores((List<Entrenador>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("cliente")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setClientes((List<Cliente>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("maquina")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setMaquinas((List<Maquina>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("movimiento")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setMovimientos((List<Movimiento>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("comida")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setComidas((List<Comida>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("ejercicio")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setEjercicios((List<Ejercicio>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("rutina")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setRutinas((List<Rutina>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("planAlimentacion")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setPlanesAlimentacion((List<PlanAlimentacion>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("planEjercicio")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setPlanesEjercicio((List<PlanEjercicio>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("alimento")){
                try {
                    fis = new FileInputStream(file);
                    ois = new ObjectInputStream(fis);

                    empresa.setAlimentos((List<Alimento>) ois.readObject());
                } catch(FileNotFoundException e){
                    e.printStackTrace();
                } catch(IOException e){
                    e.printStackTrace();
                } catch(ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
    }
}