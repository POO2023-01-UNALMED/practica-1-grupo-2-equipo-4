package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


import gestorAplicacion.clasesPrincipales.Empresa;

public class Serializador {
    private static File rutaTemp =  new File("src\\baseDatos\\temp");

    public static void serializar (Empresa empresa){
        FileOutputStream fos;
        ObjectOutputStream oos;
        File[] docs = rutaTemp.listFiles();
        PrintWriter pw;

        for (File file: docs){
            try{
                pw = new PrintWriter(file);

            }catch (FileNotFoundException e ){
                e.printStackTrace();
            }
        }
        for (File file: docs){
            if (file.getAbsolutePath().contains("gimnasio")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getGimnasios());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
                
            } else if (file.getAbsolutePath().contains("entrenador")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getEntrenadores());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("cliente")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getClientes());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("maquina")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getMaquinas());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("movimiento")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getMovimientos());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("comida")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getComidas());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("ejercicio")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getEjercicios());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("rutina")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getRutinas());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("planAlimentacion")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getPlanesAlimentacion());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("planEjercicio")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getPlanesEjercicio());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else if (file.getAbsolutePath().contains("alimento")){
                try{
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(empresa.getAlimentos());
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
